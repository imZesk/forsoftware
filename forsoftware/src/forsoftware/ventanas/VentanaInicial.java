package forsoftware.ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaInicial extends JFrame {
    public VentanaInicial() {

        JTabbedPane tabs = new JTabbedPane();

        // Pestaña 1
        JPanel panel1 = new JPanel(new BorderLayout());

        // Añadir imagen 
        ImageIcon imagen = new ImageIcon("C:/Users/ytzes/Downloads/usuario.jpg");
        JLabel etiquetaImagen = new JLabel(imagen);
        panel1.add(etiquetaImagen, BorderLayout.WEST);

        // Añadir panel de texto no editable debajo de la imagen
        JTextArea texto = new JTextArea("Datos del empleado [por añadir]");
        texto.setEditable(false);
        panel1.add(etiquetaImagen, BorderLayout.NORTH);
        panel1.add(texto, BorderLayout.CENTER);

        // Añadir 3 botones debajo de la ventana
        JPanel panelBotones = new JPanel(new GridLayout(1, 3));
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panel1.add(panelBotones, BorderLayout.SOUTH);

        // Añadir lista con Jscroll a la derecha
        String[] elementosLista = {"Tarea 1", "Tarea 2", "Tarea 3", "Tarea 4", "Tarea 5", "Tarea 6", "Tarea 7", "Tarea 8", "Tarea 9", "Tarea 10"};
        JList<String> lista = new JList<>(elementosLista);
        JScrollPane scrollLista = new JScrollPane(lista);
        panel1.add(scrollLista, BorderLayout.LINE_END);
        scrollLista.setPreferredSize(new Dimension(150, 0)); // Ancho del scroll
        lista.setFixedCellHeight(30); // aalto de los elementos de la lista
        

        // Añadir pestaña 1 a las tabs
        tabs.addTab("Pestaña 1", panel1);
// ========================================= FIN PESTAÑA 1 =========================================
        // Pestaña 2
        JPanel panel2 = new JPanel();
        JLabel etiqueta2 = new JLabel("Contenido de la pestaña 2");
        panel2.add(etiqueta2);
        tabs.addTab("Pestaña 2", panel2);

// ========================================= FIN PESTAÑA 2 =========================================        
        
        // Pestaña 3
        JPanel panel3 = new JPanel();
        JLabel etiqueta3 = new JLabel("Contenido de la pestaña 3");
        panel3.add(etiqueta3);
        tabs.addTab("Pestaña 3", panel3);

// ========================================= FIN PESTAÑA 3 =========================================

        // Pestaña 4
        JPanel panel4 = new JPanel();
        JLabel etiqueta4 = new JLabel("Contenido de la pestaña 4");
        panel4.add(etiqueta4);
        tabs.addTab("Pestaña 4", panel4);

// ========================================= FIN PESTAÑA 4 =========================================
        
        // Añadir tabs a la ventana
        add(tabs);

        // Configurar ventana
        setTitle("Bienvenido, [] - ForSoftware");
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaInicial();
    }
}
