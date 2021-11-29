package xp.utils;

import javax.swing.table.DefaultTableModel;
/*import javax.swing.table.TableModel;*/

public class ClienteTableModel extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}





/*public class ClienteTableModel implements TableModel {
	public boolean isCellEditable(int row, int column) {
		return false;
	}*/

/*	public void addRow(Object[] fila) {
		// TODO Apéndice de método generado automáticamente
		
	}

	public void addColumn(String string) {
		// TODO Apéndice de método generado automáticamente
		
	}*/
};