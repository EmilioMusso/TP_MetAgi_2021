package xp.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.util.BitSet;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import xp.db.T_inmueble;
import xp.db.T_vendedor;
import xp.utils.FieldValidators;

public class AltaInmueble_panel extends JPanel {

	private JLabel tit;
	private JLabel codigoInmueble; 
	private JTextField tcodigoInmueble;
	private JLabel estadoInmueble;
	private JTextField testadoInmueble;
	private JLabel localidad; //ver de hacer con combobox
	private JTextField tlocalidad;
	private JLabel provincia;
	//private JComboBox<String> ttipodoc;
	//private JLabel nrodoc;
	private JTextField tprovincia;
	private JLabel fechaCarga;
	private JCalendar tfechaCarga;
	
	private JButton agregar;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	
	
	public AltaInmueble_panel() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel();
	}
	
	public AltaInmueble_panel armarPanel() {
		
		this.tit = new JLabel("Alta de Inmueble");
		this.codigoInmueble = new JLabel("Codigo del Inmueble");
		this.tcodigoInmueble = new JTextField(4); //fijarse el maximo
		this.estadoInmueble = new JLabel("Estado del inmueble(1,2,3)");
		this.testadoInmueble = new JTextField(4);
		this.localidad = new JLabel("Localidad");
		this.tlocalidad = new JTextField(40);
		this.provincia = new JLabel("Provincia");
		this.tprovincia = new JTextField(40);
		this.fechaCarga = new JLabel("Fecha de carga:");
		this.tfechaCarga = new JCalendar();	
		this.agregar = new JButton("Agregar"); 
		
		gbc.gridx = 0;		//posici�n
		gbc.gridy = 0;
		gbc.weightx = 0.1;	//peso
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.EAST;	//ubicaci�n
		//gbc.ipadx = 10;						//margen int		
		//gbc.ipady = 10;
		gbc.insets= new Insets(5,5,5,5);	 	//top,left,bottom,right 	
		
		//T�tulo
		this.add(tit,gbc);
		tit.setForeground(Color.BLUE);
		tit.setFont(tit.getFont().deriveFont(22.0f));
	
		
		//labels
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(codigoInmueble,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(estadoInmueble,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(localidad,gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(provincia,gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(fechaCarga,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		
		
		
		//text
		gbc.gridx = 2;
		gbc.gridy = 1;
		//gbc.weightx = 0.5;
		//gbc.weighty = 0.1;
		gbc.gridwidth=2;						//cant celdas
		gbc.anchor = GridBagConstraints.WEST;
		this.add(tcodigoInmueble,gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(testadoInmueble,gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		this.add(tlocalidad,gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(tprovincia,gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		this.add(tfechaCarga,gbc);
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
			String codI = this.tcodigoInmueble.getText(); 
			String estI = this.testadoInmueble.getText();
			String loc = (String) this.tlocalidad.getText();
			String prov = this.tprovincia.getText();
			String fechaString= fechaCarga.toString();
			
			T_inmueble iT = new T_inmueble();
			iT.insert(codI, estI, loc, prov, fechaString); //falta la fecha
						
//			T_vendedor aT = new T_vendedor();
//			aT.insert(nom, ape, tipodoc, nrodoc, claveacceso);
			
//			tit.setText("Vendedor " + aT.toString() + " agregado correctamente!");
			
			VentanaExito ventanaExito = new VentanaExito("Inmueble agregado correctamente.");
			ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ventanaExito.setVisible(true);
//			tit.setForeground(Color.RED);
//			agregar.setEnabled(false);
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}
	
	/*private Boolean camposValidos() {
		BitSet bitSetValidacioneSet = new BitSet(4);
		bitSetValidacioneSet.clear();
		
		bitSetValidacioneSet.set(0, fv.campoAlfabetico(tnombre.getText()));
		bitSetValidacioneSet.set(1, fv.campoAlfabetico(tapellido.getText()));
		bitSetValidacioneSet.set(2, fv.campoNumerico(tnrodoc.getText()));
		bitSetValidacioneSet.set(3, fv.campoPassword(tclaveacceso.getText()));
		
		return !bitSetValidacioneSet.isEmpty();
	}*/

}