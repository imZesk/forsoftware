package forsoftware.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class rendererTablas extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private JTextField filtroTextField;

    public rendererTablas(JTextField filtroTextField) {
        this.filtroTextField = filtroTextField;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel result = new JLabel(value.toString());
        int selectedRow = -1;

        if (value != null) {
            String textoCelda = value.toString();
            String textoFiltro = filtroTextField.getText();

            if (!textoFiltro.isBlank() && textoCelda.contains(textoFiltro)) {
                String inicioStr = textoCelda.substring(0, textoCelda.indexOf(textoFiltro));
                String finalStr = textoCelda.substring(textoCelda.indexOf(textoFiltro) + textoFiltro.length());

                result.setText("<html>" + inicioStr + "<font color='red'><strong>" + textoFiltro + "</strong></font>" + finalStr + "</html>");
            }
        }

        if (isSelected) {
            if (selectedRow != -1 && selectedRow != row) {
                table.setRowSelectionInterval(selectedRow, selectedRow);
            }
            result.setBackground(Color.gray.brighter());
            selectedRow = row;
        } else {
            result.setBackground(table.getBackground());
        }
        result.setOpaque(true);
        return result;
    }
}
