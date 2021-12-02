package xp.ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.BitSet;

import javax.swing.*;

import xp.db.T_cliente;
import xp.db.T_propietario;
import xp.db.T_vendedor;
import xp.exceptions.CampoNoAlfabeticoException;
import xp.exceptions.CampoNoNumericoException;
import xp.exceptions.CamposVaciosException;
import xp.exceptions.NroDocValidoException;
import xp.exceptions.PasswordInvalidaException;
import xp.model.Cliente;
import xp.utils.FieldValidators;


public class AltaCliente_Panel extends JPanel {
	
	private JLabel tit;
	private JLabel nombre;
	private JTextField tnombre;
	private JLabel apellido;
	private JTextField tapellido;
	private JLabel usuario;
	private JTextField tusuario;
	private JLabel claveacceso;
	private JPasswordField tclaveacceso;
	private JLabel telefono;
	private JTextField ttelefono;
	
	private JButton agregar;
	private JButton salir;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	private JFrame ventana2;
	
	
	public AltaCliente_Panel(GridBagConstraints gbcf, JFrame ventana) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(gbcf, ventana);
	}
	
	public AltaCliente_Panel armarPanel(GridBagConstraints gbcf, JFrame ventana) {
		
		this.tit = new JLabel("Alta de cliente");
		this.nombre = new JLabel("Nombre");
		this.tnombre = new JTextField(40);
		this.apellido = new JLabel("Apellido");
		this.tapellido = new JTextField(40);
		this.telefono = new JLabel("Telefono");
		this.ttelefono = new JTextField(40);
		this.usuario = new JLabel("Usuario");
		this.tusuario = new JTextField(40);
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
		this.add(telefono,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(usuario,gbc);
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
		this.add(ttelefono,gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(tusuario,gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		this.add(tclaveacceso,gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;

		
		//gbc.anchor = GridBagConstraints.WEST;
		
		
		//button
		gbc.gridx = 2;
		gbc.gridy = 8;
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
						T_cliente aT = new T_cliente();
						aT.insert(tnombre.getText(),
								tapellido.getText(),
								ttelefono.getText(),
								tusuario.getText(),
								tclaveacceso.getText());
						
//						Cliente newVendedor = new Cliente(tnombre.getText(),						
//					    tapellido.getText(),		
//						tnombre.getText(),
//						ttelefono.getText(),
//						tusuario.getText(),
//						tclaveacceso.getText());
						VentanaExito ventanaExito = new VentanaExito("Cliente agregado correctamente.");
						ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						ventanaExito.setVisible(true);
				    	gbcf.gridx = 0;
				 		gbcf.gridy = 0;
				    	ventana.setContentPane(new Cons_Cliente(ventana,gbcf));
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
				ttelefono.getText().isEmpty() ||
				tclaveacceso.getText().isEmpty()) throw new CamposVaciosException("Complete los "
				+ "campos obligatorios."); //TODO mejorar mensaje
		return false;
	}
	
	private Boolean camposInvalidos() {
		try {
			if(fv.esAlfabetico(tnombre.getText(), "nombre") &&
					fv.esAlfabetico(tapellido.getText(), "apellido") &&
					fv.esNumerico(ttelefono.getText(),"telefono") &&
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
		} catch (CampoNoNumericoException e3) {
			VentanaFallo v3 = new VentanaFallo(e3.getMessage());
			v3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			v3.setVisible(true);
			return true;
		}
		return true;
	}
}