package forsoftware.ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import forsoftware.clases.Proyectos.TipoDeProyecto;
import forsoftware.clases.Trabajador.Puesto;
import forsoftware.clases.Trabajador.Sexo;

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
        	
        	JDialog ventanillaAnyadir = new JDialog();
	        ventanillaAnyadir.setTitle("Ingresar Datos del Trabajador");
	        ventanillaAnyadir.setLayout(new BorderLayout());

	        // Campos de entrada
	        JPanel panelDeDatos = new JPanel(new GridLayout(8, 2));
	        JTextField[] jTextIntroducido = new JTextField[6];
	        Color[] colorDefecto = new Color[6]; //para poner el fondo de nuevo en blanco
	        String[] nomDatos = {"ID (4 dígitos)", "Nombre (solo letras)", "Apellido (solo letras)",
	        "Provincia (solo letras)", "Telefono (9 digitos)", "Sueldo (numero con dos decimales)"};

	        for (int pos = 0; pos < 6; pos++) {
	            JLabel label = new JLabel(nomDatos[pos]);
	            jTextIntroducido[pos] = new JTextField();
	            colorDefecto[pos] = jTextIntroducido[pos].getBackground(); // guardar el color defecto(blanco)
	            panelDeDatos.add(label);
	            panelDeDatos.add(jTextIntroducido[pos]);
	        }
        	
	        //combobox para escoger el sexo del trabajador
	        JPanel comboBoxPanel = new JPanel();
	        JLabel labelGenero = new JLabel("Género:");
	        JComboBox<Sexo> comboBoxGenero = new JComboBox<>(Sexo.values());
	        comboBoxGenero.setSelectedItem(null);
	        comboBoxPanel.add(labelGenero);
	        comboBoxPanel.add(comboBoxGenero);
	        
	        JLabel labelPuesto = new JLabel("Puesto:");
	        JComboBox<Puesto> comboBoxPuesto = new JComboBox<>(Puesto.values());
	        comboBoxPuesto.setSelectedItem(null);
	        comboBoxPanel.add(labelPuesto);
	        comboBoxPanel.add(comboBoxPuesto);
	        
	        //parte de los botones
	        JPanel botonPanel = new JPanel(); 
	        JButton botonAceptar = new JButton("Aceptar");
	        JButton botonCancelar = new JButton("Cancelar");
	        botonPanel.add(botonAceptar);
	        botonPanel.add(botonCancelar);
	        
	        
	        botonAceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String[] valores = new String[9];
					boolean validar = true;
					
					Sexo sexo = (Sexo) comboBoxGenero.getSelectedItem();
					if (sexo == null) {
						comboBoxGenero.setBackground(Color.PINK); // Marcar en rojo si no se selecciona un valor
	                    validar = false;;
	                } else {
	                	comboBoxGenero.setBackground(Color.WHITE); // Restablecer el color de fondo
	                }
					
					Puesto puesto = (Puesto) comboBoxPuesto.getSelectedItem();
					if (puesto == null) {
						comboBoxPuesto.setBackground(Color.PINK); // Marcar en rojo si no se selecciona un valor
	                    validar = false;;
	                } else {
	                	comboBoxPuesto.setBackground(Color.WHITE); // Restablecer el color de fondo
	                }
					
					
					
					String[] limitaciones = {"\\d{4}", "[a-zA-Z ]+", "[a-zA-Z ]+", "[a-zA-Z ]+", "\\d{9}", "\\d+\\.\\d{2}"};

			        for (int i = 0; i < 6; i++) {
			            valores[i] = jTextIntroducido[i].getText();

			            // Aplicar la limitación correspondiente para cada campo
			            if (!valores[i].matches(limitaciones[i])) {
			                jTextIntroducido[i].setBackground(Color.PINK);
			                validar = false;
			            } else {
			                jTextIntroducido[i].setBackground(colorDefecto[i]);
			            }
			        }

			        if (validar) {
			            valores[7] = valores[1] + "." + valores[2] + "@forsoftware.es";
			            model.addRow(new Object[]{valores[0], valores[1], valores[2], sexo, puesto, valores[3], valores[4], valores[1] + "." + valores[2] + "@forsoftware.es", valores[5]});
			            ventanillaAnyadir.dispose();
			        } else {
			            JOptionPane.showMessageDialog(ventanillaAnyadir, "Los datos introducidos tienen algún fallo. Por favor, verifique los campos resaltados en rojo.");
			        }
					
					
				}
			});
	        
	        botonCancelar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ventanillaAnyadir.dispose();
	        	}
	        });
	         
	        
	        ventanillaAnyadir.add(panelDeDatos, BorderLayout.CENTER);
	        ventanillaAnyadir.add(comboBoxPanel, BorderLayout.NORTH);
	        ventanillaAnyadir.add(botonPanel, BorderLayout.SOUTH);
	        
	        
	        ventanillaAnyadir.pack();
	        ventanillaAnyadir.setVisible(true);
	        ventanillaAnyadir.setLocationRelativeTo(null);
	        
	        
	        
        	/*
        	
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
            
            */
        });


    }


}

