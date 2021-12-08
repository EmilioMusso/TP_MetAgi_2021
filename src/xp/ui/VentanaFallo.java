package xp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.ColorType;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.w3c.dom.css.RGBColor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaFallo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VentanaFallo(String mensaje) {
		this.setIconImage((new ImageIcon("img/HouseImg.png")).getImage());
		setBounds(100, 100, 450, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblError = new JLabel("ERROR");
			lblError.setHorizontalAlignment(SwingConstants.CENTER);
			lblError.setBounds(10, 0, 414, 25);
			lblError.setFont(lblError.getFont().deriveFont(lblError.getFont().getSize() + 9f));
			lblError.setForeground(Color.red);
			contentPanel.add(lblError);
		}
		{
			JLabel lblMensaje = new JLabel(mensaje);
			lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
			lblMensaje.setBounds(10, 24, 414, 45);
			contentPanel.add(lblMensaje);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(a -> {
					dispose();
				});
			}
		}
	}

}
