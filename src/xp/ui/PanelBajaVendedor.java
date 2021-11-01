package xp.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.BitSet;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import xp.model.Vendedor;
import xp.utils.*;

import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JTable;

public class PanelBajaVendedor extends JPanel {
	
	private FieldValidators fv;
	private JTable tableVendedores;

	/**
	 * Create the panel.
	 */
	public PanelBajaVendedor(JFrame frame) {
		super();
		frame.setContentPane(this);
		this.setBounds(0, 0, 784, 561);
		setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 764, 539);
		add(desktopPane);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(664, 500, 90, 28);
		desktopPane.add(btnCancelar);
		btnCancelar.addActionListener(a -> {

		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(564, 500, 90, 28);
		desktopPane.add(btnBorrar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(464, 500, 90, 28);
		desktopPane.add(btnModificar);
		btnModificar.addActionListener(a -> {
			//appSistema.modificacionVendedor(v1);
		});
		
		tableVendedores = new JTable();
		tableVendedores.setBounds(10, 11, 744, 380);
		desktopPane.add(tableVendedores);
		btnBorrar.addActionListener(a -> {
			
		});		
	}
}
