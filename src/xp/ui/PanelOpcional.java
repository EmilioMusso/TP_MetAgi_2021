package xp.ui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.DropMode;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import xp.dto.OpcionalesInmuebleDTO;
import xp.enums.TipoInmueble;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Cursor;

public class PanelOpcional extends JPanel implements FocusListener {
	private JTextField tcalle;
	private JTextField tnumtelefono;
	private JTextField tbarrio;
	private JTextField tprecio;
	private JTextField tpisodpto;
	private JTextField tfrente;
	private JTextField tfondo;
	private JTextField tsuperficie;
	
	private JComboBox<String> boxOrientacion;
	private JComboBox<TipoInmueble> boxTipoInmueble;
	private JSpinner thabitaciones;
	private JSpinner tbaños;
	private JCheckBox propiedadhorizontal;
	private JCheckBox patio;
	private JCheckBox piscina;
	private JCheckBox cochera;
	private JCheckBox telefono;
	private JCheckBox cloacas;
	private JCheckBox lavadero;
	private JCheckBox aguacaliente;
	private JCheckBox aguacorriente;
	private JCheckBox gasnatural;
	private JCheckBox pavimento;
	private JTextArea tobservaciones;
	
	private OpcionalesInmuebleDTO dto;
	
	public PanelOpcional(OpcionalesInmuebleDTO opcionalesInmuebleDTO) {
		
		dto = opcionalesInmuebleDTO;
		
		setAutoscrolls(true);
		setMaximumSize(new Dimension(450, 500));
		setBackground(SystemColor.info);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{140, 80, 80, 80, 80};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 70, 11, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 4.9E-324};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel calle = new JLabel("Calle");
		calle.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_calle = new GridBagConstraints();
		gbc_calle.fill = GridBagConstraints.HORIZONTAL;
		gbc_calle.insets = new Insets(0, 0, 5, 5);
		gbc_calle.gridx = 0;
		gbc_calle.gridy = 0;
		add(calle, gbc_calle);
		
		JLabel pisoDpto = new JLabel("Piso/Dpto.");
		pisoDpto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_pisoDpto = new GridBagConstraints();
		gbc_pisoDpto.insets = new Insets(0, 0, 5, 5);
		gbc_pisoDpto.gridx = 1;
		gbc_pisoDpto.gridy = 0;
		add(pisoDpto, gbc_pisoDpto);
		
		JLabel orientacion = new JLabel("Orientacion");
		orientacion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_orientacion = new GridBagConstraints();
		gbc_orientacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_orientacion.insets = new Insets(0, 0, 5, 5);
		gbc_orientacion.gridx = 2;
		gbc_orientacion.gridy = 0;
		add(orientacion, gbc_orientacion);
		
		JLabel tipo = new JLabel("Tipo Inmueble");
		tipo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_tipo = new GridBagConstraints();
		gbc_tipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tipo.insets = new Insets(0, 0, 5, 0);
		gbc_tipo.gridx = 3;
		gbc_tipo.gridy = 0;
		add(tipo, gbc_tipo);
		
		tcalle = new JTextField();
		GridBagConstraints gbc_tcalle = new GridBagConstraints();
		gbc_tcalle.fill = GridBagConstraints.HORIZONTAL;
		gbc_tcalle.insets = new Insets(0, 0, 5, 5);
		gbc_tcalle.gridx = 0;
		gbc_tcalle.gridy = 1;
		add(tcalle, gbc_tcalle);
		tcalle.setColumns(10);
		
		tpisodpto = new JTextField();
		tpisodpto.setColumns(10);
		tpisodpto.addFocusListener(this);
		GridBagConstraints gbc_tpisodpto = new GridBagConstraints();
		gbc_tpisodpto.insets = new Insets(0, 0, 5, 5);
		gbc_tpisodpto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tpisodpto.gridx = 1;
		gbc_tpisodpto.gridy = 1;
		add(tpisodpto, gbc_tpisodpto);
		
