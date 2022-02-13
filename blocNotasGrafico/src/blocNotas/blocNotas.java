package blocNotas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class blocNotas {

	private JFrame notarx;
	private JTextField nombreNota;
	private JLabel consolelog = new JLabel("");
	private JButton boton = new JButton("Crear nota");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					blocNotas window = new blocNotas();
					window.notarx.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public blocNotas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		notarx = new JFrame();
		notarx.setResizable(false);
		notarx.setFont(new Font("Arial Black", Font.PLAIN, 12));
		notarx.setTitle("NotarX");
		notarx.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\elrub\\Downloads\\document_write_22637.png"));
		notarx.setBounds(100, 100, 1072, 574);
		notarx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notarx.getContentPane().setLayout(null);
		
		JTextPane texto = new JTextPane();
		texto.setBounds(14, 47, 1028, 426);
		notarx.getContentPane().add(texto);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 42, 1036, 436);
		notarx.getContentPane().add(panel);
		
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				PrintWriter pw = null;
				File carpeta = new File("C:/Users/elrub/OneDrive/Escritorio/NotarX");
				
				if(!carpeta.exists()) {
					carpeta.mkdir();
				}
				
				String nombreFichero = nombreNota.getText();
				String textoNota = texto.getText();
				
				File archivo = new File("C:/Users/elrub/OneDrive/Escritorio/NotarX/" + nombreFichero + ".txt");
				
				if(!archivo.exists()) {
					try {
						fw = new FileWriter("C:/Users/elrub/OneDrive/Escritorio/NotarX/" + nombreFichero + ".txt");
					} catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}

					pw = new PrintWriter(fw);
					pw.println(textoNota);

					try {
						fw.close();
					} catch (IOException e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					
					nombreNota.setText("");
					texto.setText("");
					consolelog.setText("Documento creado");
				}
				
				else {
					consolelog.setText("Error: La nota ya estaba creada.");
					
					nombreNota.setText("");
					texto.setText("");
				}	
			}
		});

		boton.setBounds(472, 501, 114, 23);
		notarx.getContentPane().add(boton);
		
		nombreNota = new JTextField();
		nombreNota.setBounds(727, 11, 315, 20);
		notarx.getContentPane().add(nombreNota);
		nombreNota.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de la nota:");
		lblNewLabel.setBounds(603, 14, 114, 14);
		notarx.getContentPane().add(lblNewLabel);
		
		
		consolelog.setBounds(726, 510, 295, 14);
		notarx.getContentPane().add(consolelog);
	}
}
