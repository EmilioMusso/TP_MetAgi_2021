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
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}

	public void addColumn(String string) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}*/
};