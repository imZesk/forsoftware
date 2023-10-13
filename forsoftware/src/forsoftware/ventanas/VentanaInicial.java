package forsoftware.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class VentanaInicial extends JFrame {

    public VentanaInicial() {
        // Configura la ventana
        setTitle("Bienvenido %s - Info resumida nombre etc etc");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea el panel que contendrá las pestañas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Crea los paneles para cada pestaña
        JPanel panel1 = new JPanel(new BorderLayout());
        
        
        JTextArea textoPanel1 = new JTextArea("Resumen perfil trabajador");
        panel1.add(textoPanel1, BorderLayout.WEST);
        String[] listaTareas = {"Tarea 1", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3", "Tarea 2", "Tarea 3"};
        JList<String> lista = new JList<>(listaTareas);
        panel1.add(new JScrollPane(lista), BorderLayout.EAST);
        
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        // Agrega contenido a cada panel
        panel2.add(new JLabel("Contenido de Pestaña 2"));
        panel3.add(new JLabel("Contenido de Pestaña 3"));
        panel4.add(new JLabel("Contenido de Pestaña 4"));

        // Agrega las pestañas al JTabbedPane
        tabbedPane.addTab("Pestaña 1", panel1);
        tabbedPane.addTab("Pestaña 2", panel2);
        tabbedPane.addTab("Pestaña 3", panel3);
        tabbedPane.addTab("Pestaña 4", panel4);

        // Agrega el JTabbedPane a la ventana
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Hace visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Ejecuta la aplicación
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicial();
            }
        });
    }
}


