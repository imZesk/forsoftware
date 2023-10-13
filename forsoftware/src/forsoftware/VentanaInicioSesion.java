package forsoftware;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pNorte, pSur, pCentro;
	private JTextField correo;
	private JButton confirmar; 
	
	public VentanaInicioSesion() {
		super();
		setBounds(300, 300, 600, 400);
		pNorte = new JPanel();
		pSur = new JPanel();
		pCentro = new JPanel(new GridLayout(2, 1));
		getContentPane().add(pNorte,BorderLayout.NORTH);
		getContentPane().add(pSur, BorderLayout.SOUTH);
		getContentPane().add(pCentro,BorderLayout.CENTER);
		
		correo = new JTextField(20);
		correo.setBounds(50, 50, 200, 25);
		confirmar = new JButton("Confirmar");
		confirmar.setBounds(100, 100, 100, 25);
		
		pCentro.add(correo);
		pCentro.add(confirmar);
		
		confirmar.addActionListener(e -> {
            String text = correo.getText();
            if ("Ivan".equals(text)) {
                JOptionPane.showMessageDialog(null, "Válido");
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
