package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import Models.Cliente;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class FinTrayecto {

	private JFrame frame;
	private JTextField textField_tiempo;
	private JTextField textField_total;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnFinalizar;
	private JLabel lblTiempo;
	private JLabel lblTotal;

	private Cliente cliente;

	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinTrayecto window = new FinTrayecto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinTrayecto() {
		initialize();
		setComponentProperties();
		setComponentAdapters();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 421, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTiempo = new JLabel("Tiempo:");
		
		textField_tiempo = new JTextField();
		
		lblTotal = new JLabel("Total:");
		
		textField_total = new JTextField();
		
		
		btnFinalizar = new JButton("Finalizar");
		
	}
	
	
	private void setComponentProperties(){
		lblTiempo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTiempo.setBounds(32, 16, 69, 24);
		frame.getContentPane().add(lblTiempo);
		
		textField_tiempo.setBounds(111, 11, 145, 37);
		frame.getContentPane().add(textField_tiempo);
		textField_tiempo.setColumns(10);
		
		
		textField.setBounds(111, 232, 161, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTotal.setBounds(32, 172, 61, 16);
		frame.getContentPane().add(lblTotal);
		
		
		textField_total.setBounds(111, 163, 161, 37);
		frame.getContentPane().add(textField_total);
		textField_total.setColumns(10);
		textField_total.setText(Float.toString(cliente.getTotal()));
		
		
	}
	
	private void setComponentAdapters(){
		btnFinalizar.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseClicked(MouseEvent e){
				InicioApp Pantalla = new InicioApp();
				Pantalla.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}

}
