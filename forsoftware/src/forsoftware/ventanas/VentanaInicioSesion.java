package forsoftware.ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pNorte, pSur, pCentro;
	private JTextField correo;
	private JButton confirmar; 
	private JLabel titulo;
	
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
		correo = new JTextField(20);
		confirmar = new JButton("Confirmar");
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		pCentro.add(correo, gbc);
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


