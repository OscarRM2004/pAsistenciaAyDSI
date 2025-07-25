package codenine.vista;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CeldaRenderer extends DefaultTableCellRenderer {

    private int col = -1;

    public CeldaRenderer(int col) {
        this.col = col;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (col == column) {
            JComboBox comboBox = new JComboBox();
            comboBox.addItem(value);
            return comboBox;
        }

        return cellComponent;
    }
}