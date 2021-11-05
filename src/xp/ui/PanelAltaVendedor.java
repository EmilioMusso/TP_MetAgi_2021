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
import xp.model.Vendedor;
import xp.utils.FieldValidators;


public class PanelAltaVendedor extends JPanel {
	
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
	
	
	public PanelAltaVendedor() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel();
	}
	
	public PanelAltaVendedor armarPanel() {
		
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
		this.add(agregar,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 10;	
		
		agregar.addActionListener(e -> {
			String nom = this.tnombre.getText();
			String ape = this.tapellido.getText();
			String tipodoc = (String) this.ttipodoc.getSelectedItem();
			String nrodoc = this.tnrodoc.getText();
			String claveacceso = this.claveacceso.getText();
			
			Vendedor vendedor = new Vendedor(nom, ape, tipodoc, nrodoc, claveacceso);
						
//			T_vendedor aT = new T_vendedor();
//			aT.insert(nom, ape, tipodoc, nrodoc, claveacceso);
			
			tit.setText("Vendedor " + vendedor.toString() + " agregado correctamente!");
//			VentanaExito ventanaExito = new VentanaExito("Vendedor " + vendedor.toString() + " agregado correctamente.");
//			tit.setForeground(Color.RED);
//			agregar.setEnabled(false);
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}
	
	private Boolean camposValidos() {
		BitSet bitSetValidacioneSet = new BitSet(4);
		bitSetValidacioneSet.clear();
		
		bitSetValidacioneSet.set(0, fv.campoAlfabetico(tnombre.getText()));
		bitSetValidacioneSet.set(1, fv.campoAlfabetico(tapellido.getText()));
		bitSetValidacioneSet.set(2, fv.campoNumerico(tnrodoc.getText()));
		bitSetValidacioneSet.set(3, fv.campoPassword(tclaveacceso.getText()));
		
		return !bitSetValidacioneSet.isEmpty();
	}

}


/*





package xp.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.BitSet;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import xp.model.Vendedor;
import xp.utils.*;

import javax.swing.JPasswordField;

public class PanelAltaVendedor extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JPasswordField txtClaveAcceso;
	
	private FieldValidators fv;

	/**
	 * Create the panel.
	 *
	public PanelAltaVendedor(JFrame frame) {
		super();
		frame.setContentPane(this);
		this.setBounds(0, 0, 784, 561);
		setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 764, 539);
		add(desktopPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		desktopPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 36, 86, 20);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(162, 11, 46, 14);
		desktopPane.add(lblApellido);
		
		txtApellido= new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(162, 36, 86, 20);
		desktopPane.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(10, 112, 86, 20);
		desktopPane.add(txtDni);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 87, 46, 14);
		desktopPane.add(lblDni);
		
		JLabel lblClaveAcceso = new JLabel("Clave");
		lblClaveAcceso.setBounds(10, 163, 46, 14);
		desktopPane.add(lblClaveAcceso);
		
		txtClaveAcceso = new JPasswordField();
		txtClaveAcceso.setBounds(10, 188, 86, 20);
		desktopPane.add(txtClaveAcceso);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(664, 500, 90, 28);
		desktopPane.add(btnCrear);
		btnCrear.addActionListener(a -> {
			if(camposValidos()) {
				Vendedor v1 = new Vendedor(
						txtNombre.getText(),
						txtApellido.getText(),
						txtDni.getText(),
						txtClaveAcceso.getPassword().toString());
				//TODO guardar en app
				VentanaExito exito = new VentanaExito("EL VENDEDOR HA SIDO CREADO CON EXITO.");
				exito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				exito.setVisible(true);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(564, 500, 90, 28);
		desktopPane.add(btnCancelar);
		btnCancelar.addActionListener(a -> {
			
		});		
	}


}
*/