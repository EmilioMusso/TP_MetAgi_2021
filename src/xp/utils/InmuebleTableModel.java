package xp.utils;

import javax.swing.table.DefaultTableModel;

public class InmuebleTableModel extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	
}
