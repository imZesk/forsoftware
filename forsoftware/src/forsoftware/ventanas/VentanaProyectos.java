package forsoftware.ventanas;

import java.awt.BorderLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaProyectos extends JPanel{
	public VentanaProyectos() {


        // Crear los datos de ejemplo 
        String[] columnas = {"ID", "Nombre", "nº participantes", "FechaInicio", "FechaAcabado", "Gastos", "Tipo", "Estado"};
        String[][] datos = {
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "pendiente"},

        };

       // DefaultTableModel model = new DefaultTableModel(datos, columnas);

		DefaultTableModel model = new DefaultTableModel(datos, columnas) {
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas sean de solo lectura
            }
        };
        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JPanel panelBotones = new JPanel();
        
        JButton botonAnyadir = new JButton("Añadir Proyecto");
        JButton botonEliminar = new JButton("Anular Proyecto");
        JButton botonFinalizado = new JButton("Finalizar Proyecto"); //al pulsar este boton hace q el proyecto q esta en estado pendiente se convierta en finalizado
        panelBotones.add(botonAnyadir);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonFinalizado);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        
        botonEliminar.addActionListener(e ->{ 
            int filaSeleccionada = tabla.getSelectedRow();
            if(filaSeleccionada >= 0){
                model.removeRow(filaSeleccionada);
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila primero");
            }
        
    });
        botonAnyadir.addActionListener(e ->{
        	String[] nomDatos = {"ID", "nombre", "numeroDeParticipante", "fechaInicio", "fehcaAcabadoEstimado", "gastos", "TipoDeProyecto", "EstadoProyecto"}; 
        	for (int i = 0; i < nomDatos.length; i++) {
				String datoProyecto = JOptionPane.showInputDialog("Introduce el " + nomDatos[i] + " del proyecto");
	            if(datoProyecto != null && !datoProyecto.isEmpty()){
	                model.addRow(new Object[]{idTrabajador, "Nombre", "Apellido", "Género", "Provincia", "Telefono", "Correo de empresa", "Sueldo"});
	            }else{
	                JOptionPane.showMessageDialog(null, "Por favor, introduce un ID válido");
	            }
			}       
    });
    }

}

//cuando pones el raton encima aparece una lista de algo --> jdialog