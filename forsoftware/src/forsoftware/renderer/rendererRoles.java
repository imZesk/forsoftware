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
            switch (rol) {  // mira cada caso y pone la foto dependiendo del rol
            case "programador":
                icono = new ImageIcon("img/programador.png");
                break;
            case "modelador":
                icono = new ImageIcon("img/modelador.png");
                break;
            case "gameDesigner":
                icono = new ImageIcon("img/gameDesigner.png");
                break;
            case "artista":
                icono = new ImageIcon("img/artista.png");
                break;
            case "escritor":
                icono = new ImageIcon("img/escritor.png");
                break;
            case "video":
                icono = new ImageIcon("img/video.png");
                break;
            case "sonido":
                icono = new ImageIcon("img/sonido.png");
                break;
            default:
                icono = new ImageIcon("usuario.jpg");
                break;
        }
            Image img = icono.getImage();
            Image newimg = img.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH); // ajustar tamaño
            icono = new ImageIcon(newimg);
            label.setIcon(icono);
            return label;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}