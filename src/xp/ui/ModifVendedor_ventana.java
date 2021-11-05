package xp.ui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ModifVendedor_ventana extends JFrame {

	private GridBagConstraints gbcf;
	private JLabel tit;
	
	//private JFrame mf = new JFrame();

	public ModifVendedor_ventana() {
		super();
		
		this.setContentPane(new ModifVendedoer_panel().armarPanel());
		//this.setContentPane(Pan); 
		this.setVisible(true);
		this.pack();
		//this.setVisible(true); 
	}
	
	public ModifVendedor_ventana(Object id, String nombre, String apellido, String numdoc, String calle, String numdom, String provincia, String localidad, String telefono, String email) {
		super();
		
		this.setContentPane(new ModifVendedoer_panel().armarPanel(id, nombre, apellido, numdoc, calle, numdom, provincia, localidad, telefono, email));
		//this.setContentPane(Pan); 
		this.setVisible(true);
		this.pack();
		//this.setVisible(true); 
	}

	
	
	

}
