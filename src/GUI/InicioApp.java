package GUI;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import Models.*;

import javax.swing.JFrame;
import javax.swing.JButton;

public class InicioApp {

	private JFrame frame;
	private JButton btnSubidaViajero;
	private JButton btnCajaDelDia;
	private Cliente cliente;
	private ListaClientes <Cliente> Lista;
	

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
					InicioApp window = new InicioApp();
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
	public InicioApp() {
		initialize();
		setComponentProperties();
		setComponentAdapters();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Pantalla de Inicio");
		
		btnSubidaViajero = new JButton("Subida Viajero");
		btnCajaDelDia = new JButton("Caja del Dia");
		
		
	}
	
	private void setComponentProperties(){
		btnSubidaViajero.setBounds(6, 80, 203, 113);
		frame.getContentPane().add(btnSubidaViajero);
		
		btnCajaDelDia.setBounds(228, 80, 203, 113);
		frame.getContentPane().add(btnCajaDelDia);
	}
	
	private void setComponentAdapters(){
		btnSubidaViajero.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				SubidaViajero Pantalla = new SubidaViajero();
				Pantalla.getFrame().setVisible(true);
				Pantalla.iniciarCronometro();
				cliente.setFechaEntrada(new Date());
				Lista.add(cliente);
				frame.dispose();
				
			}
		});
		
		btnCajaDelDia.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				CajaDia Pantalla = new CajaDia();
				Pantalla.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}
	
	
}
