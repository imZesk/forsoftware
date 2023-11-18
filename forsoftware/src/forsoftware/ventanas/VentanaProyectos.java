package forsoftware.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import forsoftware.clases.Proyectos.EstadoProyecto;
import forsoftware.clases.Proyectos.TipoDeProyecto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class VentanaProyectos extends JPanel{

	private static final long serialVersionUID = 1L;

	public VentanaProyectos() {


		// Crear los datos de ejemplo 
		String[] columnas = {"ID", "Nombre", "nº participantes", "FechaInicio", "FechaAcabado", "Gastos", "Tipo", "Estado"};
		String[][] datos = {
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","software", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "Pendiente"},
				{"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00","multimedia", "Pendiente"},

		};
		

			

		DefaultTableModel model = new DefaultTableModel(datos, columnas) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Hace que todas las celdas sean de solo lectura
			}
		};
		
		String fichero = "src/Proyectos.csv";
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				model.addRow(data);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JTable tabla = new JTable(model);
		TableRowSorter<TableModel> organizador = new TableRowSorter<TableModel>(tabla.getModel());
		tabla.setRowSorter(organizador);
		JScrollPane scrollPane = new JScrollPane(tabla);
		JPanel panelBotones = new JPanel();

		JButton botonAnyadir = new JButton("Añadir Proyecto");
		JButton botonEliminar = new JButton("Anular Proyecto");
		JButton botonEditar = new JButton("Editar proyecto");
		
		panelBotones.add(botonAnyadir);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonEditar);


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
		
		//----------------------------------------------------------------------------------------------------
		//Funcion del botonEditar-----------------------------------------------------------------------------
        botonEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int filaSeleccionada = tabla.getSelectedRow();
            	    if (filaSeleccionada != -1) {
            	    	JDialog ventanillaEditar = new JDialog();
            	        ventanillaEditar.setTitle("Editar Datos del Proyecto");
            	        ventanillaEditar.setLayout(new BorderLayout());

            	        // Tus campos de entrada aquí
            	        // ...
            	        JPanel panelDeDatos = new JPanel(new GridLayout(8, 2));
            	        JTextField[] jTextIntroducido = new JTextField[6];
            	        Color[] colorDefecto = new Color[6]; //para poner el fondo de nuevo en blanco
            	        String[] nomDatos = {"ID (4 dígitos)", "Nombre (solo letras)", "Número de Participante", "Fecha de Inicio",
            	        		"Fecha de Acabado Estimado", "Gastos (dos decimales)"};

            	        for (int pos = 0; pos < nomDatos.length; pos++) {
            	            JLabel label = new JLabel(nomDatos[pos]);
            	            jTextIntroducido[pos] = new JTextField();
            	            colorDefecto[pos] = jTextIntroducido[pos].getBackground(); // guardar el color defecto(blanco)
            	            panelDeDatos.add(label);
            	            panelDeDatos.add(jTextIntroducido[pos]);
            	        }

            	        // Rellenar los campos de entrada con los datos del proyecto seleccionado
            	        for (int pos = 0; pos < nomDatos.length; pos++) {
            	        	
            	            jTextIntroducido[0].setText((String) tabla.getValueAt(filaSeleccionada, 0));
            	            jTextIntroducido[1].setText((String) tabla.getValueAt(filaSeleccionada, 1));
            	            jTextIntroducido[2].setText((String) tabla.getValueAt(filaSeleccionada, 2));
            	            jTextIntroducido[3].setText((String) tabla.getValueAt(filaSeleccionada, 3));
            	            jTextIntroducido[4].setText((String) tabla.getValueAt(filaSeleccionada, 4));
            	            jTextIntroducido[5].setText((String) tabla.getValueAt(filaSeleccionada, 5));

            	           
            	        }
            	        jTextIntroducido[0].setEditable(false);

            	        JPanel comboBoxPanel = new JPanel();
            	        JLabel labelTipo = new JLabel("Tipo de Proyecto:");
            	        JComboBox<TipoDeProyecto> comboBoxTipo = new JComboBox<>(TipoDeProyecto.values());
            	        comboBoxTipo.setSelectedItem(tabla.getValueAt(filaSeleccionada, 7));
            	        comboBoxPanel.add(labelTipo);
            	        comboBoxPanel.add(comboBoxTipo);
            	        
            	        JLabel labelEstado = new JLabel("Estado del proyecto:");
            	        JComboBox<EstadoProyecto> comboBoxEstado = new JComboBox<>(EstadoProyecto.values());
            	        comboBoxEstado.setSelectedItem(tabla.getValueAt(filaSeleccionada, 6));
            	        comboBoxPanel.add(labelEstado);
            	        comboBoxPanel.add(comboBoxEstado);

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
            					
            					TipoDeProyecto TipoProyecto = (TipoDeProyecto) comboBoxTipo.getSelectedItem();
            					if (TipoProyecto == null) {
            						comboBoxTipo.setBackground(Color.PINK); // Marcar en rojo si no se selecciona un valor
            	                    validar = false;;
            	                } else {
            	                	comboBoxTipo.setBackground(Color.WHITE); // Restablecer el color de fondo
            	                }
            					
            					EstadoProyecto EstadoProyect = (EstadoProyecto) comboBoxEstado.getSelectedItem();
            					if (EstadoProyect == null) {
            						comboBoxEstado.setBackground(Color.PINK); // Marcar en rojo si no se selecciona un valor
            	                    validar = false;;
            	                } else {
            	                	comboBoxEstado.setBackground(Color.WHITE); // Restablecer el color de fondo
            	                }
            					
				
            					for (int i = 0; i < 6; i++) {
            						valores[i] = jTextIntroducido[i].getText();

            						// Aplicar limitaciones específicas para cada campo
            						if (i == 0 && !valores[i].matches("\\d{4}")) { // ID (4 dígitos)
            							jTextIntroducido[i].setBackground(Color.PINK);
            							validar = false;
            						} else if (i == 1 && !valores[i].matches("[a-zA-Z0-9]+")) { // Nombre (solo letras)
            							jTextIntroducido[i].setBackground(Color.PINK);
            							validar = false;
            						} else if (i == 2 && !valores[i].matches("\\d+")) { // numeroDeParticipante (solo numeros)
            							jTextIntroducido[i].setBackground(Color.PINK);
            							validar = false;
            						} else if (i == 3 && !valores[i].matches("\\d{2}/\\d{2}/\\d{4}")) { // fechaInicio (con formato dd/mm/yyyy)
            							jTextIntroducido[i].setBackground(Color.PINK);
            							validar = false;
            						} else if (i == 4 && !valores[i].matches("\\d{2}/\\d{2}/\\d{4}")) { // fehcaAcabadoEstimado (con formato dd/mm/yyyy)
            							jTextIntroducido[i].setBackground(Color.PINK);
            							validar = false;
            						} else if (i == 5 && !valores[i].matches("\\d+\\.\\d{2}")) { // gastos (numeros con dos decimales)
            							jTextIntroducido[i].setBackground(Color.PINK);
            							validar = false;
            						} else {
            							jTextIntroducido[i].setBackground(colorDefecto[i]);  // poner el fondo a blanco a los textfields corregidos
            						} 
            					}

            					if (validar) {
            			            model.removeRow(filaSeleccionada);
            			            model.addRow(new Object[]{valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], TipoProyecto, EstadoProyect});

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
            	        JOptionPane.showMessageDialog(null, "Por favor, selecciona un proyecto para editar");
            	    }
            }
        });
		
		
		//----------------------------------------------------------------------------------------------------
		//Funcion del botonAnyadir----------------------------------------------------------------------------
		botonAnyadir.addActionListener(e ->{
			JDialog ventanillaAnyadir = new JDialog();
	        ventanillaAnyadir.setTitle("Ingresar Datos del Proyecto");
	        ventanillaAnyadir.setLayout(new BorderLayout());

	        // Campos de entrada
	        JPanel panelDeDatos = new JPanel(new GridLayout(8, 2));
	        JTextField[] jTextIntroducido = new JTextField[6];
	        Color[] colorDefecto = new Color[6]; //para poner el fondo de nuevo en blanco
	        String[] nomDatos = {"ID (4 dígitos)", "Nombre (solo letras)", "Número de Participante", "Fecha de Inicio",
	        		"Fecha de Acabado Estimado", "Gastos (dos decimales)"};

	        for (int pos = 0; pos < 6; pos++) {
	            JLabel label = new JLabel(nomDatos[pos]);
	            jTextIntroducido[pos] = new JTextField();
	            colorDefecto[pos] = jTextIntroducido[pos].getBackground(); // guardar el color defecto(blanco)
	            panelDeDatos.add(label);
	            panelDeDatos.add(jTextIntroducido[pos]);
	        }
	        
	        
	        //combobox para escoger el tipo de proyecto
	        JPanel comboBoxPanel = new JPanel();
	        JLabel labelTipoProyecto = new JLabel("Tipo de Proyecto:");
	        JComboBox<TipoDeProyecto> comboBoxTipoProyecto = new JComboBox<>(TipoDeProyecto.values());
	        comboBoxTipoProyecto.setSelectedItem(null);
	        comboBoxPanel.add(labelTipoProyecto);
	        comboBoxPanel.add(comboBoxTipoProyecto);
	        
	        
	        //parte de los botones
	        JPanel botonPanel = new JPanel(); 
	        JButton botonAceptar = new JButton("Aceptar");
	        JButton botonCancelar = new JButton("Cancelar");
	        botonPanel.add(botonAceptar);
	        botonPanel.add(botonCancelar);
	        


	        botonAceptar.addActionListener(new ActionListener() { //combrobar la validez de los datos introcucidos
	            public void actionPerformed(ActionEvent e) {
	            	String[] valores = new String[nomDatos.length];
	            	boolean validar = true;
	            	
	
	            	TipoDeProyecto tipoProyecto = (TipoDeProyecto) comboBoxTipoProyecto.getSelectedItem();

	            	if (tipoProyecto == null) {
	                    comboBoxTipoProyecto.setBackground(Color.PINK); // Marcar en rojo si no se selecciona un valor
	                    validar = false;;
	                } else {
	                    comboBoxTipoProyecto.setBackground(Color.WHITE); // Restablecer el color de fondo
	                }
	            	
	               
	                for (int i = 0; i < 6; i++) {
	                    valores[i] = jTextIntroducido[i].getText();

	                    // Aplicar limitaciones específicas para cada campo
	                    if (i == 0 && !valores[i].matches("\\d{4}")) { // ID (4 dígitos)
	                        jTextIntroducido[i].setBackground(Color.PINK);
	                        validar = false;
	                    } else if (i == 1 && !valores[i].matches("[a-zA-Z0-9]+")) { // Nombre (solo letras)
	                        jTextIntroducido[i].setBackground(Color.PINK);
	                        validar = false;
	                    } else if (i == 2 && !valores[i].matches("\\d+")) { // numeroDeParticipante (solo numeros)
	                        jTextIntroducido[i].setBackground(Color.PINK);
	                        validar = false;
	                    } else if (i == 3 && !valores[i].matches("\\d{2}/\\d{2}/\\d{4}")) { // fechaInicio (con formato dd/mm/yyyy)
	                        jTextIntroducido[i].setBackground(Color.PINK);
	                        validar = false;
	                    } else if (i == 4 && !valores[i].matches("\\d{2}/\\d{2}/\\d{4}")) { // fehcaAcabadoEstimado (con formato dd/mm/yyyy)
	                        jTextIntroducido[i].setBackground(Color.PINK);
	                        validar = false;
	                    } else if (i == 5 && !valores[i].matches("\\d+\\.\\d{2}")) { // gastos (numeros con dos decimales)
	                        jTextIntroducido[i].setBackground(Color.PINK);
	                        validar = false;
	                    } else {
	                        jTextIntroducido[i].setBackground(colorDefecto[i]);  // poner el fondo a blanco a los textfields corregidos
	                    } 
	                }

	                if (validar) {
	                    String estado = "Pendiente"; // Valor predeterminado para el Estado de Proyecto

	                    model.addRow(new Object[]{valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], tipoProyecto, estado});

	                    // cierra la ventanilla
	                    ventanillaAnyadir.dispose();
	                } else {
	                    // Mostrar un mensaje de error
	                    JOptionPane.showMessageDialog(ventanillaAnyadir, "Los datos introducidos tienen algún fallo. Por favor, verifique los campos resaltados en rojo.");
	                }
	            }
	            
	        });
	        //boton cancelar (solo cierra la ventanilla)
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
		

	}
}

//cuando pones el raton encima aparece una lista de algo --> jdialog
//loggers