package forsoftware.ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class VentanaInicial extends JFrame {
    public VentanaInicial() {
        JTabbedPane tabs = new JTabbedPane();

        // Pestaña 1
        JPanel panel1 = new JPanel(new BorderLayout());

        // Añadir imagen 
        ImageIcon imagen = new ImageIcon("src/usuario.jpg");
        JLabel etiquetaImagen = new JLabel(imagen);
        panel1.add(etiquetaImagen, BorderLayout.WEST);


        // Añadir 3 botones debajo de la ventana  
        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        JButton btnContrasena = new JButton("Cambiar contraseña");
        JButton btnCerrarSesion = new JButton("Cerrar sesion");
        
        panelBotones.add(btnContrasena);
        panelBotones.add(btnCerrarSesion);
        
        btnCerrarSesion.addActionListener(e ->{
        	new VentanaInicioSesion();
        	dispose();
    });
        
        btnContrasena.addActionListener(e ->{
        	String passTest = "Ramon";
            String contOld = JOptionPane.showInputDialog("Introduce tu contraseña actual");
            if(passTest.equals(contOld)){
            	String contNueva1 = JOptionPane.showInputDialog("Introduce tu nueva contraseña");
            	String contNueva2 = JOptionPane.showInputDialog("Introduce de nuevo tu nueva contraseña");
            	if (contNueva1.equals(contNueva2)) {
            		JOptionPane.showMessageDialog(null, "Contraseña cambiada, inicia sesion de nuevo."); // La contraseña no se actualiza por que no tenemos las bases de 
                	new VentanaInicioSesion();															 // datos de usuarios creadas
                	dispose();
				}else {
	                JOptionPane.showMessageDialog(null, "Las ontraseñas no coinciden");
				}            	
            }else{
            	System.out.println(passTest);
            	System.out.println(contOld);
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        
    });

        
 
        panel1.add(panelBotones, BorderLayout.SOUTH);

        // Añadir lista con Jscroll a la derecha 
        String[] elementosLista = {"Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6", "Tarea 7", "Tarea 8", "Tarea 9", "Tarea 10"};
        JList<String> lista = new JList<>(elementosLista);
        JScrollPane scrollLista = new JScrollPane(lista);
        panel1.add(scrollLista, BorderLayout.LINE_END);
        scrollLista.setPreferredSize(new Dimension(150, 0)); // Ancho del scroll
        lista.setFixedCellHeight(30); // aalto de los elementos de la lista
        
         
        
        // Agregar campos de datos 
        JPanel panelDatos = new JPanel(new GridLayout(3, 3, 0, 0));

        // Primer dato
        JLabel etiquetaId = new JLabel("ID: ");
        JTextField campoId = new JTextField("000");
        campoId.setEditable(false);
        campoId.setPreferredSize(new Dimension(120, 10));
        etiquetaId.setPreferredSize(new Dimension(120, 10));
        panelDatos.add(etiquetaId);
        panelDatos.add(campoId);

        // Segundo dato
        JLabel etiquetaNombre = new JLabel("Nombre: ");
        JTextField campoNombre = new JTextField("Ivan");
        campoNombre.setEditable(false);
        campoNombre.setPreferredSize(new Dimension(120, 0));
        etiquetaNombre.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaNombre);
        panelDatos.add(campoNombre);

        // Tercer dato
        JLabel etiquetaApellido = new JLabel("Apellido: ");
        JTextField campoApellido = new JTextField("Chen");
        campoApellido.setEditable(false);
        campoApellido.setPreferredSize(new Dimension(120, 0));
        etiquetaApellido.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaApellido);
        panelDatos.add(campoApellido);

        // Cuarto dato
        JLabel etiquetaSexo = new JLabel("Sexo: ");
        JTextField campoSexo = new JTextField("Masculino");
        campoSexo.setEditable(false);
        campoSexo.setPreferredSize(new Dimension(120, 0));
        etiquetaSexo.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaSexo);
        panelDatos.add(campoSexo);
        
        // Cuarto dato
        JLabel etiquetaPuesto = new JLabel("Puesto: ");
        JTextField campoPuesto = new JTextField("Programador");
        campoPuesto.setEditable(false);
        campoPuesto.setPreferredSize(new Dimension(120, 0));
        etiquetaSexo.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaPuesto);
        panelDatos.add(campoPuesto);

        // Quinto dato
        JLabel etiquetaProvincia = new JLabel("Provincia: ");
        JTextField campoProvincia = new JTextField("Cantabria");
        campoProvincia.setEditable(false);
        campoProvincia.setPreferredSize(new Dimension(120, 0));
        etiquetaProvincia.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaProvincia);
        panelDatos.add(campoProvincia);

        // Sexto dato
        JLabel etiquetaTelefono = new JLabel("Telefono: ");
        JTextField campoTelefono = new JTextField("666777888");
        campoTelefono.setEditable(false);
        campoTelefono.setPreferredSize(new Dimension(120, 0));
        etiquetaTelefono.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaTelefono);
        panelDatos.add(campoTelefono);
        
        panel1.add(panelDatos, BorderLayout.CENTER);
        
        // Septimo dato
        JLabel etiquetaCorreoEmp = new JLabel("Dirección correo: ");
        JTextField campoCorreoEmp = new JTextField("test@forsoftware.es");
        campoCorreoEmp.setEditable(false);
        campoCorreoEmp.setPreferredSize(new Dimension(120, 0));
        etiquetaCorreoEmp.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaCorreoEmp);
        panelDatos.add(campoCorreoEmp);
        
        panel1.add(panelDatos, BorderLayout.CENTER);
        
        // Octavo dato
        JLabel etiquetaSueldo = new JLabel("Sueldo: ");
        JTextField campoSueldo = new JTextField("10000");
        campoSueldo.setEditable(false);
        campoSueldo.setPreferredSize(new Dimension(120, 0));
        etiquetaSueldo.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaSueldo);
        panelDatos.add(campoSueldo);
        
        panel1.add(panelDatos, BorderLayout.CENTER);          

        // Añadir pestaña 1 a las tabs
        tabs.addTab("Pestaña 1", panel1);
        
// ========================================= FIN PESTAÑA 1 =========================================
      
       
        // Pestaña 2
        VentanaProyectos ventanaProyect = new VentanaProyectos();
        tabs.addTab("Proyectos", ventanaProyect);
        
// ========================================= FIN PESTAÑA 2 =========================================        
        
        // Pestaña 3
        VentanaTrabajadores ventanaTrabajadores = new VentanaTrabajadores();
        tabs.addTab("Trabajadores", ventanaTrabajadores);


// ========================================= FIN PESTAÑA 3 =========================================
       
        // Añadir tabs a la ventana
        add(tabs);


        // Configurar ventana
        setTitle("Bienvenido, [] - ForSoftware");
        setSize(1200, 500);
        setLocationRelativeTo(null); //centrar la ventana a la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {         //asegurar de que el codigo este y asegurar que la interfaz de usuario se actualice de manera adecuada
            VentanaInicial ventana = new VentanaInicial();
            ventana.setVisible(true);
        });

    }
}
