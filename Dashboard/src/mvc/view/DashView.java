package mvc.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;


public class DashView extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel lblUberschrift = new JLabel("Grunerstrasse 2");
	private JLabel lblUberschriftIstTemperatur = new JLabel("Aussen:");
	private JLabel lblAussenTemperatur = new JLabel("");
	private JLabel lblUberschriftSollTemperatur = new JLabel("Temperaturen:");




	
    public DashView(){
        initialize();
    }
    
	private void initialize() {


		this.setBounds(0, 0, 800, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.getContentPane().setLayout(null);
		getContentPane().add(lblAussenTemperatur);
		getContentPane().add(lblUberschriftIstTemperatur);
		getContentPane().add(lblUberschriftSollTemperatur);
		
		lblUberschrift.setBounds(308, 6, 130, 16);
		this.getContentPane().add(lblUberschrift);
		
		lblUberschriftIstTemperatur.setBounds(41, 86, 130, 16);
		this.getContentPane().add(lblUberschriftIstTemperatur);
		
		lblUberschriftSollTemperatur.setBounds(41, 58, 130, 16);
		this.getContentPane().add(lblUberschriftSollTemperatur);
	
		lblAussenTemperatur.setBounds(41, 127, 98, 16);
		this.getContentPane().add(lblAussenTemperatur);
		

	}
	
	
	
	/*
	 * Setter Methoden
	 */
	public void setActualTemperaturs(Double[][] Temperatures){
        this.lblAussenTemperatur.setText(Double.toString(Temperatures[0][0]));
    }
	
	
}
