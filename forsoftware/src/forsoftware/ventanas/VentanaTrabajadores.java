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
        String[] columnas = {"ID", "Nombre", "Apellido", "Género", "Puesto", "Provincia", "Telefono", "Correo de empresa", "Sueldo"};
        String[][] datos = {
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
                {"1112", "Juan", "Pérez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
            };

        
        // DefaultTableModel model = new DefaultTableModel(datos, columnas);

 		DefaultTableModel model = new DefaultTableModel(datos, columnas) {
 			private static final long serialVersionUID = 1L;

 			@Override
             public boolean isCellEditable(int row, int column) {
                 return false; // Hace que todas las celdas sean de solo lectura
             }
         };
  
         /*
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
		*/


        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JPanel panelBotones = new JPanel();
        
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        JButton botonAnyadir = new JButton("Añadir trabajador");
        JButton botonEliminar = new JButton("Eliminar trabajador");

        panelBotones.add(botonAnyadir);
        panelBotones.add(botonEliminar);
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);


        panelBotones.add(botonAnyadir);
        panelBotones.add(botonEliminar);

        
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
            while(idTrabajador != null && !idTrabajador.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un ID válido (exactamente 4 dígitos)");
                idTrabajador = JOptionPane.showInputDialog("Introduce el ID del trabajador");
            }

            String nombre = JOptionPane.showInputDialog("Introduce el nombre del trabajador");
            while(nombre != null && !nombre.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un nombre válido (solo letras)");
                nombre = JOptionPane.showInputDialog("Introduce el nombre del trabajador");
            }

            String apellido = JOptionPane.showInputDialog("Introduce el apellido del trabajador");
            while(apellido != null && !apellido.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un apellido válido (solo letras)");
                apellido = JOptionPane.showInputDialog("Introduce el apellido del trabajador");
            }

            Object[] generos = {"Hombre", "Mujer", "Otros"};
            String sexo = (String)JOptionPane.showInputDialog(null, "Selecciona el género", "Género", JOptionPane.QUESTION_MESSAGE, null, generos, generos[0]);

            Object[] puestos = {"Programador", "Modelador", "GameDesigner", "Artista", "Escritor", "Video", "Sonido"};
            String puesto = (String)JOptionPane.showInputDialog(null, "Selecciona el puesto", "Puesto", JOptionPane.QUESTION_MESSAGE, null, puestos, puestos[0]);

            String provincia = JOptionPane.showInputDialog("Introduce la provincia del trabajador");
            while(provincia != null && !provincia.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce una provincia válida (solo letras)");
                provincia = JOptionPane.showInputDialog("Introduce la provincia del trabajador");
            }
            
            String telefono = JOptionPane.showInputDialog("Introduce el teléfono del trabajador");
            while(telefono != null && !telefono.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un teléfono válido (exactamente 9 dígitos)");
                telefono = JOptionPane.showInputDialog("Introduce el teléfono del trabajador");
            }

            String sueldo = JOptionPane.showInputDialog("Introduce el sueldo del trabajador");
            while(sueldo != null && !sueldo.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce un sueldo válido (solo números)");
                sueldo = JOptionPane.showInputDialog("Introduce el sueldo del trabajador");
            }

            String correoEmpresa = nombre + "." + apellido + "@forsoftware.es";

            if(idTrabajador != null && nombre != null && apellido != null && sexo != null && puesto != null && provincia != null && telefono != null && sueldo != null){
                model.addRow(new Object[]{idTrabajador, nombre, apellido, sexo, puesto, provincia, telefono, correoEmpresa, sueldo});
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, introduce datos válidos");
            }
        });


    }


}

