package xp.ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

import xp.db.T_propietario;
import xp.model.Vendedor;



public class ModifVendedor_panel extends JPanel {
	
	private JLabel tit;
	private JLabel nombre;
	private JTextField tnombre;
	private JLabel apellido;
	private JTextField tapellido;
	private JLabel tipodoc;
	private JComboBox<String> ttipodoc;
	private JLabel nrodoc;
	private JTextField tnrodoc;
	private JLabel claveacceso;
	private JTextField tclaveacceso;
	
	private JButton guardar;
	
	private GridBagConstraints gbc;
	
	
	public ModifVendedor_panel() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
	}
	
	public ModifVendedor_panel armarPanel(Object id, String nom, String ape, String ndoc, String pass) {
		
		this.tit = new JLabel("Modificar propietario");
		this.nombre = new JLabel("Nombre");
		(this.tnombre = new JTextField(40)).setText(nom);
		
		this.apellido = new JLabel("Apellido");
		(this.tapellido = new JTextField(40)).setText(ape);
		
		this.tipodoc = new JLabel("Tipo doc.");
		this.ttipodoc = new JComboBox<String>();
		//this.ttipodoc.setSelectedItem(est);
		
		this.nrodoc = new JLabel("Nro. doc.");
		(this.tnrodoc = new JTextField(40)).setText(ndoc);
		
		this.claveacceso = new JLabel("Clave de Acceso");
		(this.tclaveacceso =  new JTextField(40)).setText(pass);
				
		
	
		
		this.guardar = new JButton("Guardar"); 
		
		gbc.gridx = 0;		//posición
		gbc.gridy = 0;
		gbc.weightx = 0.1;	//peso
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.EAST;	//ubicación
		//gbc.ipadx = 10;				//margen int		
		//gbc.ipady = 10;
		gbc.insets= new Insets(5,5,5,5);	 //top,left,bottom,right 	
		
		//Título
		this.add(tit,gbc);
		tit.setForeground(Color.BLUE);
		tit.setFont(tit.getFont().deriveFont(22.0f));
		
		//label
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(nombre,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(apellido,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(tipodoc,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(nrodoc,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		
		this.add(claveacceso,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
	
		
		
		
		
		
		
		//text
		gbc.gridx = 2;
		gbc.gridy = 1;
		//gbc.weightx = 0.5;
		//gbc.weighty = 0.1;
		gbc.gridwidth=2;						//cant celdas
		gbc.anchor = GridBagConstraints.WEST;
		this.add(tnombre,gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(tapellido,gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		this.add(ttipodoc,gbc);
		ttipodoc.addItem("DNI");
		ttipodoc.addItem("LC");
		ttipodoc.addItem("LE");
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(tnrodoc,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		this.add(tclaveacceso,gbc);
		
		
		
		
		
		//button
		gbc.gridx = 2;
		gbc.gridy = 12;
		gbc.weightx = 0.1;
		gbc.weighty = 0.5;
		gbc.gridwidth=1;
		gbc.anchor = GridBagConstraints.EAST;
		//gbc.ipadx = 40;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(guardar,gbc);
		gbc.gridx = 2;
		gbc.gridy = 12;
		
		guardar.addActionListener(e -> {
			String tnom = this.tnombre.getText();
			String tape = this.tapellido.getText();
			String tdoc = this.tnrodoc.getText();
			String tpass = this.tclaveacceso.getText();
		
			Vendedor vendedor = new Vendedor();
			vendedor.delete(id);
			vendedor.insert(tnom, tape, tdoc, tpass);
			
			tit.setText("Vendedor actualizado!");
			tit.setForeground(Color.RED);
			guardar.setEnabled(false);
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}

}

	