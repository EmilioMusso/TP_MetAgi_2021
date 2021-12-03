package xp.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import xp.db.T_inmueble;
import xp.db.T_propietario;
import javax.swing.JSeparator;

public class Cons_Inmueble {

	public JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cons_Inmueble window = new Cons_Inmueble();
					window.frame.setVisible(true);
					window.frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cons_Inmueble() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Inmuebles");
		frame.setBounds(100, 100, 573, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Consulta de inmuebles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Provincia");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox comboProv = new JComboBox();
		GridBagConstraints gbc_comboProv = new GridBagConstraints();
		gbc_comboProv.insets = new Insets(0, 0, 5, 5);
		gbc_comboProv.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboProv.gridx = 0;
		gbc_comboProv.gridy = 3;
		frame.getContentPane().add(comboProv, gbc_comboProv);
				
		T_inmueble Ti = new T_inmueble();
		ArrayList<String> i_rs = new ArrayList<String>();
	    i_rs= Ti.buscar_provincia();
	    for (String nom: i_rs) {
	    	comboProv.addItem(nom);}
	    comboProv.setSelectedItem(null);
	    
	    JLabel lblNewLabel_2 = new JLabel("Localidad");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboLoc = new JComboBox();
		GridBagConstraints gbc_comboLoc = new GridBagConstraints();
		gbc_comboLoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboLoc.insets = new Insets(0, 0, 5, 5);
		gbc_comboLoc.gridx = 0;
		gbc_comboLoc.gridy = 5;
		frame.getContentPane().add(comboLoc, gbc_comboLoc);
		
		T_inmueble Ti2 = new T_inmueble();
		ArrayList<String> i2_rs = new ArrayList<String>();
	    i2_rs= Ti2.buscar_localidad();
	    for (String nom: i2_rs) {
	    	comboLoc.addItem(nom);}
	    comboLoc.setSelectedItem(null);
	    
	    JLabel lblNewLabel_3 = new JLabel("Barrio");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox comboBar = new JComboBox();
		GridBagConstraints gbc_comboBar = new GridBagConstraints();
		gbc_comboBar.insets = new Insets(0, 0, 5, 5);
		gbc_comboBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBar.gridx = 0;
		gbc_comboBar.gridy = 7;
		frame.getContentPane().add(comboBar, gbc_comboBar);
		
		T_inmueble Ti3 = new T_inmueble();
		ArrayList<String> i3_rs = new ArrayList<String>();
	    i3_rs= Ti3.buscar_barrio();
	    for (String nom: i3_rs) {
	    	comboBar.addItem(nom);}
	    comboBar.setSelectedItem(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(5, 5, 5, 0);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox comboTip = new JComboBox();
		GridBagConstraints gbc_comboTip = new GridBagConstraints();
		gbc_comboTip.insets = new Insets(0, 0, 5, 0);
		gbc_comboTip.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTip.gridx = 1;
		gbc_comboTip.gridy = 3;
		frame.getContentPane().add(comboTip, gbc_comboTip);
		
		T_inmueble Ti4 = new T_inmueble();
		ArrayList<String> i4_rs = new ArrayList<String>();
	    i4_rs= Ti4.buscar_tipo();
	    for (String nom: i4_rs) {
	    	comboTip.addItem(nom);}
	    comboTip.setSelectedItem(null);
		
		JLabel lblNewLabel_5 = new JLabel("Cant. dormitorios");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 4;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JComboBox comboDor = new JComboBox();
		GridBagConstraints gbc_comboDor = new GridBagConstraints();
		gbc_comboDor.insets = new Insets(0, 0, 5, 0);
		gbc_comboDor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDor.gridx = 1;
		gbc_comboDor.gridy = 5;
		frame.getContentPane().add(comboDor, gbc_comboDor);
		
		T_inmueble Ti5 = new T_inmueble();
		ArrayList<String> i5_rs = new ArrayList<String>();
	    i5_rs= Ti5.buscar_habit();
	    for (String nom: i5_rs) {
	    	comboDor.addItem(nom);}
	    comboDor.setSelectedItem(null);
			    
		JLabel lblNewLabel_6 = new JLabel("Precio");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 6;
		frame.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JComboBox comboPre = new JComboBox();
		GridBagConstraints gbc_comboPre = new GridBagConstraints();
		gbc_comboPre.insets = new Insets(0, 0, 5, 0);
		gbc_comboPre.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboPre.gridx = 1;
		gbc_comboPre.gridy = 7;
		frame.getContentPane().add(comboPre, gbc_comboPre);
		
		T_inmueble Ti6 = new T_inmueble();
		ArrayList<String> i6_rs = new ArrayList<String>();
	    i6_rs= Ti6.buscar_precio();
	    for (String nom: i6_rs) {
	    	comboPre.addItem(nom);}
	    comboPre.setSelectedItem(null);
		
	
		// ---- Tabla
		
		DefaultTableModel model = new DefaultTableModel(); 
		
		table_1 = new JTable(model);
		table_1.setCellSelectionEnabled(true);
		table_1.setColumnSelectionAllowed(true);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.gridwidth = 2;
		gbc_table_1.insets = new Insets(5, 5, 5, 0);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 17;
//		frame.getContentPane().add(table_1, gbc_table_1);
		        

        // Crea las columnas 
        model.addColumn("Id"); 
        model.addColumn("Cod_inmueble"); 
        model.addColumn("Estado");
        model.addColumn("Localidad");
        model.addColumn("Provincia");
        model.addColumn("Barrio");
        model.addColumn("Tipo");
        model.addColumn("Cant. dormitorios");
        model.addColumn("Precio");
        
        
        
        // Agrega las filas 
        T_inmueble aT = new T_inmueble();
        ArrayList<String> data_rs = new ArrayList<String>();
        data_rs = aT.buscarS();
        Object[] fila= {"","","","","","","","",""};
        int i=0;
        int j=0;
        while(j<data_rs.size()) {
        	for(String elem : data_rs) {
        		fila[i]=elem;
        		++i;
        		++j;
        		if(i==9) {
        			model.addRow(fila);
        			i=0;
    			}
        	}
        }
	
 
        table_1.setRowHeight(20);
        table_1.setRowSelectionAllowed(true);
        table_1.setColumnSelectionAllowed(false);
		
        // Tamaño de la ventana
        table_1.setPreferredScrollableViewportSize(new Dimension(800, 300));
        table_1.setFillsViewportHeight(true);

    
 
        //Se crea un ScrollPane como contenedor de la Tabla
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.addMouseListener(new MouseAdapter() {
        	public void mouseWheelMoved(MouseEvent e) {
//                System.out.println(e);
            }
        });
        
        
        
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.LIGHT_GRAY);
        GridBagConstraints gbc_separator = new GridBagConstraints();
        gbc_separator.fill = GridBagConstraints.HORIZONTAL;
        gbc_separator.gridwidth = 2;
        gbc_separator.insets = new Insets(5, 5, 5, 0);
        gbc_separator.gridx = 0;
        gbc_separator.gridy = 16;
        frame.getContentPane().add(separator, gbc_separator);
        
        //Se agrega el scroll pane al JPanel
        gbc_table_1.gridx = 0;		//posición
		gbc_table_1.gridy = 17;
        frame.getContentPane().add(scrollPane,gbc_table_1);
        
        
        JButton btnNewButton_1 = new JButton("Limpiar filtros");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 14;
        frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
        
        btnNewButton_1.addActionListener(e -> {
        	comboProv.setSelectedItem(null);
        	comboLoc.setSelectedItem(null);
        	comboBar.setSelectedItem(null);
        	comboTip.setSelectedItem(null);
        	comboDor.setSelectedItem(null);
        	comboPre.setSelectedItem(null);
        });
        
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 14;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton.addActionListener(e -> {
		
			//limpia la tabla
			int r=0;
			int s=model.getRowCount();
			while(r<s) {
//				System.out.println(r);
				model.removeRow(0);
				++r;}
			
			// Agrega las filas 
	        T_inmueble Tfil = new T_inmueble();
	        ArrayList<String> filtro_rs = new ArrayList<String>();
	       
	        Object pv = comboProv.getSelectedItem();
	        Object lc = comboLoc.getSelectedItem();
	        Object br = comboBar.getSelectedItem();
	        Object tp = comboTip.getSelectedItem();
	        Object dr = comboDor.getSelectedItem();
	        Object pr = comboPre.getSelectedItem();
	        
	        		
//	        System.out.println(pv);		
	        filtro_rs = aT.buscarFiltro((String) pv, (String) lc, (String) br, (String) tp, (String) dr, (String) pr);
	        
	        Object[] fila2= {"","","","","","","","","" };
	        int i2=0;
	        int j2=0;
	        while(j2<filtro_rs.size()) {
	        	for(String elem : filtro_rs) {
	        		fila2[i2]=elem;
	        		++i2;
	        		++j2;
	        		if(i2==9) {
	        			model.addRow(fila2);
	        			i2=0;
	    			}
	        	}
	        }
		});
		
		
	}

}
