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
import xp.exceptions.CampoNoAlfabeticoException;
import xp.exceptions.CampoNoNumericoException;
import xp.exceptions.CamposVaciosException;
import xp.exceptions.NroDocValidoException;
import xp.exceptions.PasswordInvalidaException;
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
	private JButton salir;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	private JFrame ventana2;
	
	
	public AltaVendedor_panel(GridBagConstraints gbcf, JFrame ventana) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(gbcf, ventana);
	}
	
	public AltaVendedor_panel armarPanel(GridBagConstraints gbcf, JFrame ventana) {
		
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
		this.fv = new FieldValidators();
		
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
				    	gbcf.gridx = 0;
				 		gbcf.gridy = 0;
				    	ventana.setContentPane(new Cons_Vendedor());
				    	gbcf.gridx = 3;
				 		gbcf.gridy = 7;
				 		gbcf.insets= new Insets(5,5,5,5);
				 		JButton salir = new JButton("Salir");
				 		ventana.add(salir,gbcf);
				    	ventana.pack();
					}
				}
			} catch(CamposVaciosException e1) {
				VentanaFallo v1 = new VentanaFallo(e1.getMessage());
				v1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v1.setVisible(true);
			} catch (Exception e2) {
				VentanaFallo v2 = new VentanaFallo(e2.getMessage());
				v2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v2.setVisible(true);
			}
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}

	private Boolean camposVacios() throws CamposVaciosException { //TODO ver si todos son obligatorios
		if(tnombre.getText().isEmpty() ||
				tapellido.getText().isEmpty() ||
				tnrodoc.getText().isEmpty() ||
				tclaveacceso.getText().isEmpty()) throw new CamposVaciosException("Complete los "
				+ "campos obligatorios."); //TODO mejorar mensaje
		return false;
	}
	
	private Boolean camposInvalidos() {
		try {
			if(fv.esAlfabetico(tnombre.getText(), "nombre") &&
					fv.esAlfabetico(tapellido.getText(), "apellido") &&
					fv.nroDocValido(tnrodoc.getText()) &&
					fv.passwordValida(tclaveacceso.getPassword().toString())) {
				return false;
			}
		} catch (PasswordInvalidaException e1) {
			VentanaFallo v1 = new VentanaFallo(e1.getMessage());
			v1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			v1.setVisible(true);
			return true;
		} catch (CampoNoAlfabeticoException e2) {
			VentanaFallo v2 = new VentanaFallo(e2.getMessage());
			v2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			v2.setVisible(true);
			return true;
		} catch (NroDocValidoException e3) {
			VentanaFallo v3 = new VentanaFallo(e3.getMessage());
			v3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			v3.setVisible(true);
			return true;
		}
		return true;
	}
}