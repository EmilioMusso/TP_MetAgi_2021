package xp.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import xp.db.T_propietario;
import xp.db.T_vendedor;
import xp.utils.ButtonEditor;
import xp.utils.ButtonRenderer;

public class Cons_Vendedor extends JPanel {
	
	private boolean ALLOW_ROW_SELECTION = true;
	private boolean ALLOW_COLUMN_SELECTION = false;
	private JLabel tit;
	private GridBagConstraints gbc;
	private JButton modificar;
	private JButton eliminar;
	private ArrayList<JButton> botones;
	
	private Object idSelected;
	private String nombreSelected;
	private String apellidoSelected;
	private String numdocSelected;
	private String calleSelected;
	private String numdomSelected;
	private String provinciaSelected;
	private String localidadSelected;
	private String telefonoSelected;
	private String emailSelected;
	
	
	public Cons_Vendedor(JFrame ventana, GridBagConstraints gbcf) {
	
        		
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		gbc.gridx = 0;		//posiciï¿½n
		gbc.gridy = 0;
		//gbc.weighty = 0.1;
		gbc.gridwidth=3;
		gbc.insets= new Insets(5,5,5,5);
		this.tit = new JLabel("Vendedores");
		this.add(tit,gbc);
		tit.setForeground(Color.BLUE);
		tit.setFont(tit.getFont().deriveFont(22.0f));
		
		gbc.gridx = 0;		//posiciï¿½n
		gbc.gridy = 3;
		gbc.weighty = 0.1;
		
		String[] columnNames = {"Id", "Nombre", "Apellido", "Num Doc", "Opcion"};
		Object[][] data;
		T_vendedor vT = new T_vendedor();
        ArrayList<String> data_rs = vT.buscar();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Num Doc");
		model.addColumn("Opcion");
        Object[] fila= {"","","","","", ""};
        int i=0;
        int j=0;
        while(j<data_rs.size()) {
        	for(String elem : data_rs) {
				fila[i]=elem;
        		++i;
        		++j;
				if(i==4) {
//					fila[i]="MODIFICAR";
        			model.addRow(fila);
        			i=0;
				}
        	}
        }
 
		JTable table = new JTable(model);
		this.add(table,gbc);
//        table.getColumn("Opcion").setCellRenderer(new ButtonRenderer());
//        table.getColumn("Opcion").setCellEditor(new ButtonEditor(new JCheckBox()));
	
        table.setRowHeight(20);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        
        // Modo de seleccion
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // ListSelectionModel.MULTIPLE_INTERVAL_SELECTION

        // Tamaï¿½o de la ventana
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
                
                idSelected = table.getValueAt(row, 0);
            	nombreSelected =  table.getValueAt(row, 1).toString();
            	apellidoSelected =  table.getValueAt(row, 2).toString();
            	numdocSelected =  table.getValueAt(row, 3).toString();
            	
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
//                System.out.println(e);
            }
        });
        
        //Se agrega el scroll pane al JPanel
        gbc.gridx = 0;		//posiciï¿½n
		gbc.gridy = 3;
        add(scrollPane,gbc);
        
      //Botones
    	gbc.gridx = 0;		//posiciï¿½n
    	gbc.gridy = 6;
    	gbc.gridwidth=1;
    	gbc.anchor = GridBagConstraints.EAST;

    	
    	gbc.gridx = 1;		//posiciï¿½n
    	gbc.gridy = 6;
    	gbc.gridwidth=1;
    	gbc.anchor = GridBagConstraints.CENTER;
    	this.eliminar = new JButton("Eliminar");
    	this.add(eliminar,gbc);
    	
        //Botones
      	gbc.gridx = 0;		//posición
      	gbc.gridy = 6;
      	gbc.gridwidth=1;
      	gbc.anchor = GridBagConstraints.EAST;
      	this.modificar = new JButton("Modificar");
      	this.add(modificar,gbc);

   	 	modificar.addActionListener(e -> {
   	 		//TODO agregar excepcion si no se selecciona ninguno
   	 		T_vendedor tVendedor = new T_vendedor();
   	 		ModifVendedor_ventana modif = new ModifVendedor_ventana(tVendedor.buscarVendedor(idSelected));
		 	modif.setVisible(true);
	    	gbcf.gridx = 0;
	 		gbcf.gridy = 0;
	 		ventana.setContentPane(new Cons_Vendedor(ventana, gbcf));
	    	gbcf.gridx = 3; 
	 		gbcf.gridy = 10;
	 		gbcf.insets= new Insets(5,5,5,5);
	 		JButton salir = new JButton("Salir");
			//	 		gbcf.anchor = GridBagConstraints.EAST;
	 		ventana.add(salir,gbcf);
	    	ventana.pack();
//			modificar.setEnabled(false);
		 });
    	
    	eliminar.addActionListener(e -> {
   	 		//TODO agregar excepcion si no se selecciona ninguno
			T_vendedor mT = new T_vendedor();
			mT.delete(idSelected);
			// eliminar.setEnabled(false);
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
