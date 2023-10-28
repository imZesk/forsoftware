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
			String[] nomDatos = {"ID (solo 4 digitos)", "nombre (solo letras) ", "numeroDeParticipante (solo numeros)", "fechaInicio (con formato dd/mm/yyyy)", "fehcaAcabadoEstimado (con formato dd/mm/yyyy)", 
					"gastos (numeros con dos decimales)", "TipoDeProyecto (Software o Proyectos", "EstadoProyecto"};
			String[] valores = new String[nomDatos.length];
			String[] regexPatterns = {"\\d{4}", "[a-zA-Z]+", "\\d+", "\\d{2}/\\d{2}/\\d{4}", "\\d{2}/\\d{2}/\\d{4}", "\\d+\\.\\d{2}", "[Ss]oftware|[Mm]ultimedia", "Pendiente"};		
			
			//el estado del proyecto al crearlo siempre es pendiente
			valores[nomDatos.length - 1] = "Pendiente";
			
			for (int i = 0; i < nomDatos.length; i++) {
				while (valores[i] == null || valores[i].isEmpty()) {
					valores[i] = JOptionPane.showInputDialog("Ingrese " + nomDatos[i] + ": ");
					if (valores[i] == null) {
						JOptionPane.showMessageDialog(null, "Debe proporcionar un valor para " + nomDatos[i]);
					}
				}
			}
			
			for (int i = 0; i < nomDatos.length; i++) {
				System.out.println(nomDatos[i] + ": " + valores[i]);
			}




			/*String datoProyecto = JOptionPane.showInputDialog("Introduce el " + nomDatos[i] + " del proyecto");
	            if(datoProyecto != null && !datoProyecto.isEmpty()){
	                model.addRow(new Object[]{idTrabajador, "Nombre", "Apellido", "Género", "Provincia", "Telefono", "Correo de empresa", "Sueldo"});
	            }else{
	                JOptionPane.showMessageDialog(null, "Por favor, introduce un ID válido");
	            }*/	            	            
		});
	}
}

//cuando pones el raton encima aparece una lista de algo --> jdialog