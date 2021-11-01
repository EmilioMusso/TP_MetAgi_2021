package xp.ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.*;

import xp.db.T_propietario;



public class PanelPropietario extends JPanel {
	
	private JLabel tit;
	private JLabel nombre;
	private JTextField tnombre;
	private JLabel apellido;
	private JTextField tapellido;
	private JLabel tipodoc;
	private JComboBox<String> ttipodoc;
	private JLabel nrodoc;
	private JTextField tnrodoc;
	private JLabel direccion;
	private JLabel calle;
	private JTextField tcalle;
	private JLabel nrodom;
	private JTextField tnrodom;
	private JLabel provincia;
	private JTextField tprovincia;
	private JLabel localidad;
	private JTextField tlocalidad;
	private JLabel telefono;
	private JTextField ttelefono;
	private JLabel email;
	private JTextField temail;

	
	private JButton agregar;
	
	private GridBagConstraints gbc;
	
	
	public PanelPropietario() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
	}
	
	public PanelPropietario armarPanel() {
		
		this.tit = new JLabel("Alta de propietario");
		this.nombre = new JLabel("Nombre");
		this.tnombre = new JTextField(40);
		this.apellido = new JLabel("Apellido");
		this.tapellido = new JTextField(40);
		this.tipodoc = new JLabel("Tipo doc.");
		this.ttipodoc = new JComboBox<String>();
		this.nrodoc = new JLabel("Nro. doc.");
		this.tnrodoc = new JTextField(40);
		this.direccion = new JLabel("Dirección");
		this.calle = new JLabel("Calle");
		this.tcalle = new JTextField(40);
		this.nrodom = new JLabel("Nro.");
		this.tnrodom = new JTextField(40);
		this.provincia = new JLabel("Provincia");
		this.tprovincia = new JTextField(40);
		this.localidad = new JLabel("Localidad");
		this.tlocalidad = new JTextField(40);
		this.telefono = new JLabel("Teléfono");
		this.ttelefono = new JTextField(40);
		this.email = new JLabel("E-mail");
		this.temail = new JTextField(40);
				
		
		this.agregar = new JButton("Agregar"); 
		
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
		this.add(direccion,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(calle,gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		this.add(nrodom,gbc);
		gbc.gridx = 0;
		gbc.gridy = 8;
		this.add(provincia,gbc);
		gbc.gridx = 0;
		gbc.gridy = 9;
		this.add(localidad,gbc);
		gbc.gridx = 0;
		gbc.gridy = 10;
		this.add(telefono,gbc);
		gbc.gridx = 0;
		gbc.gridy = 11;
		this.add(email,gbc);
		
		
		
		
		
		
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
		this.add(tcalle,gbc);
		gbc.gridx = 2;
		gbc.gridy = 7;
		this.add(tnrodom,gbc);
		gbc.gridx = 2;
		gbc.gridy = 8;
		this.add(tprovincia,gbc);
		gbc.gridx = 2;
		gbc.gridy = 9;
		this.add(tlocalidad,gbc);
		gbc.gridx = 2;
		gbc.gridy = 10;
		this.add(ttelefono,gbc);
		gbc.gridx = 2;
		gbc.gridy = 11;
		this.add(temail,gbc);
		
			
		
		
		
		//gbc.anchor = GridBagConstraints.WEST;
		
		
		//button
		gbc.gridx = 2;
		gbc.gridy = 12;
		gbc.weightx = 0.1;
		gbc.weighty = 0.5;
		gbc.gridwidth=1;
		gbc.anchor = GridBagConstraints.EAST;
		//gbc.ipadx = 40;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(agregar,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		
		agregar.addActionListener(e -> {
			String tnom = this.tnombre.getText();
			String tape = this.tapellido.getText();
			String tdoc = this.tnrodoc.getText();
			String tcal = this.tcalle.getText();
			String tnd = this.tnrodom.getText();
			String tpro = this.tprovincia.getText();
			String tloc = this.tlocalidad.getText();
			String ttel = this.ttelefono.getText();
			String tem = this.temail.getText();
			
			//String test = (String) this.testado.getSelectedItem();
			
			T_propietario aT = new T_propietario();
			aT.insert(tnom, tape, tdoc, tcal, tnd, tpro, tloc, ttel, tem);
			
			tit.setText("Propietario agregado!");
			tit.setForeground(Color.RED);
			agregar.setEnabled(false);
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}

}

	