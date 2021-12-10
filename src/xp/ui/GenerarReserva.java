/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package xp.ui;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import xp.db.T_cliente;
import xp.db.T_inmueble;
import xp.model.Reserva;

/**
 *
 * @author Lucia
 */



public class GenerarReserva extends javax.swing.JFrame {

	
    private Object codigoI;
    public static final String LOGO="C:\\Users\\Lucia\\git\\TP_MetAgi_2021\\logo.jpeg";
    
    
    public static void crearPDF(Reserva reserva) throws DocumentException, IOException, Exception {
		Document documento = new Document();
		
		//que la salida llame asi al archivo que genera
		FileOutputStream fichero = new FileOutputStream("comprobante.pdf");
		PdfWriter.getInstance(documento, fichero);
		//empieza a escribir el documento
		documento.open();
		//le pone de cabecera la imagen definida en lo general
		Image img = Image.getInstance(LOGO);
		img.setAlignment(img.ALIGN_CENTER); //la alinea en el centro
		 documento.add(img);//la agrega
		
		//creo un nuevo parrafo para el titulo 
		Paragraph titulo = new Paragraph("Comprobante de reserva \n \n ",
				FontFactory.getFont("arial",22, // le seteo el tipo de letra y el tama�o
				Font.BOLD));
		titulo.setAlignment(titulo.ALIGN_CENTER); //tambien la alineo en el cnetro
		documento.add(titulo); // se lo agrego al doc
		documento.add(new Paragraph("Id inmueble: " + reserva.getIdI()));
    	documento.add(new Paragraph("Barrio: " + reserva.getCalleI()));
    	documento.add(new Paragraph("Localidad: " + reserva.getLocalidadI()));
    	documento.add(new Paragraph("Cliente numero: " + reserva.getIdCliente()));
    	documento.add(new Paragraph("Precio de reserva: " + reserva.getPrecio()));
    	
    	Paragraph fecha = new Paragraph("\n \n \n \n \n Recuerde que pasados los 15 d�as a partir de la fecha de reserva "
    	+ reserva.getFecha()+ ", la misma vencer� " );
    	documento.add(fecha);
    	fecha.setAlignment(Element.ALIGN_RIGHT);
		
		
		documento.close();
				
	}
    
	/**
     * Creates new form GenerarReserva
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
     */
	
    //la clase generar reserva, recibe los atributos del inmueble al cual se quiere iniciar la reserva
    public GenerarReserva(Object idSelected,String codigo,String localidad,String provincia,String barrio) throws FileNotFoundException, DocumentException {
        initComponents(idSelected,codigo,localidad,provincia,barrio);

    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws DocumentException 
     * @throws FileNotFoundException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(Object idSelected,String codigo,String localidad,String provincia,String barrio) throws FileNotFoundException, DocumentException {

        jPanel1 = new javax.swing.JPanel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jComboBoxInmueble = new javax.swing.JComboBox<>();
        lReserva = new javax.swing.JLabel();
        lInmueble = new javax.swing.JLabel();
        lCliente = new javax.swing.JLabel();
        lprecio = new javax.swing.JLabel();
        etPrecio = new javax.swing.JTextField();
       
        
        
        btnPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

  
        //crea una instancia de bd cliente para traerme los ids	
        //y colocarlos en el combobox del genera reserva
        T_cliente Ti3 = new T_cliente();
		ArrayList<String> i3_rs = new ArrayList<String>();
	    i3_rs= Ti3.buscar_c();
	    for (String nom: i3_rs) {
	    	jComboBoxCliente.addItem(nom);}
	    jComboBoxCliente.setSelectedItem(null);
    
	    
        T_inmueble Ti2 = new T_inmueble();
		ArrayList<String> i2_rs = new ArrayList<String>();
	    i2_rs= Ti2.buscar_codigo();
	    for (String nom: i2_rs) {
	    	jComboBoxInmueble.addItem(nom);
	    	}
	    //setea de entrada el codigo que recibe desde que
	    //se seleciono el inmueble a reservar
	    jComboBoxInmueble.setSelectedItem(codigo);
        
        lReserva.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        lReserva.setForeground(new java.awt.Color(0, 0, 255));
        lReserva.setText("Reserva Inmueble");
        lReserva.setToolTipText("");

        lInmueble.setText("Codigo Inmueble");

        lCliente.setText("Cliente");
        
        
        
        
        lprecio.setText("Ingrese Importe");
        etPrecio.setText("$.................");
        
        btnPdf.setText("Generar Comprobante");
        
        
        
        //al presionar el boton generar comprobante
        btnPdf.addActionListener(e -> { 
        	String precioR;
            String cliente;
            
            //guarda el valor que se selecciono en el combobox
        	cliente=(String)jComboBoxCliente.getSelectedItem(); 
        	//guarda lo que se ingreso como monton
            precioR=etPrecio.getText(); 
            
            //crea una instancia de la clase reserva y
            //le setea los valores ingresados/selecionados
            Reserva reserva = new Reserva();
            reserva.setIdCliente(cliente);
            reserva.setCalleI(barrio);
            reserva.setIdI((String) idSelected);
            reserva.setLocalidadI(localidad);
            reserva.setPrecio(precioR);
            reserva.setFecha(LocalDate.now());
            //se cierrar la ventana de generar reserva
            this.dispose();
          
            
        	try {
        		//se llama al metodo
				crearPDF(reserva); 
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	//luego de generar el pdf se cambia el estado
        	//del inmueble
        	T_inmueble tinmueble = new T_inmueble();
			tinmueble.update(idSelected);
        	
        });
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lprecio)
                    .addComponent(lInmueble)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxInmueble, 0, 293, Short.MAX_VALUE)
                        .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lReserva)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPdf)
                        .addGap(156, 156, 156))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lReserva)
                .addGap(28, 28, 28)
                .addComponent(lInmueble)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lprecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPdf)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new GenerarReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private javax.swing.JComboBox<String> jComboBoxInmueble;
    private javax.swing.JTextField etPrecio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lCliente;
    private javax.swing.JLabel lInmueble;
    private javax.swing.JLabel lReserva;
    private javax.swing.JLabel lprecio;
    // End of variables declaration//GEN-END:variables
}