		boxOrientacion = new JComboBox<String>();
		boxOrientacion.setModel(new DefaultComboBoxModel<String>(new String[] {"NORTE", "SUR", "ESTE", "OESTE", "NORESTE", "NOROESTE", "SURESTE", "SUROESTE"}));
		GridBagConstraints gbc_boxOrientacion = new GridBagConstraints();
		gbc_boxOrientacion.insets = new Insets(0, 0, 5, 5);
		gbc_boxOrientacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxOrientacion.gridx = 2;
		gbc_boxOrientacion.gridy = 1;
		add(boxOrientacion, gbc_boxOrientacion);
		
		boxTipoInmueble = new JComboBox<TipoInmueble>();
		boxTipoInmueble.setModel(new DefaultComboBoxModel<TipoInmueble>(TipoInmueble.values()));
		GridBagConstraints gbc_boxTipoInmueble = new GridBagConstraints();
		gbc_boxTipoInmueble.fill = GridBagConstraints.HORIZONTAL;
		gbc_boxTipoInmueble.insets = new Insets(0, 0, 5, 0);
		gbc_boxTipoInmueble.gridx = 3;
		gbc_boxTipoInmueble.gridy = 1;
		add(boxTipoInmueble, gbc_boxTipoInmueble);
		
		JLabel barrio = new JLabel("Barrio");
		barrio.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_barrio = new GridBagConstraints();
		gbc_barrio.fill = GridBagConstraints.BOTH;
		gbc_barrio.insets = new Insets(0, 0, 5, 5);
		gbc_barrio.gridx = 0;
		gbc_barrio.gridy = 2;
		add(barrio, gbc_barrio);
		
		JLabel precio = new JLabel("Precio (AR$)");
		precio.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_precio = new GridBagConstraints();
		gbc_precio.fill = GridBagConstraints.BOTH;
		gbc_precio.insets = new Insets(0, 0, 5, 5);
		gbc_precio.gridx = 1;
		gbc_precio.gridy = 2;
		add(precio, gbc_precio);
		
		JLabel habitaciones = new JLabel("Habitaciones");
		habitaciones.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_habitaciones = new GridBagConstraints();
		gbc_habitaciones.insets = new Insets(0, 0, 5, 5);
		gbc_habitaciones.gridx = 2;
		gbc_habitaciones.gridy = 2;
		add(habitaciones, gbc_habitaciones);
		
		JLabel baños = new JLabel("Ba\u00F1os");
		baños.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_baños = new GridBagConstraints();
		gbc_baños.insets = new Insets(0, 0, 5, 0);
		gbc_baños.gridx = 3;
		gbc_baños.gridy = 2;
		add(baños, gbc_baños);
		
		tbarrio = new JTextField();
		tbarrio.addFocusListener(this);
		GridBagConstraints gbc_tbarrio = new GridBagConstraints();
		gbc_tbarrio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbarrio.insets = new Insets(0, 0, 5, 5);
		gbc_tbarrio.gridx = 0;
		gbc_tbarrio.gridy = 3;
		add(tbarrio, gbc_tbarrio);
		tbarrio.setColumns(10);
		
		tprecio = new JTextField();
		tprecio.addFocusListener(this);
		tprecio.setColumns(10);
		GridBagConstraints gbc_tprecio = new GridBagConstraints();
		gbc_tprecio.insets = new Insets(0, 0, 5, 5);
		gbc_tprecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tprecio.gridx = 1;
		gbc_tprecio.gridy = 3;
		add(tprecio, gbc_tprecio);
		
		thabitaciones = new JSpinner();
		thabitaciones.setModel(new SpinnerNumberModel(1,1,null,1));
		GridBagConstraints gbc_thabitaciones = new GridBagConstraints();
		gbc_thabitaciones.fill = GridBagConstraints.HORIZONTAL;
		gbc_thabitaciones.insets = new Insets(0, 0, 5, 5);
		gbc_thabitaciones.gridx = 2;
		gbc_thabitaciones.gridy = 3;
		add(thabitaciones, gbc_thabitaciones);
		
