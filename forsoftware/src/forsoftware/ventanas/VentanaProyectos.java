package forsoftware.ventanas;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaProyectos {
	public VentanaProyectos() {

        JFrame ventana = new JFrame("Lista de Trabajadores");

        // Crear los datos de ejemplo 
        String[] columnas = {"ID", "Nombre", "nº participantes", "FechaInicio", "FechaAcabado", "Gastos", "Estado"};
        String[][] datos = {
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},
            {"1112", "Proyect1", "5", "12/12/2012", "12/12/2013","50214.00", "5000.00", "pendiente"},

        };

       // DefaultTableModel model = new DefaultTableModel(datos, columnas);

		DefaultTableModel model = new DefaultTableModel(datos, columnas) {
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas sean de solo lectura
            }
        };
        JTable tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JPanel panelBotones = new JPanel();
        
        JButton botonAnyadir = new JButton("Añadir Proyecto");
        JButton botonEliminar = new JButton("Anular Proyecto");
        JButton botonFinalizado = new JButton("Finalizar Proyecto"); //al pulsar este boton hace q el proyecto q esta en estado pendiente se convierta en finalizado
        panelBotones.add(botonAnyadir);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonFinalizado);
        
        ventana.add(scrollPane, BorderLayout.CENTER);
        ventana.add(panelBotones, BorderLayout.SOUTH);

       
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(700, 350);
        ventana.setVisible(true);
    }

	public static void main(String[] args) {
		new VentanaProyectos();
	}
}


//cuando pones el raton encima aparece una lista de algo --> jdialog