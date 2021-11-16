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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
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
	private JComboBox<String> boxLocalidad;
	private JTextField otraLocalidad;
	private JLabel provincia;
	//private JComboBox<String> ttipodoc;
	//private JLabel nrodoc;
	private JComboBox<String> boxProvincia;
	private JLabel fechaCarga;
	
	private JDateChooser calendarFechaCarga;
	private Date fechaSelected; //TODO setear por default fecha actual
	private Integer diaFechaSelected;
	private Integer mesFechaSelected;
	private Integer anioFechaSelected;
	private String selectedLocalidad;
	private String selectedProvincia;
	
	private JButton seleccionarPropietario;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	private PanelOpcional panelOpcional;
	
	
	
	public AltaInmueble_panel(AppSistema appSistema, JButton agregar) { //TODO para usar en task kard
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(appSistema, agregar);
	}
	
	public AltaInmueble_panel armarPanel(AppSistema appSistema, JButton agregar) {
		
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
		this.fechaCarga = new JLabel("Fecha de carga:");
		
		
//		--------------------------------------------------------Box de estado
		this.testadoInmueble = new JComboBox<EstadoInmueble>();
		this.testadoInmueble.addItem(EstadoInmueble.DISPONIBLE);
		this.testadoInmueble.addItem(EstadoInmueble.RESERVADO);
		this.testadoInmueble.addItem(EstadoInmueble.VENDIDO);
		
//		--------------------------------------------------------Box de localidades
		this.boxLocalidad = new JComboBox<String>();
		appSistema.getLocalidadesSistema().stream().forEach(loc -> {
			this.boxLocalidad.addItem(loc.getNombre());
		});
		this.boxLocalidad.addItem("Otra...");
		this.selectedLocalidad=boxLocalidad.getSelectedItem().toString();
		
		this.boxLocalidad.addActionListener(act -> {
			if(this.boxLocalidad.getSelectedItem()=="Otra...") {
				otraLocalidad.setEnabled(true);
			} else {
				otraLocalidad.setEnabled(false);
				otraLocalidad.setText("");
			}
		});
		
//		--------------------------------------------------------Box de provincias
		this.boxProvincia= new JComboBox<String>();
		appSistema.getProvinciasSistema().stream().forEach(prov -> {
			this.boxProvincia.addItem(prov);
		});
		this.selectedProvincia=boxProvincia.getSelectedItem().toString();
		this.boxProvincia.addActionListener(act -> {
			otraLocalidad.setText("");
			if(this.boxProvincia.getSelectedItem()!="Santa Fe") {
				otraLocalidad.setEnabled(true);
				boxLocalidad.setEnabled(false);
			} else {
				otraLocalidad.setEnabled(false);
				boxLocalidad.setEnabled(true);
				boxLocalidad.setSelectedItem("Santa Fe");
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
		
		//Titulo
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
		
		
//		gbc.gridx = 2;
//		gbc.gridy = 3;
//		this.add(boxLocalidad,gbc);
//		gbc.gridx = 2;
//		gbc.gridy = 4;
//		this.add(otraLocalidad,gbc);
//		otraLocalidad.setEnabled(false);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 4;
		gbc_separator.gridx = 2;
		gbc_separator.gridy = 3;
		add(separator, gbc);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 0, 5);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 2;
		gbc_splitPane.gridy = 3;
		add(splitPane, gbc_splitPane);
		
		splitPane.setLeftComponent(boxLocalidad);

		this.add(otraLocalidad,gbc);
		otraLocalidad.setEnabled(false);
		splitPane.setRightComponent(otraLocalidad);
		
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(boxProvincia,gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		this.add(calendarFechaCarga,gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		
		panelOpcional = new PanelOpcional();
		gbc.gridx = 1;
		gbc.gridy = 8;
		this.add(panelOpcional, gbc);
		
		this.seleccionarPropietario = new JButton("Seleccionar Propietario");
		gbc.gridx = 1;
		gbc.gridy = 7;
		this.add(seleccionarPropietario, gbc);
		
		seleccionarPropietario.addActionListener(a -> {
			//TODO ir a seleccionar propietario de la lista
		});
		
		agregar.addActionListener(e -> {
		
			String codI = this.tcodigoInmueble.getText(); 
			String estI = this.testadoInmueble.getSelectedItem().toString();
			String loc;
			if(this.boxLocalidad.getSelectedItem()=="Otra...") {
				loc = this.otraLocalidad.getText();
			} else {
				loc = this.selectedLocalidad;
			}
			String prov = this.provincia.getText();

//TODO levantar valor date del calendario
//		System.out.println(this.calendarFechaCarga);

//		System.out.println(calendarFechaCarga.getDayChooser().getDay());
//		System.out.println(calendarFechaCarga.getMonthChooser().getMonth());
//		System.out.println(calendarFechaCarga.getYearChooser().getYear());
//		
//		this.diaFechaSelected = calendarFechaCarga.getDayChooser().getDay();
//		this.mesFechaSelected = calendarFechaCarga.getMonthChooser().getMonth();
//		this.anioFechaSelected = calendarFechaCarga.getYearChooser().getYear();
//		
//		
//		
//		T_inmueble iT = new T_inmueble();
//		try {
//			iT.insert(codI, estI, loc, prov, fechaSelected);
//			VentanaExito ventanaExito = new VentanaExito("Inmueble agregado correctamente.");
//			ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			ventanaExito.setVisible(true);
//			
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//			VentanaFallo ventanaFallo = new VentanaFallo("Hubo un error al cargar los datos. "
//					+ "Intente nuevamente.");
//			ventanaFallo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			ventanaFallo.setVisible(true);
//		}

		
//		T_vendedor aT = new T_vendedor();
//		aT.insert(nom, ape, tipodoc, nrodoc, claveacceso);

//		tit.setText("Vendedor " + aT.toString() + " agregado correctamente!");

//		tit.setForeground(Color.RED);
//		agregar.setEnabled(false);
		});
	
		return this;
	}
}