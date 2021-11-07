package xp.ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.BitSet;

import javax.swing.*;

import xp.db.T_propietario;
import xp.db.T_vendedor;
import xp.exceptions.camposVaciosException;
import xp.exceptions.passwordInvalidaException;
import xp.utils.FieldValidators;


public class AltaVendedor_panel extends JPanel {
	
	private JLabel tit;
	private JLabel nombre;
	private JTextField tnombre;
	private JLabel apellido;
	private JTextField tapellido;
	private JLabel claveacceso;
	private JPasswordField tclaveacceso;
	private JLabel tipodoc;
	private JComboBox<String> ttipodoc;
	private JLabel nrodoc;
	private JTextField tnrodoc;
	
	private JButton agregar;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	
	
	public AltaVendedor_panel() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel();
	}
	
	public AltaVendedor_panel armarPanel() {
		
		this.tit = new JLabel("Alta de vendedor");
		this.nombre = new JLabel("Nombre");
		this.tnombre = new JTextField(40);
		this.apellido = new JLabel("Apellido");
		this.tapellido = new JTextField(40);
		this.tipodoc = new JLabel("Tipo doc.");
		this.ttipodoc = new JComboBox<String>();
		this.nrodoc = new JLabel("Nro. doc.");
		this.tnrodoc = new JTextField(40);
		this.claveacceso = new JLabel("Clave de acceso");
		this.tclaveacceso = new JPasswordField(40);	
		this.agregar = new JButton("Agregar"); 
		
		gbc.gridx = 0;		//posición
		gbc.gridy = 0;
		gbc.weightx = 0.1;	//peso
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.EAST;	//ubicación
		//gbc.ipadx = 10;						//margen int		
		//gbc.ipady = 10;
		gbc.insets= new Insets(5,5,5,5);	 	//top,left,bottom,right 	
		
		//Título
		this.add(tit,gbc);
		tit.setForeground(Color.BLUE);
		tit.setFont(tit.getFont().deriveFont(22.0f));
	
		
		//labels
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
		gbc.gridy = 5;
		this.add(tclaveacceso,gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;

		
		//gbc.anchor = GridBagConstraints.WEST;
		
		
		//button
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.weightx = 0.1;
		gbc.weighty = 0.5;
		gbc.gridwidth=1;
		gbc.anchor = GridBagConstraints.EAST;
		//gbc.ipadx = 40;
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(agregar,gbc);
		
		
		agregar.addActionListener(e -> {
			try {
				if (!camposVacios()) {
					if(!camposInvalidos()) {
						T_vendedor aT = new T_vendedor();
						aT.insert(tnombre.getText(),
								tapellido.getText(),
								ttipodoc.getSelectedItem().toString(),
								tnrodoc.getText(),
								tclaveacceso.getText());
//						Vendedor newVendedor = new Vendedor(tnombre.getText(),
//						tapellido.getText(),
//						ttipodoc.getSelectedItem().toString(),
//						tnrodoc.getText(),
//						tclaveacceso.getText());
						VentanaExito ventanaExito = new VentanaExito("Vendedor agregado correctamente.");
						ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						ventanaExito.setVisible(true);
					}
				}
			} catch(camposVaciosException e1) {
				VentanaFallo v1 = new VentanaFallo(e1.getMessage());
			} catch (Exception e2) {
				VentanaFallo v2 = new VentanaFallo(e2.getMessage());
			}
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}

	private Boolean camposVacios() throws camposVaciosException { //TODO ver si todos son obligatorios
		BitSet bitSetValidacioneSet = new BitSet(4);
		bitSetValidacioneSet.clear();
		
		bitSetValidacioneSet.set(0, tnombre.getText()=="");
		bitSetValidacioneSet.set(1, tapellido.getText()=="");
		bitSetValidacioneSet.set(2, tnrodoc.getText()=="");
		bitSetValidacioneSet.set(3, tclaveacceso.getText()=="");
		
		//Si el bitset no esta vacio es que hay un problema
		if(!bitSetValidacioneSet.isEmpty()) throw new camposVaciosException("Complete los"
				+ "campos obligatorios."); //TODO mejorar mensaje
		System.out.println(bitSetValidacioneSet.toString());
		return false;
	}
	
	private Boolean camposInvalidos() {
		BitSet bitSetValidacioneSet = new BitSet(4);
		bitSetValidacioneSet.clear();
		
		bitSetValidacioneSet.set(0, fv.esAlfabetico(tnombre.getText()));
		bitSetValidacioneSet.set(1, fv.esAlfabetico(tapellido.getText()));
		bitSetValidacioneSet.set(2, fv.esNumerico(tnrodoc.getText()));
		try {
			bitSetValidacioneSet.set(3, fv.passwordValida(tclaveacceso.getText()));
		} catch (passwordInvalidaException e) {
			VentanaFallo vf = new VentanaFallo(e.getMessage());
		}
		
		return false;
	}
}