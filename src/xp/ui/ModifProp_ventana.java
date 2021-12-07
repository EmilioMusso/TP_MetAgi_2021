package xp.ui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ModifProp_ventana extends JFrame {

	private GridBagConstraints gbcf;
	private JLabel tit;
	
	//private JFrame mf = new JFrame();
	
	public ModifProp_ventana(Object id, String nombre, String apellido, String numdoc, String calle, String numdom, String provincia, String localidad, String telefono, String email) {
		super();
		
		this.setContentPane(new ModifProp_panel().armarPanel(id, nombre, apellido, numdoc, calle, numdom, provincia, localidad, telefono, email, email));
		//this.setContentPane(Pan); 
		this.setVisible(true);
		this.pack();
		//this.setVisible(true); 
	}

	
	
	

}
