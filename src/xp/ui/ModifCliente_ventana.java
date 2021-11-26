package xp.ui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import xp.model.Cliente;
import xp.model.Vendedor;

public class ModifCliente_ventana extends JFrame {

	private GridBagConstraints gbcf;
	private JLabel tit;
	
	public ModifCliente_ventana(Cliente cliente, JFrame ventana, GridBagConstraints gbcfAnterior) {
		super();
		this.setContentPane(new ModifCliente_panel(cliente, this, gbcf, ventana, gbcfAnterior));
		//this.setContentPane(Pan); 
		this.setVisible(true);
		this.pack();
		//this.setVisible(true); 
	}
}