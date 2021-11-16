package xp;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import xp.ui.Cons_Propietario;
import xp.ui.Cons_Vendedor;
import xp.ui.ModifProp_panel;
import xp.ui.AltaInmueble_panel;
import xp.ui.AltaVendedor_panel;
import xp.ui.Cons_Inmueble;
import xp.ui.PanelPropietario;
import xp.ui.VentanaExito;
import xp.ui.VentanaFallo;

public class Main {
	
	public static void main(String[] args) {
		
		//FRAME
		JFrame ventana = new JFrame("Sistema de compra y venta de INMUEBLES");
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
//		AppSistema appSistema = new AppSistema();
		
		//ventana.setTitle ("");
		//ventana.setSize (800,400);
//		JLabel background= new JLabel();
//		background.setIcon(new ImageIcon("C:\\01.jpg"));
//        ventana.add(background);
		
		JButton salir = new JButton("Salir");
		JButton agregar = new JButton("Agregar"); //Usado para inmueble
		
		GridBagConstraints gbcf = new GridBagConstraints();
		ventana.setLayout(new GridBagLayout());
		
		
		AppSistema appSistema = new AppSistema(); 
		
		//MENU
         JMenuBar mb = new JMenuBar();
		 ventana.setJMenuBar(mb);
		 
		 JMenu menu1;
		 JMenuItem mi1,mi2,mi3;
		 
//			--------------------------------------------------------Vendedor
	     menu1=new JMenu("Vendedor");
	     mb.add(menu1);
	    
	     mi1=new JMenuItem("Agregar");
	     mi1.addActionListener (e -> {
	    	 gbcf.gridx = 0;
	 		 gbcf.gridy = 0;
	    	 ventana.setContentPane(new AltaVendedor_panel(gbcf, ventana));
	    	 gbcf.gridx = 3;
	 		 gbcf.gridy = 7;
	 		 gbcf.insets= new Insets(5,5,5,5);
	 		 ventana.add(salir,gbcf); 
	    	 ventana.pack();
	    	 });
	     menu1.add(mi1);
	     
	     mi2=new JMenuItem("Consultar");  
	     mi2.addActionListener (e -> {
	    	 gbcf.gridx = 0;
	 		 gbcf.gridy = 0;
	 		 ventana.setContentPane(new Cons_Vendedor(ventana, gbcf));
	    	 gbcf.gridx = 3; 
	 		 gbcf.gridy = 10;
	 		 gbcf.insets= new Insets(5,5,5,5);
//	 		 gbcf.anchor = GridBagConstraints.EAST;
	 		 ventana.add(salir,gbcf);
	    	 ventana.pack();
	    	 });
    	 menu1.add(mi2);
	     
    	 mi3=new JMenuItem("...");
	     //   mi3.addActionListener(this);
	     menu1.add(mi3);
			     
	     
//			--------------------------------------------------------Propietario
	     JMenu menu2;
		 JMenuItem mi12,mi22,mi32;
		 menu2=new JMenu("Propietario");
	     mb.add(menu2);
	     
	     mi12=new JMenuItem("Agregar");
	     mi12.addActionListener (e -> {
	    	 ventana.setContentPane(new PanelPropietario().armarPanel());	
	    	 gbcf.gridx = 3;
	 		 gbcf.gridy = 12;
	 		 gbcf.insets= new Insets(5,5,5,5);
	 		 ventana.add(salir,gbcf); 
	    	 ventana.pack();
	    	 });
	     menu2.add(mi12);
	     
	     mi22=new JMenuItem("Consultar");
	     mi22.addActionListener (e -> {
	    	 ventana.setContentPane(new Cons_Propietario());
	    	 ventana.pack();
	    	 });
	     menu2.add(mi22);
	    	     
	     mi32=new JMenuItem("...");
	     //   mi3.addActionListener(this);
	     menu2.add(mi3); 
	     
	     
//			--------------------------------------------------------Cliente
	     JMenu menu3;
		 JMenuItem mi13,mi23,mi33;
		 menu3=new JMenu("Cliente");
	     mb.add(menu3);	     
	     
	     mi13=new JMenuItem("Agregar");
//	     mi13.addActionListener (e -> {
//	    	 ventana.setContentPane(new ATrayecto().armarPanel());	
//	    	 gbcf.gridx = 3;
//	 		 gbcf.gridy = 8;
//	 		 gbcf.insets= new Insets(20,5,20,20);
//	 		 gbcf.anchor = GridBagConstraints.EAST;
//	 		 ventana.add(salir,gbcf); 
//	    	 ventana.pack();
//	    	 });
//	     menu3.add(mi13);
	     
	     
//			--------------------------------------------------------Inmueble
	     JMenu menu4;
		 JMenuItem mi14,mi24,mi34;
		 menu4=new JMenu("Inmueble");
	     mb.add(menu4);
	     
	     mi14=new JMenuItem("Agregar");
	     mi14.addActionListener (e -> {
	    	 ventana.setContentPane(new AltaInmueble_panel(appSistema,agregar));
	 		 gbcf.gridx = 3;
	 		 gbcf.gridy = 9;
	 		 ventana.add(agregar, gbcf);
	    	 gbcf.gridx = 4;
	 		 gbcf.gridy = 9;
	 		 gbcf.insets= new Insets(5,5,5,5);
	 		 ventana.add(salir,gbcf);
//	 		 agregar.addActionListener(a -> {
//	 			 AltaInmueble_panel.agregarPressed(agregar);
//	 		 });
	    	 ventana.pack();
	    	 });
	     menu4.add(mi14);
	     
	     mi14=new JMenuItem("Consultar Inmuebles");
	     mi14.addActionListener (e -> {
	    	 ventana.setContentPane(new Cons_Inmueble());	
	    	 gbcf.gridx = 3;
	 		 gbcf.gridy = 9;
//	 		 gbcf.insets= new Insets(20,5,20,20);
//	 		 gbcf.anchor = GridBagConstraints.EAST;
//	 		 ventana.add(salir,gbcf); 
	    	 ventana.pack();
	    	 });
	     menu4.add(mi14);
		
	     
	    //PANEL
	   
	    gbcf.gridx = 0;
		gbcf.gridy = 0;
	    ventana.setContentPane(new Ini()); 
	    	//ventana.setSize (700,450);
	     	//ventana.setContentPane(new AEstacion().armarPanel());
		ventana.pack();
		ventana.setVisible(true); 
	     
	   
		
		salir.addActionListener(e -> {
			gbcf.gridx = 0;
			gbcf.gridy = 0;
			ventana.setContentPane(new Ini());
			ventana.pack();
			ventana.setVisible(true);
		});
				
}}



	

