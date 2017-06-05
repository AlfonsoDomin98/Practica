package GUI;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.*;

import Models.Cliente;
import Container.*;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;

public class SubidaViajero implements Runnable {

	private JFrame frame;
	private JButton btnFinDelTrayecto;
	private JLabel tiempo;
	private Thread hilo;
	private boolean cronometroActivo;
	private JLabel lblSuplementos;
	private JRadioButton rdbtnNoche;
	private JRadioButton rdbtnAeropuerto;
	private JButton btnPagar;
	private JLabel lblTotal;
	private JTextField textField_Total;
	private JLabel lblPagado;
	private JTextField textField_Pagado;
	private JButton btnFinalizar;
	private float devuelto;
	private float pagado;
	private float Total;
	private JLabel lblFechaEntrada;
	private JTextField txtFecha;
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
					SubidaViajero window = new SubidaViajero();
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
	public SubidaViajero() {
		initialize();
		setComponentProperties();
		setComponentAdapters();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnFinDelTrayecto = new JButton("Fin del Trayecto");
		tiempo = new JLabel( "00:00:00:000" );
	
		lblPagado = new JLabel("Pagado:");
		

		
		
	}
	
	private void setComponentProperties(){
		btnFinDelTrayecto.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnFinDelTrayecto.setBounds(57, 246, 238, 65);
		frame.getContentPane().add(btnFinDelTrayecto);
		
		tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 50 ) );
	    tiempo.setBounds(57, 48, 307, 65);
	    tiempo.setOpaque( true );
	    frame.getContentPane().add(tiempo);
	    
	    lblSuplementos = new JLabel("Suplementos:");
	    lblSuplementos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	    lblSuplementos.setBounds(57, 125, 118, 29);
	    frame.getContentPane().add(lblSuplementos);
	    lblSuplementos.setEnabled(false);
	    
	    rdbtnAeropuerto = new JRadioButton("Aeropuerto");
	    rdbtnAeropuerto.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	    rdbtnAeropuerto.setBounds(57, 166, 141, 23);
	    frame.getContentPane().add(rdbtnAeropuerto);
	    rdbtnAeropuerto.setEnabled(false);
	    
	    rdbtnNoche = new JRadioButton("Noche");
	    rdbtnNoche.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	    rdbtnNoche.setBounds(57, 201, 141, 23);
	    frame.getContentPane().add(rdbtnNoche);
	    rdbtnNoche.setEnabled(false);
	    
	    btnPagar = new JButton("Pagar");
	    btnPagar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
	    btnPagar.setBounds(57, 323, 238, 65);
	    frame.getContentPane().add(btnPagar);
	    btnPagar.setEnabled(false);
	    
	    lblTotal = new JLabel("Total:");
	    lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	    lblTotal.setBounds(411, 131, 61, 16);
	    frame.getContentPane().add(lblTotal);
	    
	    textField_Total = new JTextField();
	    textField_Total.setBounds(501, 118, 155, 36);
	    frame.getContentPane().add(textField_Total);
	    textField_Total.setColumns(10);
	    textField_Total.setEditable(false);
	   
	    lblPagado.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPagado.setBounds(411, 170, 61, 16);
		frame.getContentPane().add(lblPagado);
		
		
		textField_Pagado = new JTextField();
		textField_Pagado.setBounds(501, 166, 155, 26);
		frame.getContentPane().add(textField_Pagado);
		textField_Pagado.setColumns(10);
	    textField_Pagado.setEditable(false);
		
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		btnFinalizar.setBounds(418, 354, 238, 65);
		frame.getContentPane().add(btnFinalizar);
		
		lblFechaEntrada = new JLabel("Fecha entrada:");
		lblFechaEntrada.setBounds(411, 48, 61, 16);
		frame.getContentPane().add(lblFechaEntrada);
		
		txtFecha = new JTextField();
		txtFecha.setText("Fecha");
		txtFecha.setBounds(501, 43, 130, 26);
		frame.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		txtFecha.setText(cliente.getFechaEntrada().toLocaleString());
	    
	   
	    
	    
	}
	
	private void setComponentAdapters(){
		btnFinDelTrayecto.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
			    lblSuplementos.setEnabled(true);
			    rdbtnAeropuerto.setEnabled(true);
			    rdbtnNoche.setEnabled(true);
			    btnPagar.setEnabled(true);
			    textField_Pagado.setEditable(true);
			    pararCronometro();
				
			}
		});
		
		btnPagar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				devuelto = pagado - Total;
				JOptionPane.showMessageDialog(null, "Devolver: "+devuelto+"Eur");
					
			}
		});	
	        
	}
	
	public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread(this);
        hilo.start();
    }
	
	private void pararCronometro(){
        hilo.stop();
    }

	public void run() {
		Integer minutos = 0 , segundos = 0, milesimas = 0, horas = 0;
		
		float Bajada = 3.65f;
		float Min = 0.18f;


        //min es minutos, seg es segundos y mil es milesimas de segundo
        String min="", seg="", mil="", hor = "";
        try
        {
            //Mientras cronometroActivo sea verdadero entonces seguira
            //aumentando el tiempo
            while( cronometroActivo )
            {
                Thread.sleep( 4 );
                //Incrementamos 4 milesimas de segundo
                milesimas += 4;
                 
                //Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
                //y las milesimas de segundo de nuevo a 0
                if( milesimas == 1000 )
                {
                    milesimas = 0;
                    segundos += 1;
                    //Si los segundos llegan a 60 entonces aumenta 1 los minutos
                    //y los segundos vuelven a 0
                    if( segundos == 60 )
                    {
                        segundos = 0;
                        minutos++;
                        if( minutos ==60){
                        	minutos = 0;
                        	horas++;
                        }
                    }
                    
                }
 
                //Esto solamente es estetica para que siempre este en formato
                //00:00:000
                if( horas < 10 ) hor = "0" + horas;
                else hor = horas.toString();
                if( minutos < 10 ) min = "0" + minutos;
                else min = minutos.toString();
                if( segundos < 10 ) seg = "0" + segundos;
                else seg = segundos.toString();
                 
                if( milesimas < 10 ) mil = "00" + milesimas;
                else if( milesimas < 100 ) mil = "0" + milesimas;
                else mil = milesimas.toString();
               
                //Colocamos en la etiqueta la informacion
                tiempo.setText(hor + ":"+ min + ":" + seg + ":" + mil );    
                Total = Bajada +( Min * (minutos + (horas * 60)));
                textField_Total.setText(Float.toString(Total)+"Eur");
                
                
            }
        }catch(Exception e){}
        //Cuando se reincie se coloca nuevamente en 00:00:000
        tiempo.setText( "00:00:00:000" );   
        pagado = Float.valueOf(textField_Pagado.getText());

            }
}
