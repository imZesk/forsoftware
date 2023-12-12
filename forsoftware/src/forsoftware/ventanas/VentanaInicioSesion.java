package forsoftware.ventanas;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	
    private static final Logger LOGGER = Logger.getLogger( VentanaInicioSesion.class.getName() );

	private JPanel pNorte, pSur, pCentro;
	private JTextField correo;
	private JButton confirmar; 
	private JLabel titulo;
	private JLabel etiquetaCorreo;
	private JPasswordField contraseña;
	private JLabel etiquietaContraseña;
	Map<String, String> mapa = new HashMap<>();
	Map<String, String> properties = new HashMap<>();
	
	public VentanaInicioSesion() {
		super();
		setBounds(300, 300, 600, 400);
		pNorte = new JPanel();
		pSur = new JPanel();
		pCentro = new JPanel(new GridBagLayout());
		getContentPane().add(pNorte,BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		
	    Properties prop = new Properties();
	    InputStream input = null;

	    try {
	        input = new FileInputStream("src/forsoftware/properties/config.properties");
	        prop.load(input);

	        for (String key : prop.stringPropertyNames()) {
	            String value = prop.getProperty(key);
	            properties.put(key, value);
	        }
	        System.out.println(properties);

	    }catch (FileNotFoundException ex) {
	        System.out.println("El archivo de propiedades no se ha encontrado: " + ex.getMessage());
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        if (input != null) {
	            try {
	                input.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
	    
		String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/Trabajadores.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                String correo = values[7];
                String nombre = values[1];
                mapa.put(correo, nombre);
            }
        }catch (FileNotFoundException e) {
		    System.out.println("El archivo no se ha encontrado: " + e.getMessage());
		}catch (IOException e) {
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
		    System.out.println("Error en los datos: " + e.getMessage());
		}
        System.out.println(mapa);
		
		ImageIcon imagen = new ImageIcon("src/forsoftware.png");
		ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(300, 100, Image.SCALE_SMOOTH));
	    JLabel etiquetaImagen = new JLabel(imagenEscalada);
	    pNorte.add(etiquetaImagen, BorderLayout.CENTER);
		correo = new JTextField(20);
		contraseña = new JPasswordField(20);
		confirmar = new JButton("Confirmar");
		etiquetaCorreo = new JLabel("Correo:");
		etiquietaContraseña = new JLabel("Contraseña:");
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		pCentro.add(etiquetaCorreo, gbc);
		pCentro.add(correo, gbc);
		pCentro.add(etiquietaContraseña, gbc);
		pCentro.add(contraseña, gbc);
		pCentro.add(confirmar, gbc);
		
		confirmar.addActionListener(e -> {
		    String text1 = correo.getText();
		    String text2 = new String(contraseña.getPassword());

		    if(text1.isEmpty() || text2.isEmpty()){
		        JOptionPane.showMessageDialog(null, "Por favor, rellene ambos campos: correo y contraseña");
		    } else if (mapa.containsKey(text1) && mapa.get(text1).equals(text2)) {
		        JOptionPane.showMessageDialog(null, "Válido");
		        new VentanaInicial(text1);
		        LOGGER.log(Level.INFO, "Sesion iniciada como: " + text1);
		        dispose();
		    } else {
		        JOptionPane.showMessageDialog(null, "Correo o contraseña inválidos");
		    }
		});
		

		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
}


