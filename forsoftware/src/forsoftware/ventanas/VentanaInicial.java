package forsoftware.ventanas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class VentanaInicial extends JFrame {
	protected Logger logger = Logger.getLogger( VentanaInicial.class.getName() );

	private static final long serialVersionUID = 1L;
	private static String correoUsuario;
	private Map<String, String[]> mapa = new HashMap<>();
	private JLabel lblHora;

	public VentanaInicial(String correoUsuario) {
		 super();
        JTabbedPane tabs = new JTabbedPane();
        this.correoUsuario = correoUsuario;
        
        
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Trabajadores.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";"); // Asegúrate de que estás dividiendo por el carácter correcto
                String correo = values[7];
                mapa.put(correo, values);
            }
            logger.info("Se han añadido los datos de los trabajadores correctamente");
        } catch (IOException e) {
        	logger.warning(String.format("Error al importar/guardar los datos der los trabajadores: %s", e.getMessage()));
            e.printStackTrace();
        }
        
        String[] datosUsuario = mapa.get(correoUsuario);
        String idUsuario = datosUsuario[0];
        String nombre = datosUsuario[1];   
        String apellido = datosUsuario[2];
        String sexo = datosUsuario[3];
        String puesto = datosUsuario[4];
        String provincia = datosUsuario[5];
        String telefono = datosUsuario[6];
        String correo = datosUsuario[7];
        String sueldo = datosUsuario[8];

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
        
        //panelBotones.add(btnContrasena);
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
            		JOptionPane.showMessageDialog(null, "Contraseña cambiada, inicia sesion de nuevo.");
                	new VentanaInicioSesion();															
                	dispose();
				}else {
	                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				}            	
            }else{
            	System.out.println(passTest);
            	System.out.println(contOld);
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        
    });

       
        
        // Agregar campos de datos 
        JPanel panelDatos = new JPanel(new GridLayout(3, 3, 0, 0));

        // Primer dato
        JLabel etiquetaId = new JLabel("ID: ");
        JTextField campoId = new JTextField(idUsuario);
        campoId.setEditable(false);
        campoId.setPreferredSize(new Dimension(120, 10));
        etiquetaId.setPreferredSize(new Dimension(120, 10));
        panelDatos.add(etiquetaId);
        panelDatos.add(campoId);

        // Segundo dato
        JLabel etiquetaNombre = new JLabel("Nombre: ");
        JTextField campoNombre = new JTextField(nombre);
        campoNombre.setEditable(false);
        campoNombre.setPreferredSize(new Dimension(120, 0));
        etiquetaNombre.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaNombre);
        panelDatos.add(campoNombre);

        // Tercer dato
        JLabel etiquetaApellido = new JLabel("Apellido: ");
        JTextField campoApellido = new JTextField(apellido);
        campoApellido.setEditable(false);
        campoApellido.setPreferredSize(new Dimension(120, 0));
        etiquetaApellido.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaApellido);
        panelDatos.add(campoApellido);

        // Cuarto dato
        JLabel etiquetaSexo = new JLabel("Sexo: ");
        JTextField campoSexo = new JTextField(sexo);
        campoSexo.setEditable(false);
        campoSexo.setPreferredSize(new Dimension(120, 0));
        etiquetaSexo.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaSexo);
        panelDatos.add(campoSexo);
        
        // Cuarto dato
        JLabel etiquetaPuesto = new JLabel("Puesto: ");
        JTextField campoPuesto = new JTextField(puesto);
        campoPuesto.setEditable(false);
        campoPuesto.setPreferredSize(new Dimension(120, 0));
        etiquetaSexo.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaPuesto);
        panelDatos.add(campoPuesto);

        // Quinto dato
        JLabel etiquetaProvincia = new JLabel("Provincia: ");
        JTextField campoProvincia = new JTextField(provincia);
        campoProvincia.setEditable(false);
        campoProvincia.setPreferredSize(new Dimension(120, 0));
        etiquetaProvincia.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaProvincia);
        panelDatos.add(campoProvincia);

        // Sexto dato
        JLabel etiquetaTelefono = new JLabel("Telefono: ");
        JTextField campoTelefono = new JTextField(telefono);
        campoTelefono.setEditable(false);
        campoTelefono.setPreferredSize(new Dimension(120, 0));
        etiquetaTelefono.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaTelefono);
        panelDatos.add(campoTelefono);
        
        panel1.add(panelDatos, BorderLayout.CENTER);
        
        // Septimo dato
        JLabel etiquetaCorreoEmp = new JLabel("Dirección correo: ");
        JTextField campoCorreoEmp = new JTextField(correo);
        campoCorreoEmp.setEditable(false);
        campoCorreoEmp.setPreferredSize(new Dimension(120, 0));
        etiquetaCorreoEmp.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaCorreoEmp);
        panelDatos.add(campoCorreoEmp);
        
        panel1.add(panelDatos, BorderLayout.CENTER);
        panel1.add(panelBotones, BorderLayout.SOUTH);
        
        // Octavo dato
        JLabel etiquetaSueldo = new JLabel("Sueldo: ");
        JTextField campoSueldo = new JTextField(sueldo);
        campoSueldo.setEditable(false);
        campoSueldo.setPreferredSize(new Dimension(120, 0));
        etiquetaSueldo.setPreferredSize(new Dimension(120, 0));
        panelDatos.add(etiquetaSueldo);
        panelDatos.add(campoSueldo);
        
        panel1.add(panelDatos, BorderLayout.CENTER);          

        // Añadir pestaña 1 a las tabs
        tabs.addTab("Inicio", panel1);
        
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
        
        
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		lblHora = new JLabel();
		
		/*Creamos un Thread que actualice la fecha cada  segundo*/
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//Aquí tenemos que poner el código que queremos que el Thread ejecute
				while(true) {
					Date fecha = new Date();
					LocalDate fechaUpdated = LocalDate.now();
					setTitle("Bienvenido "+nombre+ " - ForSoftware" + sdf.format(fecha) + " " + fechaUpdated.getDayOfMonth() + "/" + fechaUpdated.getMonth()+ "/" +fechaUpdated.getYear());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						logger.warning("Error, el hilo ha sido interrumpido");
					}
				}
			}
		});
		t.start();

        // Configurar ventana
        setTitle("Bienvenido "+nombre + " - ForSoftware");
        setSize(1200, 500);
        setLocationRelativeTo(null);//centrar la ventana a la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {         //asegurar de que el codigo este y asegurar que la interfaz de usuario se actualice de manera adecuada
            VentanaInicial ventana = new VentanaInicial(correoUsuario);
            ventana.setVisible(true);
        });

    }
}
