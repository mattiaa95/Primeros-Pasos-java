package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaEvento {

	public static void main(String[] args) {
		MarcoBotones miMarco = new MarcoBotones();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3484671942909355623L;

	public MarcoBotones() {
		setTitle("Botones y Eventos");
		setBounds(700,300,500,300);
		LaminaBotones miLamina=new LaminaBotones();
		add(miLamina);
	}
}

class LaminaBotones extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8882976466473546562L;
	JButton botonBlanco = new JButton("Cambia Color blanco");
	JButton botonAzul = new JButton("Cambia Color azul");
	JButton botonAmarillo = new JButton("Cambia Color amarillo");
	
	public LaminaBotones() {
		add(botonAzul);
		add(botonBlanco);
		add(botonAmarillo);
		botonBlanco.addActionListener(this);
		botonAzul.addActionListener(this);
		botonAmarillo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if (botonPulsado==botonBlanco) {
			setBackground(Color.white);
		}
		
		if (botonPulsado==botonAzul) {
			setBackground(Color.blue);
		}
		
		if (botonPulsado==botonAmarillo) {
			setBackground(Color.yellow);
		}

	}
}