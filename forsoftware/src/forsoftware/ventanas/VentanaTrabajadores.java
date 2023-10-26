package forsoftware.ventanas;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTrabajadores extends JFrame{

	private static final long serialVersionUID = 1L;

	public VentanaTrabajadores() {

        JFrame ventana = new JFrame("Lista de Trabajadores");

        // Crear los datos de ejemplo 
        String[] columnas = {"ID", "Nombre", "Apellido", "Género", "Provincia", "Telefono", "Correo de empresa", "Sueldo"};
        String[][] datos = {
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            {"1112", "Juan", "Pérez", "hombre", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
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
        
        JButton botonAnyadir = new JButton("Añadir trabajador");
        JButton botonEliminar = new JButton("Eliminar trabajador");
        panelBotones.add(botonAnyadir);
        panelBotones.add(botonEliminar);
        
        ventana.add(scrollPane, BorderLayout.CENTER);
        ventana.add(panelBotones, BorderLayout.SOUTH);

       
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(700, 350);
        
        botonEliminar.addActionListener(e ->{ 
                int filaSeleccionada = tabla.getSelectedRow();
                if(filaSeleccionada >= 0){
                    model.removeRow(filaSeleccionada);
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila primero");
                }
            
        });
        
        botonAnyadir.addActionListener(e ->{
                String idTrabajador = JOptionPane.showInputDialog("Introduce el ID del trabajador");
                if(idTrabajador != null && !idTrabajador.isEmpty()){
                    model.addRow(new Object[]{idTrabajador, "Nombre", "Apellido", "Género", "Provincia", "Telefono", "Correo de empresa", "Sueldo"});
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un ID válido");
                }
            
        });


        ventana.setVisible(true);
    }

	public static void main(String[] args) {
		new VentanaTrabajadores();
	}
}

