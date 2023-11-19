package forsoftware.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class rendererRoles extends DefaultTableCellRenderer {
    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof String) {
            String rol = (String) value;
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER); // centra la imagen en la celda
            ImageIcon icono;
            switch (rol) {
            case "programador":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            case "modelador":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            case "gameDesigner":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            case "artista":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            case "escritor":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            case "video":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            case "sonido":
                icono = new ImageIcon("src/usuario.jpg");
                break;
            default:
                icono = new ImageIcon("src/usuario.jpg");
                break;
        }
            Image img = icono.getImage();
            Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // ajustar tamaño
            icono = new ImageIcon(newimg);
            label.setIcon(icono);
            return label;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}