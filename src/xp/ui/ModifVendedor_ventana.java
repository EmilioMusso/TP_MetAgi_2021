package xp.ui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import xp.model.Vendedor;

public class ModifVendedor_ventana extends JFrame {

	private GridBagConstraints gbcf;
	private JLabel tit;
	
	public ModifVendedor_ventana(Vendedor vendedor) {
		super();
		this.setContentPane(new ModifVendedor_panel(vendedor, this, gbcf));
		//this.setContentPane(Pan); 
		this.setVisible(true);
		this.pack();
		//this.setVisible(true); 
	}
}