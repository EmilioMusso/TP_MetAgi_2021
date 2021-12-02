package xp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import xp.AppSistema;
import xp.enums.TipoUsuario;
import xp.exceptions.PasswordIncorrectaException;
import xp.utils.FieldValidators;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class Ventana_login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tusuario;
	private JTextField tcontrasenia;
	
	private JButton okButton;
	private JButton cancelButton;
	
	private FieldValidators fv;

	public Ventana_login(VentanaExito v1, AppSistema appSistema, JMenuItem mi15, JMenuItem mi25, JMenu menu1, JMenu menu2, JMenu menu3, JMenuItem mi14) {
		
		fv = new FieldValidators();
		
		setBounds(100, 100, 250, 270);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblimg = new JLabel("AAAA");
			GridBagConstraints gbc_lblimg = new GridBagConstraints();
			gbc_lblimg.gridwidth = 3;
			gbc_lblimg.insets = new Insets(0, 0, 5, 5);
			gbc_lblimg.gridx = 0;
			gbc_lblimg.gridy = 0;
			contentPanel.add(lblimg, gbc_lblimg);
		}
		{
			JLabel lblUsuario = new JLabel("USUARIO");
			GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
			gbc_lblUsuario.gridwidth = 3;
			gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsuario.gridx = 0;
			gbc_lblUsuario.gridy = 1;
			contentPanel.add(lblUsuario, gbc_lblUsuario);
		}
		{
			tusuario = new JTextField();
			GridBagConstraints gbc_tusuario = new GridBagConstraints();
			gbc_tusuario.insets = new Insets(0, 0, 5, 5);
			gbc_tusuario.fill = GridBagConstraints.HORIZONTAL;
			gbc_tusuario.gridwidth = 3;
			gbc_tusuario.gridx = 0;
			gbc_tusuario.gridy = 2;
			contentPanel.add(tusuario, gbc_tusuario);
			tusuario.setColumns(10);
		}
		{
			JLabel lblContrasenia = new JLabel("CONTRASE\u00D1A");
			GridBagConstraints gbc_lblContrasenia = new GridBagConstraints();
			gbc_lblContrasenia.gridwidth = 3;
			gbc_lblContrasenia.insets = new Insets(0, 0, 5, 5);
			gbc_lblContrasenia.gridx = 0;
			gbc_lblContrasenia.gridy = 3;
			contentPanel.add(lblContrasenia, gbc_lblContrasenia);
		}
		{
			tcontrasenia = new JTextField();
			tcontrasenia.setColumns(10);
			GridBagConstraints gbc_tcontrasenia = new GridBagConstraints();
			gbc_tcontrasenia.gridwidth = 3;
			gbc_tcontrasenia.insets = new Insets(0, 0, 0, 5);
			gbc_tcontrasenia.fill = GridBagConstraints.HORIZONTAL;
			gbc_tcontrasenia.gridx = 0;
			gbc_tcontrasenia.gridy = 4;
			contentPanel.add(tcontrasenia, gbc_tcontrasenia);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("Ingresar");
				buttonPane.add(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				buttonPane.add(cancelButton);
			}
			okButton.addActionListener(ok -> {
				try {
					fv.passwordCorrecta(tcontrasenia.getText(), appSistema.getPassword(tusuario.getText()));
					this.dispose();
					v1.setVisible(true);
					appSistema.setTipoUsuario(TipoUsuario.SUPER_USUARIO);
					mi15.setVisible(false);
					mi25.setVisible(true);
					menu1.setVisible(true);
					menu2.setVisible(true);
					menu3.setVisible(true);
					mi14.setVisible(true);
				} catch (PasswordIncorrectaException e1) {
					VentanaFallo vf = new VentanaFallo(e1.getMessage());
					vf.setVisible(true);
				}
			});
			cancelButton.addActionListener(canc -> {
				this.dispose();
			});
			
		}
	}	
}
