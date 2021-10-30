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

public class PanelAltaVendedor extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JPasswordField txtClaveAcceso;
	
	private FieldValidators fv;

	/**
	 * Create the panel.
	 */
	public PanelAltaVendedor(JFrame frame) {
		super();
		frame.setContentPane(this);
		this.setBounds(0, 0, 784, 561);
		setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 764, 539);
		add(desktopPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		desktopPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 36, 86, 20);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(162, 11, 46, 14);
		desktopPane.add(lblApellido);
		
		txtApellido= new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(162, 36, 86, 20);
		desktopPane.add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(10, 112, 86, 20);
		desktopPane.add(txtDni);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 87, 46, 14);
		desktopPane.add(lblDni);
		
		JLabel lblClaveAcceso = new JLabel("Clave");
		lblClaveAcceso.setBounds(10, 163, 46, 14);
		desktopPane.add(lblClaveAcceso);
		
		txtClaveAcceso = new JPasswordField();
		txtClaveAcceso.setBounds(10, 188, 86, 20);
		desktopPane.add(txtClaveAcceso);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(664, 500, 90, 28);
		desktopPane.add(btnCrear);
		btnCrear.addActionListener(a -> {
			if(camposValidos()) {
				Vendedor v1 = new Vendedor(
						txtNombre.getText(),
						txtApellido.getText(),
						txtDni.getText(),
						txtClaveAcceso.getPassword().toString());
				//TODO guardar en app
				VentanaExito exito = new VentanaExito("EL VENDEDOR HA SIDO CREADO CON EXITO.");
				exito.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				exito.setVisible(true);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(564, 500, 90, 28);
		desktopPane.add(btnCancelar);
		btnCancelar.addActionListener(a -> {
			
		});		
	}

	private Boolean camposValidos() {
		BitSet bitSetValidacioneSet = new BitSet(4);
		bitSetValidacioneSet.clear();
		
		bitSetValidacioneSet.set(0, fv.campoAlfabetico(txtNombre.getText()));
		bitSetValidacioneSet.set(1, fv.campoAlfabetico(txtApellido.getText()));
		bitSetValidacioneSet.set(2, fv.campoNumerico(txtDni.getText()));
		bitSetValidacioneSet.set(3, fv.campoPassword(txtClaveAcceso.getText()));
		
		return !bitSetValidacioneSet.isEmpty();
	}
}
