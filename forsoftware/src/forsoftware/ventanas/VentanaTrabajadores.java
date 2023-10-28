package forsoftware.ventanas;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTrabajadores extends JPanel{

	private static final long serialVersionUID = 1L;

	public VentanaTrabajadores() {

        // Crear los datos de ejemplo 
        String[] columnas = {"ID", "Nombre", "Apellido", "Género", "Provincia", "Telefono", "Correo de empresa", "Sueldo"};
        String[][] datos = {};

        
        // DefaultTableModel model = new DefaultTableModel(datos, columnas);

 		DefaultTableModel model = new DefaultTableModel(datos, columnas) {
 			private static final long serialVersionUID = 1L;

 			@Override
             public boolean isCellEditable(int row, int column) {
                 return false; // Hace que todas las celdas sean de solo lectura
             }
         };
        
		String fichero = "src/Trabajadores.csv";
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				model.addRow(data);
				//System.out.println("ID: " + data[0] + " Nombre: " + data[1] + " Apellido: " + data[2] + " Género: "
				//		+ data[3] + " Provincia: " + data[4] + " Teléfono: " + data[5] + " Correo de empresa: "
				//		+ data[6] + " Sueldo: " + data[8]);
				System.out.println(data);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JPanel panelBotones = new JPanel();
        JPanel panelBotones2 = new JPanel();
        
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones2, BorderLayout.SOUTH);
        
        JButton botonAnyadir = new JButton("Añadir trabajador");
        JButton botonEliminar = new JButton("Eliminar trabajador");

        panelBotones.add(botonAnyadir);
        panelBotones.add(botonEliminar);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);


        panelBotones2.add(botonAnyadir);
        panelBotones2.add(botonEliminar);

        
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



    }


}

