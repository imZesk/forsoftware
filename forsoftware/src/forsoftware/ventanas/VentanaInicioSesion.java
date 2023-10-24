package forsoftware.ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

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
	private JPanel pNorte, pSur, pCentro;
	private JTextField correo;
	private JButton confirmar; 
	private JLabel titulo;
	private JLabel etiquetaCorreo;
	private JPasswordField contraseña;
	private JLabel etiquietaContraseña;
	
	public VentanaInicioSesion() {
		super();
		setBounds(300, 300, 600, 400);
		pNorte = new JPanel();
		pSur = new JPanel();
		pCentro = new JPanel(new GridBagLayout());
		getContentPane().add(pNorte,BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		
		 
		
		titulo = new JLabel("Agrega correo de inicio de sesión");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		pNorte.add(titulo);
		ImageIcon imagen = new ImageIcon("src/usuario.jpg");
		ImageIcon imagenEscalada = new ImageIcon(imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
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
            String text = correo.getText();
            if ("Ivan".equals(text)) {
                JOptionPane.showMessageDialog(null, "Válido");
                new VentanaInicial();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Inválido");
            }
        });
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
}


