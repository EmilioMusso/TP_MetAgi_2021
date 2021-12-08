package xp.ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import xp.db.T_inmueble;
import xp.enums.EstadoInmueble;
import xp.enums.TipoInmueble;
import xp.model.Inmueble;

import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

public class CatalogoInmuebles extends JFrame {
	
	private Integer cant_inmuebles;

	public CatalogoInmuebles() {
		this.setIconImage((new ImageIcon("img/HouseImg.png")).getImage());
		setBounds(new Rectangle(10, 10, 0, 0));
		
//		----------------------------------------------------------------------------------obtencion inmuebles		
		T_inmueble ti = new T_inmueble();
		ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
		ArrayList<Inmueble> inmuebles2;
		inmuebles = ti.buscar_todos();
		inmuebles2 = (ArrayList<Inmueble>) inmuebles.stream()
				.filter(inm -> inm.getEstadoInmueble()==EstadoInmueble.DISPONIBLE)
				.collect(Collectors.toList());
		
		cant_inmuebles = inmuebles2.size();
//		System.out.println(inmuebles2+" - "+cant_inmuebles);
//		----------------------------------------------------------------------------------
		
		setBounds(100, 100, 808, 700);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(650, 1000));
		scrollPane.setMaximumSize(new Dimension(650, 1000));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 792, 661);
		getContentPane().add(scrollPane);
		
		JPanel panel2 = new JPanel();
		scrollPane.setViewportView(panel2);
		Integer rows = cant_inmuebles;
		panel2.setLayout(new GridLayout(rows/2+1, 2, 0, 0));
		
		InmueblePanel inmuebleGeneralPanel1;
		for(int i=0; i<cant_inmuebles; i++) {
			Inmueble inmuebleActual = inmuebles2.get(i);
			ImageIcon img=null;
//			ImageIcon img = new ImageIcon("C:\\Users\\Public\\Documents\\TP_MetAgi_2021\\img\\LaptopImg128px.png");
			switch(inmuebleActual.getTipoInmueble()) {
			case L:
				img = new ImageIcon("img/LaptopImg128px.png");
				break;
			case C:
				img = new ImageIcon("img/HouseImg.png");
				break;
			case Q:
				img = new ImageIcon("img/QuintaImg.png");
				break;
			case D:
				img = new ImageIcon("img/DepartamentoImg.png");
				break;
			case G:
				img = new ImageIcon("img/HouseImg.png");
				break;
			case T:
				img = new ImageIcon("img/TerrenoImg.png");
				break;
			default:
			}
			
			inmuebleGeneralPanel1 = new InmueblePanel(img, inmuebleActual);
			inmuebleGeneralPanel1.setBounds(0, 0, 50, 50);

			if(i%8==0) {
				inmuebleGeneralPanel1.setBackground(new Color(204, 204, 255));
			} else if(i%8==1) {
				inmuebleGeneralPanel1.setBackground(new Color(205, 255, 255));
			} else if(i%8==2) {
				inmuebleGeneralPanel1.setBackground(new Color(255, 204, 204));
			} else if(i%8==3) {
				inmuebleGeneralPanel1.setBackground(new Color(255, 255, 204));
			}else if(i%8==4) {
				inmuebleGeneralPanel1.setBackground(new Color(205, 255, 255));
			} else if(i%8==5) {
				inmuebleGeneralPanel1.setBackground(new Color(204, 204, 255));
			} else if(i%8==6) {
				inmuebleGeneralPanel1.setBackground(new Color(255, 255, 204));
			} else if(i%8==7) {
				inmuebleGeneralPanel1.setBackground(new Color(255, 204, 204));
			}
			
			panel2.add(inmuebleGeneralPanel1);
		}
		

		scrollPane.revalidate();
		scrollPane.repaint();
		

		
	}
}