		tbaños = new JSpinner();
		tbaños.setModel(new SpinnerNumberModel(1,0,null,1));
		GridBagConstraints gbc_tbaños = new GridBagConstraints();
		gbc_tbaños.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbaños.insets = new Insets(0, 0, 5, 0);
		gbc_tbaños.gridx = 3;
		gbc_tbaños.gridy = 3;
		add(tbaños, gbc_tbaños);
		
		JLabel numtelefono = new JLabel("Num. de Telefono");
		numtelefono.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_numtelefono = new GridBagConstraints();
		gbc_numtelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_numtelefono.insets = new Insets(0, 0, 5, 5);
		gbc_numtelefono.gridx = 0;
		gbc_numtelefono.gridy = 4;
		add(numtelefono, gbc_numtelefono);
		
		JLabel frente = new JLabel("Frente (m)");
		frente.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_frente = new GridBagConstraints();
		gbc_frente.insets = new Insets(0, 0, 5, 5);
		gbc_frente.gridx = 1;
		gbc_frente.gridy = 4;
		add(frente, gbc_frente);
		
		JLabel fondo = new JLabel("Fondo (m)");
		fondo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_fondo = new GridBagConstraints();
		gbc_fondo.insets = new Insets(0, 0, 5, 5);
		gbc_fondo.gridx = 2;
		gbc_fondo.gridy = 4;
		add(fondo, gbc_fondo);
		
		JLabel superficie = new JLabel("Superficie (m2)");
		superficie.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_superficie = new GridBagConstraints();
		gbc_superficie.insets = new Insets(0, 0, 5, 0);
		gbc_superficie.gridx = 3;
		gbc_superficie.gridy = 4;
		add(superficie, gbc_superficie);
		
		tnumtelefono = new JTextField();
		tnumtelefono.addFocusListener(this);
		GridBagConstraints gbc_tnumtelefono = new GridBagConstraints();
		gbc_tnumtelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_tnumtelefono.insets = new Insets(0, 0, 5, 5);
		gbc_tnumtelefono.gridx = 0;
		gbc_tnumtelefono.gridy = 5;
		add(tnumtelefono, gbc_tnumtelefono);
		tnumtelefono.setColumns(10);
		
		tfrente = new JTextField();
		tfrente.addFocusListener(this);
		GridBagConstraints gbc_tfrente = new GridBagConstraints();
		gbc_tfrente.insets = new Insets(0, 0, 5, 5);
		gbc_tfrente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfrente.gridx = 1;
		gbc_tfrente.gridy = 5;
		add(tfrente, gbc_tfrente);
		tfrente.setColumns(10);
		
		tfondo = new JTextField();
		tfondo.addFocusListener(this);
		GridBagConstraints gbc_tfondo = new GridBagConstraints();
		gbc_tfondo.insets = new Insets(0, 0, 5, 5);
		gbc_tfondo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfondo.gridx = 2;
		gbc_tfondo.gridy = 5;
		add(tfondo, gbc_tfondo);
		tfondo.setColumns(10);
		
		tsuperficie = new JTextField();
		tsuperficie.addFocusListener(this);
		GridBagConstraints gbc_tsuperficie = new GridBagConstraints();
		gbc_tsuperficie.insets = new Insets(0, 0, 5, 0);
		gbc_tsuperficie.fill = GridBagConstraints.HORIZONTAL;
		gbc_tsuperficie.gridx = 3;
		gbc_tsuperficie.gridy = 5;
		add(tsuperficie, gbc_tsuperficie);
		tsuperficie.setColumns(10);
		
		propiedadhorizontal = new JCheckBox("Propiedad Horizontal");
		propiedadhorizontal.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_propiedadhorizontal = new GridBagConstraints();
		gbc_propiedadhorizontal.fill = GridBagConstraints.HORIZONTAL;
		gbc_propiedadhorizontal.gridwidth = 4;
		gbc_propiedadhorizontal.insets = new Insets(0, 0, 5, 0);
		gbc_propiedadhorizontal.gridx = 0;
		gbc_propiedadhorizontal.gridy = 7;
		add(propiedadhorizontal, gbc_propiedadhorizontal);
		
