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




public class Cons_Propietario extends JPanel {
	
	private boolean ALLOW_ROW_SELECTION = true;
	private boolean ALLOW_COLUMN_SELECTION = false;
	private JLabel tit;
	private GridBagConstraints gbc;
	private JButton modificar;
	private JButton eliminar;
	
	private Object id;
	private String nombre;
	private String apellido;
	private String numdoc;
	private String calle;
	private String numdom;
	private String provincia;
	private String localidad;
	private String telefono;
	private String email;
	
	
	public Cons_Propietario() {
        		
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;		//posición
		gbc.gridy = 0;
		//gbc.weighty = 0.1;
		gbc.gridwidth=3;
		gbc.insets= new Insets(5,5,5,5);
		this.tit = new JLabel("Propietarios");
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
        data_rs= aT.buscar();
        Object[] fila= {"","","","","","","","","",""};
        int i=0;
        int j=0;
        while(j<data_rs.size()) {
        	for(String elem : data_rs) {
        		fila[i]=elem;
        		++i;
        		++j;
        		if(i==10) {
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
 
        //captura valor seleccionado
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	// Tomamos la fuente del evento
            	JTable table = (JTable)e.getSource();
            	// Desde la tabla podemos optener la fila / columna, usando un punto (x,y) dentro de la ventana
            	// En este caso usamos el punto del evento
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                
                id = table.getValueAt(row, 0);
            	nombre =  table.getValueAt(row, 1).toString();
            	apellido =  table.getValueAt(row, 2).toString();
            	numdoc =  table.getValueAt(row, 3).toString();
            	calle =  table.getValueAt(row, 4).toString();
            	numdom =  table.getValueAt(row, 5).toString();
            	provincia =  table.getValueAt(row, 6).toString();
            	localidad =  table.getValueAt(row, 7).toString();
            	telefono =  table.getValueAt(row, 8).toString();
            	email =  table.getValueAt(row, 9).toString();
            	
            	
                                
                // Con la fila/columna tomamos el valor de la celda
//            	System.out.println("Valor de celda: " + table.getValueAt(row, column));
//            	System.out.println("Id: " + table.getValueAt(row, 0));
            }
            // mousePressed
            // mouseDragged
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
    	this.modificar = new JButton("Modificar");
    	this.add(modificar,gbc);
    	
    	modificar.addActionListener(e -> {
			
    		ModifProp_ventana modif = new ModifProp_ventana(id, nombre, apellido, numdoc, calle, numdom, provincia, localidad, telefono, email);
    		modif.setVisible(true);
//			T_estacion mT = new T_estacion();
//			mT.delete(id);
//			mT.insert(nombre, apertura, cierre, estado);
			
//			tit.setText("Estación agregada!");
//			tit.setForeground(Color.RED);
			modificar.setEnabled(false);
		});
    	
    	gbc.gridx = 1;		//posición
    	gbc.gridy = 6;
    	gbc.gridwidth=1;
    	gbc.anchor = GridBagConstraints.CENTER;
    	this.eliminar = new JButton("Eliminar");
    	this.add(eliminar,gbc);
    	
    	eliminar.addActionListener(e -> {
			
			T_propietario mT = new T_propietario();
			mT.delete(id);
			
			eliminar.setEnabled(false);
		});
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
