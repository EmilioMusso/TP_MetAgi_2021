package xp.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.BitSet;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import xp.dto.OpcionalesInmuebleDTO;
import xp.enums.EstadoInmueble;
import xp.enums.TipoInmueble;
import xp.exceptions.CamposVaciosException;
import xp.model.Inmueble;
import xp.model.Propietario;
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
	private JTextField tpropietarioselected;
	private JLabel provincia;
	//private JComboBox<String> ttipodoc;
	//private JLabel nrodoc;
	private JComboBox<String> boxProvincia;
	private JLabel fechaCarga;
	private java.sql.Date tFechaCarga;
	
	private JDateChooser calendarFechaCarga;
	private Date fechaSelected;
	private Integer diaFechaSelected;
	private Integer mesFechaSelected;
	private Integer anioFechaSelected;
	private String selectedLocalidad;
	private String selectedProvincia;
	private Propietario propietarioSelected;
	private Inmueble inm; 
	
	private String codI;
	private EstadoInmueble estI;
	private String loc;
	private String prov;
	private String msg;
	
	private JButton seleccionarPropietario;
	
	private FieldValidators fv;
	
	private GridBagConstraints gbc;
	private PanelOpcional panelOpcional;
	private OpcionalesInmuebleDTO inmuebleDTO;
	
	
	public AltaInmueble_panel(JFrame ventana, GridBagConstraints gbcf, AppSistema appSistema,
			JButton agregar, JButton salir) {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		armarPanel(ventana, gbcf, appSistema, agregar, salir);
	}
	
	public AltaInmueble_panel armarPanel(JFrame ventana, GridBagConstraints gbcf,
			AppSistema appSistema, JButton agregar, JButton salir) {
		
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
		Date today = Calendar.getInstance().getTime();
		this.calendarFechaCarga.setDate(today);
		this.calendarFechaCarga.setDateFormatString("dd-MM-yyyy");
		
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
		
		inmuebleDTO = new OpcionalesInmuebleDTO("", 0, "", TipoInmueble.C,"",
				0, 0, 0, "", 0,0,0,false,false,false,false,false,false,false,false,false,false,false,"");		
		
		panelOpcional = new PanelOpcional(inmuebleDTO);
		gbc.gridx = 1;
		gbc.gridy = 8;
		this.add(panelOpcional, gbc);
		
		JSplitPane splitPane2 = new JSplitPane();
		GridBagConstraints gbc_splitPane2 = new GridBagConstraints();
		gbc_splitPane2.insets = new Insets(0, 0, 0, 5);
		gbc_splitPane2.fill = GridBagConstraints.BOTH;
		gbc_splitPane2.gridx = 2;
		gbc_splitPane2.gridy = 7;
		add(splitPane2, gbc_splitPane2);
		this.seleccionarPropietario = new JButton("Seleccionar Propietario");
		splitPane2.setLeftComponent(seleccionarPropietario);
//		this.add(seleccionarPropietario, gbc);
		otraLocalidad.setEnabled(false);
		tpropietarioselected = new JTextField(40);
		splitPane2.setRightComponent(tpropietarioselected);
		tpropietarioselected.setEditable(false);
		tpropietarioselected.setText("Ningun propietario seleccionado");
		
		
		seleccionarPropietario.addActionListener(a -> {
			JFrame tmpFrame = new JFrame("Seleccionar Propietario");
			SeleccionarPropietario_Panel sp = new SeleccionarPropietario_Panel(tmpFrame, this);
			tmpFrame.setContentPane(sp);
			tmpFrame.setVisible(true);
			tmpFrame.pack();
			msg = "Ningun propietario seleccionado";
			tpropietarioselected.setText(msg);
		});
		
		agregar.addActionListener(e -> {
			try {
				if(!camposVacios() && true) {
					codI = this.tcodigoInmueble.getText(); 
					estI = (EstadoInmueble) this.testadoInmueble.getSelectedItem();
					
					
//					----------------------------------------------------------------------------------fecha de carga
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					String str_fecha = df.format(this.calendarFechaCarga.getDate());
					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.YEAR, this.calendarFechaCarga.getDate().getYear()+1900);
					calendar.set(Calendar.DAY_OF_MONTH, this.calendarFechaCarga.getDate().getMonth());
					calendar.set(Calendar.MONTH, this.calendarFechaCarga.getDate().getDay());

					tFechaCarga = new java.sql.Date(calendar.getTime().getTime());				
//					----------------------------------------------------------------------------------
					
					
					
					if(this.boxLocalidad.getSelectedItem()=="Otra..." || this.boxProvincia.getSelectedItem()!="Santa Fe") {
						loc = this.otraLocalidad.getText();
					} else {
						loc = this.selectedLocalidad;
					}
					prov = this.boxProvincia.getSelectedItem().toString();
					
					T_inmueble iT = new T_inmueble();
					inmuebleDTO = panelOpcional.getData();
					inm = new Inmueble(Integer.parseInt(codI), codI, estI, loc, prov, tFechaCarga,
							propietarioSelected.getId(),inmuebleDTO.getCalle(), inmuebleDTO.getNroTelefono(),
							inmuebleDTO.getBarrio(), inmuebleDTO.getPrecio(),
							inmuebleDTO.getPisoDpto(), inmuebleDTO.getFrente(), inmuebleDTO.getFondo(),
							inmuebleDTO.getSuperficie(), inmuebleDTO.getOrientacion(), inmuebleDTO.getTipoInmueble(),
							inmuebleDTO.getHabitaciones(), inmuebleDTO.getHabitaciones(), inmuebleDTO.getPropiedadHorizontal(),
							inmuebleDTO.getPatio(), inmuebleDTO.getPiscina(),
							inmuebleDTO.getCochera(), inmuebleDTO.getTelefono(), inmuebleDTO.getCloacas(),
							inmuebleDTO.getLavadero(), inmuebleDTO.getAguaCaliente(), inmuebleDTO.getAguaCorriente(),
							inmuebleDTO.getGasNatural(), inmuebleDTO.getPavimento(), inmuebleDTO.getObservaciones());
										
//			    	 ventana.setContentPane(new AltaInmueble_panel(ventana, gbcf, appSistema,agregar, salir));
//			 		 gbcf.gridx = 3;
//			 		 gbcf.gridy = 9;
//			 		 ventana.add(agregar, gbcf);
//			    	 gbcf.gridx = 4;
//			 		 gbcf.gridy = 9;
//			 		 gbcf.insets= new Insets(5,5,5,5);
//			 		 ventana.add(salir,gbcf);
//			    	 ventana.pack();
					resetearCampos();
			    	 
					try {
						iT.insertInmueble(inm);
						VentanaExito ventanaExito = new VentanaExito("Inmueble agregado correctamente.");
						ventanaExito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						ventanaExito.setVisible(true);
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						VentanaFallo ventanaFallo = new VentanaFallo("Hubo un error al cargar los datos. "
								+ "Intente nuevamente.");
						ventanaFallo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						ventanaFallo.setVisible(true);
					}
				}
			} catch (CamposVaciosException e1) {
				VentanaFallo v1 = new VentanaFallo(e1.getMessage());
				v1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				v1.setVisible(true);
			}
		});
	
		return this;
	}
	
	private void resetearCampos() {
		tcodigoInmueble.setText("");		
	}

	private Boolean camposVacios() throws CamposVaciosException {
		if(tcodigoInmueble.getText().isEmpty()) {
			throw new CamposVaciosException("Complete los "
				+ "campos obligatorios: Codigo del inmueble.");
		}
		if(boxLocalidad.getSelectedItem()=="Otra..." && otraLocalidad.getText().isEmpty()) {
			throw new CamposVaciosException("Complete los "
				+ "campos obligatorios: Localidad.");
		}
		if(propietarioSelected==null) {
			throw new CamposVaciosException("Complete los "
				+ "campos obligatorios: Propietario.");
		}
		
		
		return false;
	}
	
	public void cambiarNombrePropietario(Propietario p1) {
		propietarioSelected = p1;
		msg = (propietarioSelected == null) ? "Ningun propietario seleccionado" : propietarioSelected.nombreToString();
		tpropietarioselected.setText(msg);
	}
}