package forsoftware.ventanas;
import java.awt.BorderLayout;
import java.util.logging.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import forsoftware.clases.Trabajador.Puesto;
import forsoftware.clases.Trabajador.Sexo;
import forsoftware.renderer.rendererRoles;

public class VentanaTrabajadores extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger( VentanaTrabajadores.class.getName() );


	public VentanaTrabajadores() {

		// Crear los datos de ejemplo 
		String[] columnas = {"ID", "Nombre", "Apellido", "Género", "Puesto", "Provincia", "Telefono", "Correo de empresa", "Sueldo"};
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
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


		JTable tabla = new JTable(model);
		TableRowSorter<TableModel> organizador = new TableRowSorter<TableModel>(tabla.getModel());
		// tabla.getColumnModel().getColumn(4).setCellRenderer(new rendererRoles());
		tabla.setRowSorter(organizador);
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

		//----------------------------------------------------------------------------------------------------
		//Funcion del botonELiminar---------------------------------------------------------------------------
		botonEliminar.addActionListener(e ->{ 
			int filaSeleccionada = tabla.getSelectedRow();
			if(filaSeleccionada >= 0){
				organizador.setRowFilter(null);     // resetear el filtro antes de eliminar la fila para no dar error
				model.removeRow(filaSeleccionada);
				LOGGER.log(Level.INFO, "Trabajador seleccionado eliminado");

				try (FileWriter writer = new FileWriter(fichero, false)) {
					for (int i = 0; i < model.getRowCount(); i++) {
						for (int j = 0; j < model.getColumnCount(); j++) {
							writer.append(model.getValueAt(i, j).toString());
							if (j < model.getColumnCount() - 1) {
								writer.append(';');
							}
						}
						writer.append('\n');
					}
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}

			}else{
				JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila primero");
			}

		});

		//----------------------------------------------------------------------------------------------------
		//Funcion del botonAñadir-----------------------------------------------------------------------------
		botonAnyadir.addActionListener(e ->{
			organizador.setRowFilter(null); // Resetear el filtro antes de agregar una nueva fila
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
						Object[] DatosFila = new Object[] {valores[0], valores[1], valores[2], sexo, puesto, valores[3], valores[4], correo, valores[5]};
						model.addRow(DatosFila);
						LOGGER.log(Level.INFO, "Trabajador creado con exito");



						try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichero, true))) {
							StringBuilder csvLine = new StringBuilder();
							for (int i = 0; i < DatosFila.length; i++) {
								csvLine.append(DatosFila[i].toString());
								if (i < DatosFila.length) {
									csvLine.append(";");
								}
							}

							writer.write(csvLine.toString());
							writer.newLine();
						} catch (IOException ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(ventanillaAnyadir, "Error al escribir en el archivo CSV.");
						}


						ventanillaAnyadir.dispose();
					} else {
						JOptionPane.showMessageDialog(ventanillaAnyadir, "Los datos introducidos tienen algún fallo. Por favor, verifique los campos resaltados en rojo.");
					}


				}
			});

			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LOGGER.log(Level.INFO, "Creacion de trabajador cancelada");
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


		//----------------------------------------------------------------------------------------------------
		//Funcion del botonEditar-----------------------------------------------------------------------------
		botonEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tabla.getSelectedRow();
				if (filaSeleccionada != -1) {
					organizador.setRowFilter(null);  // resetear el filtro antes de editar
					JDialog ventanillaEditar = new JDialog();
					ventanillaEditar.setTitle("Editar Datos del Trabajador");
					ventanillaEditar.setLayout(new BorderLayout());

					// campos de entrada 
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

					// Rellena los campos de entrada con los datos del trabajador seleccionado
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
					jTextIntroducido[0].setEditable(false);

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
								LOGGER.log(Level.INFO, "Trabajador editado con exito");

								ventanillaEditar.dispose();
							} else {
								JOptionPane.showMessageDialog(ventanillaEditar, "Los datos introducidos tienen algún fallo. Por favor, verifique los campos resaltados en rojo.");
								LOGGER.log(Level.INFO, "Error, uno de los campos no esta bien rellenado");

							}

							try (FileWriter writer = new FileWriter(fichero, false)) {
								for (int i = 0; i < model.getRowCount(); i++) {
									for (int j = 0; j < model.getColumnCount(); j++) {
										writer.append(model.getValueAt(i, j).toString());
										if (j < model.getColumnCount() - 1) {
											writer.append(';');
										}
									}
									writer.append('\n');
								}
							} catch (IOException ex) {
								System.out.println(ex.getMessage());
							}


						}

					});

					botonCancelar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							LOGGER.log(Level.INFO, "Editar trabajador cancelado");
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

		//------------------------------------------------------------------------------------------------------------------------
		//Filtro para ventana trabajador
		JTextField filtroTextField = new JTextField(20);
		filtroTextField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filtrar();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filtrar();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filtrar();
			}

			private void filtrar() {
				String filtro = filtroTextField.getText();
				TableRowSorter<TableModel> tableSorter = (TableRowSorter<TableModel>) tabla.getRowSorter();
				tableSorter.setRowFilter(RowFilter.regexFilter(filtro, 0, 1, 2, 3, 4, 5, 6, 7)); //filtrar las columnas 0-7
			}
		});


		JPanel panelFiltro = new JPanel();
		panelFiltro.add(new JLabel("Filtro: "));
		panelFiltro.add(filtroTextField);
		add(panelFiltro, BorderLayout.NORTH);

		//--------------------------------------------------------------------------------------------------------------------------
		//Render para el filtro que hace que ponga en rojo y negrita las letras/numeros del table con lo que introduces en el filtro
		//poner el fondo en gris con la celda seleccioanda
		TableCellRenderer cellRenderer = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel result = new JLabel(value.toString());
			int selectedRow = -1; // Variable para rastrear la fila seleccionada

			if (value != null) {
				String textoCelda = value.toString();
				String textoFiltro = filtroTextField.getText();

				if (!textoFiltro.isBlank() && textoCelda.contains(textoFiltro)) {
					String inicioStr = textoCelda.substring(0, textoCelda.indexOf(textoFiltro));
					String finalStr = textoCelda.substring(textoCelda.indexOf(textoFiltro) + textoFiltro.length());

					result.setText("<html>" + inicioStr + "<font color='red'><strong>" + textoFiltro + "</strong></font>" + finalStr + "</html>");
				}   //"<HTML>" poner en formato HTML para no dar errores de caracteres
			}		//"<STRONG style='color:red'>" poner en negrita y rojo

			if (isSelected) {
				if (selectedRow != -1 && selectedRow != row) {
					// Restablecer el color de fondo de la fila anteriormente seleccionada
					table.setRowSelectionInterval(selectedRow, selectedRow);
				}
				result.setBackground(Color.gray.brighter());
				selectedRow = row; // Actualizar la fila seleccionada
			} else {
				result.setBackground(table.getBackground());
			}
			result.setOpaque(true);
			return result;
		};

		// Aplicar el render en todas la tabla
		tabla.setCellSelectionEnabled(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		tabla.setDefaultRenderer(Object.class, cellRenderer);
		tabla.getColumnModel().getColumn(4).setCellRenderer(new rendererRoles());
	};
}

