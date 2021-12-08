package xp.ui;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import xp.model.Inmueble;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class InmueblePanel extends JPanel {

	public InmueblePanel(ImageIcon img, Inmueble inmueble) {
		setMinimumSize(new Dimension(322, 200));
		setMaximumSize(new Dimension(322, 200));
		setPreferredSize(new Dimension(322, 200));
		setLayout(new BorderLayout(10, 20));
		JLabel lblDescripcion = new JLabel("Descripcion...");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setText(inmueble.getDescripcion());
		add(lblDescripcion, BorderLayout.NORTH);
		
		JLabel lbl = new JLabel("");
		lbl.setIcon(img);
		add(lbl, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, BorderLayout.EAST);
		
		JLabel lblNewLabel_1 = new JLabel("");
		add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JTextPane txtpnDetalles = new JTextPane();
		txtpnDetalles.setText(inmueble.getDetalles());
		txtpnDetalles.setEditable(false);
		add(txtpnDetalles, BorderLayout.CENTER);
		
	}

	

}