		patio = new JCheckBox("Patio");
		GridBagConstraints gbc_patio = new GridBagConstraints();
		gbc_patio.fill = GridBagConstraints.HORIZONTAL;
		gbc_patio.gridwidth = 2;
		gbc_patio.insets = new Insets(0, 0, 5, 5);
		gbc_patio.gridx = 0;
		gbc_patio.gridy = 8;
		add(patio, gbc_patio);
		
		piscina = new JCheckBox("Piscina");
		GridBagConstraints gbc_piscina = new GridBagConstraints();
		gbc_piscina.fill = GridBagConstraints.HORIZONTAL;
		gbc_piscina.gridwidth = 2;
		gbc_piscina.insets = new Insets(0, 0, 5, 0);
		gbc_piscina.gridx = 2;
		gbc_piscina.gridy = 8;
		add(piscina, gbc_piscina);
		
		cochera = new JCheckBox("Cochera");
		cochera.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_cochera = new GridBagConstraints();
		gbc_cochera.fill = GridBagConstraints.HORIZONTAL;
		gbc_cochera.gridwidth = 2;
		gbc_cochera.insets = new Insets(0, 0, 5, 5);
		gbc_cochera.gridx = 0;
		gbc_cochera.gridy = 9;
		add(cochera, gbc_cochera);
	
		telefono = new JCheckBox("Telefono");
		GridBagConstraints gbc_telefono = new GridBagConstraints();
		gbc_telefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefono.gridwidth = 2;
		gbc_telefono.insets = new Insets(0, 0, 5, 0);
		gbc_telefono.gridx = 2;
		gbc_telefono.gridy = 9;
		add(telefono, gbc_telefono);
		
		cloacas = new JCheckBox("Cloacas");
		GridBagConstraints gbc_cloacas = new GridBagConstraints();
		gbc_cloacas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cloacas.gridwidth = 2;
		gbc_cloacas.insets = new Insets(0, 0, 5, 5);
		gbc_cloacas.gridx = 0;
		gbc_cloacas.gridy = 10;
		add(cloacas, gbc_cloacas);
	
		lavadero = new JCheckBox("Lavadero");
		GridBagConstraints gbc_lavadero = new GridBagConstraints();
		gbc_lavadero.fill = GridBagConstraints.HORIZONTAL;
		gbc_lavadero.gridwidth = 2;
		gbc_lavadero.insets = new Insets(0, 0, 5, 0);
		gbc_lavadero.gridx = 2;
		gbc_lavadero.gridy = 10;
		add(lavadero, gbc_lavadero);
		
		aguacaliente = new JCheckBox("Agua Caliente");
		GridBagConstraints gbc_aguacaliente = new GridBagConstraints();
		gbc_aguacaliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_aguacaliente.gridwidth = 2;
		gbc_aguacaliente.insets = new Insets(0, 0, 5, 5);
		gbc_aguacaliente.gridx = 0;
		gbc_aguacaliente.gridy = 11;
		add(aguacaliente, gbc_aguacaliente);

		aguacorriente = new JCheckBox("Agua Corriente");
		GridBagConstraints gbc_aguacorriente = new GridBagConstraints();
		gbc_aguacorriente.fill = GridBagConstraints.HORIZONTAL;
		gbc_aguacorriente.gridwidth = 2;
		gbc_aguacorriente.insets = new Insets(0, 0, 5, 0);
		gbc_aguacorriente.gridx = 2;
		gbc_aguacorriente.gridy = 11;
		add(aguacorriente, gbc_aguacorriente);
		
		gasnatural = new JCheckBox("Gas Natural");
		GridBagConstraints gbc_gasnatural = new GridBagConstraints();
		gbc_gasnatural.fill = GridBagConstraints.HORIZONTAL;
		gbc_gasnatural.gridwidth = 2;
		gbc_gasnatural.insets = new Insets(0, 0, 5, 5);
		gbc_gasnatural.gridx = 0;
		gbc_gasnatural.gridy = 12;
		add(gasnatural, gbc_gasnatural);
		
