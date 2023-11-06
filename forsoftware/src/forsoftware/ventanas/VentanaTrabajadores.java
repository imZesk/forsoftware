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
                {"1112", "Juan", "Perez", "hombre", "programador", "Vizcaya","111111111", "Juan.Perez@forsoftware.es", "5000.00"},
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

	        for (int pos = 0; pos < nomDatos.length; pos++) {
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
					String[] valores = new String[nomDatos.length];
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

			        for (int i = 0; i < nomDatos.length; i++) {
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
			            String correo = valores[1] + "." + valores[2] + "@forsoftware.es";
			            model.addRow(new Object[]{valores[0], valores[1], valores[2], sexo, puesto, valores[3], valores[4], correo, valores[5]});
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
	        
        });
        
        JButton botonEditar = new JButton("Editar trabajador"); 
        panelBotones.add(botonEditar); 

        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int filaSeleccionada = tabla.getSelectedRow();
            	    if (filaSeleccionada != -1) {
            	    	JDialog ventanillaEditar = new JDialog();
            	        ventanillaEditar.setTitle("Editar Datos del Trabajador");
            	        ventanillaEditar.setLayout(new BorderLayout());

            	        // Tus campos de entrada aquí
            	        // ...
            	        JPanel panelDeDatos = new JPanel(new GridLayout(9, 2));
            	        JTextField[] jTextIntroducido = new JTextField[7];
            	        Color[] colorDefecto = new Color[7]; //para poner el fondo de nuevo en blanco
            	        String[] nomDatos = {"ID (4 dígitos)", "Nombre (solo letras)", "Apellido (solo letras)",
            	        "Provincia (solo letras)", "Telefono (9 digitos)", "Correo de empresa", "Sueldo (numero con dos decimales)"};

            	        for (int pos = 0; pos < nomDatos.length; pos++) {
            	            JLabel label = new JLabel(nomDatos[pos]);
            	            jTextIntroducido[pos] = new JTextField();
            	            colorDefecto[pos] = jTextIntroducido[pos].getBackground(); // guardar el color defecto(blanco)
            	            panelDeDatos.add(label);
            	            panelDeDatos.add(jTextIntroducido[pos]);
            	        }

            	        // Rellenar los campos de entrada con los datos del trabajador seleccionado
            	        for (int pos = 0; pos < nomDatos.length; pos++) {
            	        	
            	            jTextIntroducido[0].setText((String) tabla.getValueAt(filaSeleccionada, 0));
            	            jTextIntroducido[1].setText((String) tabla.getValueAt(filaSeleccionada, 1));
            	            jTextIntroducido[2].setText((String) tabla.getValueAt(filaSeleccionada, 2));
            	            jTextIntroducido[3].setText((String) tabla.getValueAt(filaSeleccionada, 5));
            	            jTextIntroducido[4].setText((String) tabla.getValueAt(filaSeleccionada, 6));
            	            jTextIntroducido[5].setText((String) tabla.getValueAt(filaSeleccionada, 7));
            	            jTextIntroducido[6].setText((String) tabla.getValueAt(filaSeleccionada, 8));
            	           
            	        }
            	        jTextIntroducido[5].setEditable(false);

            	        JPanel comboBoxPanel = new JPanel();
            	        JLabel labelGenero = new JLabel("Género:");
            	        JComboBox<Sexo> comboBoxGenero = new JComboBox<>(Sexo.values());
            	        comboBoxGenero.setSelectedItem(tabla.getValueAt(filaSeleccionada, 3));
            	        comboBoxPanel.add(labelGenero);
            	        comboBoxPanel.add(comboBoxGenero);
            	        
            	        JLabel labelPuesto = new JLabel("Puesto:");
            	        JComboBox<Puesto> comboBoxPuesto = new JComboBox<>(Puesto.values());
            	        comboBoxPuesto.setSelectedItem(tabla.getValueAt(filaSeleccionada, 4));
            	        comboBoxPanel.add(labelPuesto);
            	        comboBoxPanel.add(comboBoxPuesto);

            	        JPanel botonPanel = new JPanel(); 
            	        JButton botonAceptar = new JButton("Aceptar");
            	        JButton botonCancelar = new JButton("Cancelar");
            	        botonPanel.add(botonAceptar);
            	        botonPanel.add(botonCancelar);
            	        
            	        botonAceptar.addActionListener(new ActionListener() {
            				
            				@Override
            				public void actionPerformed(ActionEvent e) {
            					String[] valores = new String[nomDatos.length];
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
            					
            					
            					
            					String[] limitaciones = {"\\d{4}", "[a-zA-Z ]+", "[a-zA-Z ]+", "[a-zA-Z ]+", "\\d{9}", ".*", "\\d+\\.\\d{2}"};

            			        for (int i = 0; i < nomDatos.length; i++) {
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
            			            String correo = valores[1] + "." + valores[2] + "@forsoftware.es";
            			            model.removeRow(filaSeleccionada);
            			            model.addRow(new Object[]{valores[0], valores[1], valores[2], sexo, puesto, valores[3], valores[4], correo, valores[6]});
            			            ventanillaEditar.dispose();
            			        } else {
            			            JOptionPane.showMessageDialog(ventanillaEditar, "Los datos introducidos tienen algún fallo. Por favor, verifique los campos resaltados en rojo.");
            			        }
            					
            					
            				}
            			});
            	        
            	        botonCancelar.addActionListener(new ActionListener() {
            	        	public void actionPerformed(ActionEvent e) {
            	        		ventanillaEditar.dispose();
            	        	}
            	        });
            	        
            	        
            	        ventanillaEditar.add(panelDeDatos, BorderLayout.CENTER);
            	        ventanillaEditar.add(comboBoxPanel, BorderLayout.NORTH);
            	        ventanillaEditar.add(botonPanel, BorderLayout.SOUTH);

            	        ventanillaEditar.pack();
            	        ventanillaEditar.setVisible(true);
            	        ventanillaEditar.setLocationRelativeTo(null);
            	    } else {
            	        JOptionPane.showMessageDialog(null, "Por favor, selecciona un trabajador para editar");
            	    }
            }
        });



    }


}

