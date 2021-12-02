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
import xp.exceptions.CamposVaciosException;
import xp.exceptions.NroDocValidoException;
import xp.exceptions.PasswordInvalidaException;
import xp.model.Cliente;
import xp.model.Vendedor;
import xp.utils.FieldValidators;


public class ModifCliente_panel extends JPanel {
	
	private JLabel tit;
	private JLabel nombre;
	private JTextField tnombre;
	private JLabel apellido;
	private JTextField tapellido;
	private JLabel telefono;
	private JTextField ttelefono;
	private JLabel usuario;
	private JTextField tusuario;
	private JLabel claveacceso;
	private JTextField tclaveacceso;
	
	private JButton modificar;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	
	
	public ModifCliente_panel(Cliente c1, ModifCliente_ventana ventana, GridBagConstraints gbcf, JFrame ventanaAnterior, GridBagConstraints gbcfAnterior) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(c1, ventana, gbcf, ventanaAnterior, gbcfAnterior);
	}
	

	public ModifCliente_panel armarPanel(Cliente c1, ModifCliente_ventana ventana, GridBagConstraints gbcf, JFrame ventanaAnterior, GridBagConstraints gbcfAnterior) {
		
		this.tit = new JLabel("Alta de cliente");
		this.nombre = new JLabel("Nombre");
		this.tnombre = new JTextField(40);
		this.tnombre.setText(c1.getNombre());
		this.apellido = new JLabel("Apellido");
		this.tapellido = new JTextField(40);
		this.tapellido.setText(c1.getApellido());
		this.telefono = new JLabel("Telefono");
		this.ttelefono = new JTextField(40);
		this.ttelefono.setText(c1.getTelefono());
		this.usuario = new JLabel("Usuario");
		this.tusuario = new JTextField(40);
		this.tusuario.setText(c1.getUsuario());
		this.claveacceso = new JLabel("Clave de acceso");
		this.tclaveacceso = new JPasswordField(40);
		 
		this.fv = new FieldValidators();
		
				
		this.modificar = new JButton("Modificar"); 
		
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

//		this.add(tprovincia,gbc);
//		gbc.gridx = 2;
//		gbc.gridy = 9;
//		this.add(tlocalidad,gbc);
//		gbc.gridx = 2;
//		gbc.gridy = 10;
//		this.add(ttelefono,gbc);
//		gbc.gridx = 2;
//		gbc.gridy = 11;
//		this.add(temail,gbc);
		
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
		this.add(modificar,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 10;	
		
		modificar.addActionListener(e -> {
			Object id = c1.getId();
			String nom = this.tnombre.getText();
			String ape = this.tapellido.getText();
			String telefono = this.ttelefono.getText();
			@SuppressWarnings("deprecation")
			String usuario = this.tusuario.getText();
			String claveacceso = this.tclaveacceso.getText();
			
			try {
				if (!camposVacios()) {
					if(!camposInvalidos()) {
						T_cliente aT = new T_cliente();
						aT.delete(id);
						aT.insert(tnombre.getText(),
								tapellido.getText(),
								ttelefono.getText(),
								tusuario.getText(),
								tclaveacceso.getText());

						VentanaExito ventanaExito = new VentanaExito("Cliente modificado correctamente.");
						ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						ventanaExito.setVisible(true);
						ventana.dispose();	
						
						JButton salir = new JButton("Salir");
				    	gbcfAnterior.gridx = 0;
				    	gbcfAnterior.gridy = 0;
				 		ventanaAnterior.setContentPane(new Cons_Cliente(ventana, gbcfAnterior));
				 		gbcfAnterior.gridx = 3; 
				 		gbcfAnterior.gridy = 10;
				 		gbcfAnterior.insets= new Insets(5,5,5,5);
				 		ventanaAnterior.add(salir,gbcfAnterior);
				 		ventanaAnterior.pack();
					}
				}
			} catch(CamposVaciosException e1) {
				VentanaFallo v = new VentanaFallo(e1.getMessage());
				v.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v.setVisible(true);
			} catch (Exception e2) {
				VentanaFallo v2 = new VentanaFallo(e2.getMessage());
				v2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v2.setVisible(true);
			}
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}
	
	@SuppressWarnings("deprecation")
	private Boolean camposVacios() throws CamposVaciosException { //TODO ver si todos son obligatorios
		if(tnombre.getText().isEmpty() ||
				tapellido.getText().isEmpty() ||
				ttelefono.getText().isEmpty() ||
				tusuario.getText().isEmpty() ||
				tclaveacceso.getText().isEmpty()) throw new CamposVaciosException("Complete los "
				+ "campos obligatorios."); //TODO mejorar mensaje
		return false;
	}
	
	@SuppressWarnings("deprecation")
	private Boolean camposInvalidos() {
		try {
			if(fv.esAlfabetico(tnombre.getText(), "nombre") &&
					fv.esAlfabetico(tapellido.getText(), "apellido") &&
					fv.esAlfabetico(tusuario.getText(), "usuario") &&
					fv.passwordValida(((JPasswordField) tclaveacceso).getPassword().toString())) {
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
		} 
		return true;
	}

}