		pavimento = new JCheckBox("Pavimento");
		GridBagConstraints gbc_pavimento = new GridBagConstraints();
		gbc_pavimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_pavimento.gridwidth = 2;
		gbc_pavimento.insets = new Insets(0, 0, 5, 0);
		gbc_pavimento.gridx = 2;
		gbc_pavimento.gridy = 12;
		add(pavimento, gbc_pavimento);
		
		JLabel observaciones = new JLabel("Observaciones");
		observaciones.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_observaciones = new GridBagConstraints();
		gbc_observaciones.insets = new Insets(0, 0, 5, 5);
		gbc_observaciones.gridx = 0;
		gbc_observaciones.gridy = 13;
		add(observaciones, gbc_observaciones);
		

		tobservaciones = new JTextArea();
		tobservaciones.addFocusListener(this); 
		tobservaciones.setWrapStyleWord(true);
		tobservaciones.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		tobservaciones.setRows(4);
		tobservaciones.setMaximumSize(new Dimension(4, 4));
		tobservaciones.setTabSize(2);
		tobservaciones.setLineWrap(true);
		JScrollPane scrollBar = new JScrollPane(tobservaciones,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tobservaciones = new GridBagConstraints();
		gbc_tobservaciones.gridwidth = 4;
		gbc_tobservaciones.insets = new Insets(0, 0, 5, 0);
		gbc_tobservaciones.fill = GridBagConstraints.BOTH;
		gbc_tobservaciones.gridx = 0;
		gbc_tobservaciones.gridy = 14;
		add(scrollBar, gbc_tobservaciones);

		

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
    
	public OpcionalesInmuebleDTO getData() throws NumberFormatException {
		dto = new OpcionalesInmuebleDTO(tcalle.getText(),
				(tpisodpto.getText().isBlank()) ? 00 : Integer.parseInt(tpisodpto.getText()),
//				(tpisodpto.getText()=="") ? null : Integer.parseInt(tpisodpto.getText()),
				boxOrientacion.getSelectedItem().toString(),
				(TipoInmueble) boxTipoInmueble.getSelectedItem(),
				tbarrio.getText(),
				(tprecio.getText().isBlank()) ? 00 : Integer.parseInt(tprecio.getText()),
//				(tprecio.getText()=="") ? 00 : Integer.parseInt(tprecio.getText()),
				(Integer)thabitaciones.getValue(),
				(Integer)tbaños.getValue(),
				tnumtelefono.getText(),
				(tfrente.getText().isBlank()) ? 00 : Integer.parseInt(tfrente.getText()),
//				(tfrente.getText()=="") ? null : Integer.parseInt(tfrente.getText()),
				(tfondo.getText().isBlank()) ? 00 : Integer.parseInt(tfondo.getText()),
//				(tfondo.getText()=="") ? null : Integer.parseInt(tfondo.getText()),
				(tpisodpto.getText().isBlank()) ? 00 : Integer.parseInt(tsuperficie.getText()),
//				(tsuperficie.getText()=="") ? null : Integer.parseInt(tsuperficie.getText()),
				propiedadhorizontal.isSelected(),
				patio.isSelected(),
				piscina.isSelected(),
				cochera.isSelected(),
				telefono.isSelected(),
				cloacas.isSelected(),
				lavadero.isSelected(),
				aguacaliente.isSelected(),
				aguacorriente.isSelected(), 
				gasnatural.isSelected(),
				pavimento.isSelected(),
				tobservaciones.getText());
		return dto;
	}
	
	public void focusGained(FocusEvent e) {
		try {
			this.getData();
		} catch (NumberFormatException ex) {
		}
		
	}
	public void focusLost(FocusEvent e) {
		try {
			this.getData();
		} catch (NumberFormatException ex) {
		}			
	}
    
}
