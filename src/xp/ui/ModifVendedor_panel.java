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


public class ModifVendedor_panel extends JPanel {
	
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
	
	private JButton modificar;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	
	
	public ModifVendedor_panel(Vendedor v1) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(v1);
	}
	
	public ModifVendedor_panel armarPanel(Vendedor v1) {
		
		this.tit = new JLabel("Alta de vendedor");
		this.nombre = new JLabel("Nombre");
		this.tnombre = new JTextField(40);
		this.tnombre.setText(v1.getNombre());
		this.apellido = new JLabel("Apellido");
		this.tapellido = new JTextField(40);
		this.tapellido.setText(v1.getApellido());
		this.tipodoc = new JLabel("Tipo doc.");
		this.ttipodoc = new JComboBox<String>();
		this.ttipodoc.setSelectedItem(v1.getTipoDoc());
		this.nrodoc = new JLabel("Nro. doc.");
		this.tnrodoc = new JTextField(40);
		this.tnrodoc.setText(v1.getNumDoc());
		this.claveacceso = new JLabel("Clave de acceso");
		this.tclaveacceso = new JPasswordField(40);
		
				
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
		this.add(modificar,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 10;	
		
		modificar.addActionListener(e -> {
			Object id = v1.getId();
			String nom = this.tnombre.getText();
			String ape = this.tapellido.getText();
			String tipodoc = (String) this.ttipodoc.getSelectedItem();
			String nrodoc = this.tnrodoc.getText();
			String claveacceso = this.tclaveacceso.getText();
			
			T_vendedor aT = new T_vendedor();
			aT.delete(id);
			aT.insert(nom, ape, tipodoc, nrodoc, claveacceso);
						
//			T_vendedor aT = new T_vendedor();
//			aT.insert(nom, ape, tipodoc, nrodoc, claveacceso);
			
//			tit.setText("Vendedor " + aT.toString() + " agregado correctamente!");
			VentanaExito ventanaExito = new VentanaExito("Vendedor agregado correctamente.");
			ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ventanaExito.setVisible(true);
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
