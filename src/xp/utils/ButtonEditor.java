package xp.utils;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import xp.ui.ModifProp_ventana;
import xp.ui.ModifVendedoer_panel;
import xp.ui.ModifVendedor_ventana;

public class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(a -> {
            // fireEditingStopped();    
            ModifVendedor_ventana modif = new ModifVendedor_ventana();
    		modif.setVisible(true);
			modif.setEnabled(false);        
        });
    }

    @Override
    public JButton getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if(isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        }else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
        }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JOptionPane.showMessageDialog(button, label + ": Ouch!");
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}