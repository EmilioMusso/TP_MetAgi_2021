package xp.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import xp.db.T_propietario;
import xp.model.Propietario;




public class SeleccionarPropietario_Panel extends JPanel {
	
	private boolean ALLOW_ROW_SELECTION = true;
	private boolean ALLOW_COLUMN_SELECTION = false;
	private JLabel tit;
	private GridBagConstraints gbc;
	private JButton seleccionar;
	
	private Object id;
	private String nombre;
	private String apellido;
	private String tipdoc;
	private String numdoc;
	private String calle;
	private String numdom;
	private String provincia;
	private String localidad;
	private String telefono;
	private String email;
	
	private Propietario propietarioSelected;
	
	
	public SeleccionarPropietario_Panel(JFrame tmpFrame, AltaInmueble_panel panelPrev) {
        		
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;		//posición
		gbc.gridy = 0;
		//gbc.weighty = 0.1;
		gbc.gridwidth=3;
		gbc.insets= new Insets(5,5,5,5);
		this.tit = new JLabel("Seleccionar Propietario");
		this.add(tit,gbc);
		tit.setForeground(Color.BLUE);
		tit.setFont(tit.getFont().deriveFont(22.0f));
		
		gbc.gridx = 0;		//posición
		gbc.gridy = 3;
		gbc.weighty = 0.1;
		
		DefaultTableModel model = new DefaultTableModel(); 
        JTable table = new JTable(model); 
        this.add(table,gbc);

        // Crea las columnas 
        model.addColumn("Id"); 
        model.addColumn("Nombre"); 
        model.addColumn("Apellido");
        model.addColumn("Tipo Doc");
        model.addColumn("Num Doc");
        model.addColumn("Calle");
        model.addColumn("Nro");
        model.addColumn("Provincia");
        model.addColumn("Localidad");
        model.addColumn("Teléfono");
        model.addColumn("e-mail");
        
        
        
        // Agrega las filas 
        T_propietario aT = new T_propietario();
        ArrayList<String> data_rs = new ArrayList<String>();
        data_rs = aT.buscar();
        Object[] fila= {"","","","","","","","","","",""};
        int i=0;
        int j=0;
        while(j<data_rs.size()) {
        	for(String elem : data_rs) {
        		fila[i]=elem;
        		++i;
        		++j;
        		if(i==11) {
        			model.addRow(fila);
        			i=0;
    			}
        	}
        }
	
        table.setRowHeight(20);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        
        // Modo de seleccion
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // ListSelectionModel.MULTIPLE_INTERVAL_SELECTION

        // Tamaño de la ventana
        table.setPreferredScrollableViewportSize(new Dimension(800, 100));
        table.setFillsViewportHeight(true);
 
        propietarioSelected = null;
        
        //captura valor seleccionado
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	JTable table = (JTable)e.getSource();
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                
                id = table.getValueAt(row, 0);
            	            	
//            	System.out.println("Valor de celda: " + table.getValueAt(row, column));
//            	System.out.println("Id: " + table.getValueAt(row, 0));
            }
        });
    
 
        //Se crea un ScrollPane como contenedor de la Tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.addMouseListener(new MouseAdapter( ) {
        	public void mouseWheelMoved(MouseEvent e) {
                System.out.println(e);
            }
        });
        
        //Se agrega el scroll pane al JPanel
        gbc.gridx = 0;		//posición
		gbc.gridy = 3;
        add(scrollPane,gbc);
        
      //Botones
    	gbc.gridx = 0;		//posición
    	gbc.gridy = 6;
    	gbc.gridwidth=1;
    	gbc.anchor = GridBagConstraints.EAST;
    	this.seleccionar = new JButton("Seleccionar");
    	this.add(seleccionar,gbc);
    	
    	seleccionar.addActionListener(e -> {
//            System.out.println(T_propietario.buscarPorId(Integer.parseInt((String) id)).nombreToString());
//            System.out.println(propietarioSelected);	
            if(id!=null) {
            	propietarioSelected = T_propietario.buscarPorId(Integer.parseInt((String) id));
            	panelPrev.cambiarNombrePropietario(propietarioSelected);
                tmpFrame.dispose();
            }
		});

    }
	
	
	public String getSelected() {
		return propietarioSelected.nombreToString();
	}	
 
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Valor: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
