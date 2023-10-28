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
					"gastos (numeros con dos decimales)", "TipoDeProyecto (Software o Proyectos)", "EstadoProyecto"};
			String[] valores = new String[nomDatos.length];

			//el estado del proyecto al crearlo siempre es pendiente
			valores[nomDatos.length - 1] = "Pendiente";

			for (int i = 0; i < nomDatos.length-1; i++) {  //length-1 par q no pregunte el estado q sera de prederteminado como "pendiente"
				boolean validar = false;
				while (!validar) {
					valores[i] = JOptionPane.showInputDialog("Ingrese " + nomDatos[i] + ": ");
					
					// cancelar el proceso de añadir si se pulsa "Cancelar" o cierra la ventana
					if (valores[i] == null) {
	                    return; // Salir del programa
	                }
					
					
					
					if (!valores[i].isEmpty()) {
						validar = true;

						// Aplicar limitaciones específicas para cada campo
						if (i == 0 && !valores[i].matches("\\d{4}")) { // ID (4 dígitos)
							validar = false;
						} else if (i == 1 && !valores[i].matches("[a-zA-Z]+")) { // Nombre (solo letras)
							validar = false;
						} else if (i == 2 && !valores[i].matches("\\d+")) { // numeroDeParticipante (solo numeros)
							validar = false;
						} else if (i == 3 && !valores[i].matches("\\d{2}/\\d{2}/\\d{4}")) { // fechaInicio (con formato dd/mm/yyyy)
							validar = false;
						} else if (i == 4 && !valores[i].matches("\\d{2}/\\d{2}/\\d{4}")) { // fehcaAcabadoEstimado (con formato dd/mm/yyyy)
							validar = false;
						} else if (i == 5 && !valores[i].matches("\\d+\\.\\d{2}")) { // gastos (numeros con dos decimales)
							validar = false;
						} else if (i == 6 && !valores[i].equalsIgnoreCase("Software") && !valores[i].equalsIgnoreCase("Multimedia")) { // TipoDeProyecto (Software o Proyectos)
							validar = false;
						}
					}
					if (!validar) {
	                    // Si se hace clic en Cancelar, se proporciona una entrada vacía o la entrada no cumple con la validación, se solicitará nuevamente.
	                    JOptionPane.showMessageDialog(null, "Debe proporcionar un valor válido para " + nomDatos[i]);
				}
			}
		}
			model.addRow(valores);
		




			/*
	            if(datoProyecto != null && !datoProyecto.isEmpty()){
	                model.addRow(new Object[]{idTrabajador, "Nombre", "Apellido", "Género", "Provincia", "Telefono", "Correo de empresa", "Sueldo"});
	            }else{
	                JOptionPane.showMessageDialog(null, "Por favor, introduce un ID válido");
	            }*/	            	            
		});
		
		
		
		botonFinalizado.addActionListener(e -> {
			int filaSeleccionada = tabla.getSelectedRow();
		    if(filaSeleccionada >= 0){
		        String estado = model.getValueAt(filaSeleccionada, 7).toString();
		        if(estado.equalsIgnoreCase("pendiente")){
		            model.setValueAt("finalizado", filaSeleccionada, 7);
		        }else{
		            JOptionPane.showMessageDialog(null, "El proyecto ya está finalizado");
		        }
		    }else{
		        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila primero");
		    }
			
		});
	}
}

//cuando pones el raton encima aparece una lista de algo --> jdialog