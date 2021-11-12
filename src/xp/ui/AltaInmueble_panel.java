package xp.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.BitSet;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import xp.AppSistema;
import xp.db.T_inmueble;
import xp.db.T_vendedor;
import xp.model.Inmueble.EstadoInmueble;
import xp.utils.FieldValidators;

public class AltaInmueble_panel extends JPanel {

	private JLabel tit;
	private JLabel codigoInmueble; 
	private JTextField tcodigoInmueble;
	private JLabel estadoInmueble;
//	private String testadoInmueble;
	private JComboBox<EstadoInmueble> testadoInmueble;
	private JLabel localidad;
//	private JTextField tlocalidad;
	private JComboBox<String> tlocalidad;
	private JTextField otraLocalidad;
	private JLabel provincia;
	//private JComboBox<String> ttipodoc;
	//private JLabel nrodoc;
	private JTextField tprovincia;
	private JLabel fechaCarga;
	
	private JDateChooser calendarFechaCarga;
	private Date fechaSelected; //TODO setear por default fecha actual
	private Integer diaFechaSelected;
	private Integer mesFechaSelected;
	private Integer anioFechaSelected;
	private String selectedLocalidad;
	
	private JButton agregar;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	
	
	public AltaInmueble_panel(AppSistema appSistema) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(appSistema);
	}
	
	public AltaInmueble_panel armarPanel(AppSistema appSistema) {
		
		this.tit = new JLabel("Alta de Inmueble");
		this.codigoInmueble = new JLabel("Codigo del Inmueble");
		this.tcodigoInmueble = new JTextField(4); //fijarse el maximo
//		this.estadoInmueble = new JLabel("Estado del inmueble(1,2,3)");
		this.estadoInmueble = new JLabel("Estado del inmueble");
//		this.testadoInmueble = new JTextField(4);
		this.localidad = new JLabel("Localidad");
		this.otraLocalidad = new JTextField(10);
//		this.tlocalidad = new JTextField(40);
		this.provincia = new JLabel("Provincia");
		this.tprovincia = new JTextField(40);
		this.fechaCarga = new JLabel("Fecha de carga:");
			
		this.agregar = new JButton("Agregar");
		
		
//		--------------------------------------------------------Box de estado
		this.testadoInmueble = new JComboBox<EstadoInmueble>();
		this.testadoInmueble.addItem(EstadoInmueble.DISPONIBLE);
		this.testadoInmueble.addItem(EstadoInmueble.RESERVADO);
		this.testadoInmueble.addItem(EstadoInmueble.VENDIDO);
		
//		--------------------------------------------------------Box de localidades
		this.tlocalidad = new JComboBox<String>();
		appSistema.getLocalidadesSistema().stream().forEach(loc -> {
			this.tlocalidad.addItem(loc.getNombre());
		});
		this.tlocalidad.addItem("Otra...");
		this.selectedLocalidad=tlocalidad.getSelectedItem().toString();
		
		this.tlocalidad.addActionListener(act -> {
			if(this.tlocalidad.getSelectedItem()=="Otra...") {
				otraLocalidad.setEnabled(true);
			}
		});
		
		
		this.calendarFechaCarga = new JDateChooser();
		this.calendarFechaCarga.setDate(new Date(1111111111));
		this.calendarFechaCarga.setDateFormatString("dd-MM-yyyy");
//		System.out.println(this.calendarFechaCarga.getDate().toString());

		
//		Date fechaSelected = new Date(diaFechaSelected, mesFechaSelected, anioFechaSelected);
		
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
		gbc.gridy = 5;
		this.add(provincia,gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(fechaCarga,gbc);
		gbc.gridx = 0;
		gbc.gridy = 7;
		
		
		
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
		this.add(otraLocalidad,gbc);
		otraLocalidad.setEnabled(false);
		gbc.gridx = 2;
		gbc.gridy = 5;
		this.add(tprovincia,gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		this.add(calendarFechaCarga,gbc);
		gbc.gridx = 2;
		gbc.gridy = 7;
		
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
			String codI = this.tcodigoInmueble.getText(); 
			String estI = this.testadoInmueble.getSelectedItem().toString();
			String loc;
			if(this.tlocalidad.getSelectedItem()=="Otra...") {
				loc = this.otraLocalidad.getText();
			} else {
				loc = this.selectedLocalidad;
			}
			String prov = this.tprovincia.getText();
			
			//TODO levantar valor date del calendario
//			System.out.println(this.calendarFechaCarga);
			
//			System.out.println(calendarFechaCarga.getDayChooser().getDay());
//			System.out.println(calendarFechaCarga.getMonthChooser().getMonth());
//			System.out.println(calendarFechaCarga.getYearChooser().getYear());
//			
//			this.diaFechaSelected = calendarFechaCarga.getDayChooser().getDay();
//			this.mesFechaSelected = calendarFechaCarga.getMonthChooser().getMonth();
//			this.anioFechaSelected = calendarFechaCarga.getYearChooser().getYear();
//			
//			
//			
//			T_inmueble iT = new T_inmueble();
//			try {
//				iT.insert(codI, estI, loc, prov, fechaSelected);
//				VentanaExito ventanaExito = new VentanaExito("Inmueble agregado correctamente.");
//				ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				ventanaExito.setVisible(true);
//				
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//				VentanaFallo ventanaFallo = new VentanaFallo("Hubo un error al cargar los datos. "
//						+ "Intente nuevamente.");
//				ventanaFallo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				ventanaFallo.setVisible(true);
//			}
		
						
//			T_vendedor aT = new T_vendedor();
//			aT.insert(nom, ape, tipodoc, nrodoc, claveacceso);
			
//			tit.setText("Vendedor " + aT.toString() + " agregado correctamente!");
			
//			tit.setForeground(Color.RED);
//			agregar.setEnabled(false);
		});
			
			
		//this.agregar.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		return this;
	}
	
	/*private Boolean camposValidos() {

	}*/

}