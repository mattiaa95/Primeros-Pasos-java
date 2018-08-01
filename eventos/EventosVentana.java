package eventos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class EventosVentana {

	public static void main(String[] args) {
		MarcoVentana miMarco = new MarcoVentana();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoVentana extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3656755845762380803L;

	public MarcoVentana() {
		setTitle("Botones y Eventos");
		setBounds(700,300,500,300);
		M_Ventana listener_Ventana = new M_Ventana();
		addWindowListener(listener_Ventana);
	}
}


class M_Ventana implements WindowListener{

	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana Activada");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("Ventana Cerrada");
	}

	public void windowClosing(WindowEvent e) {
		System.out.println("Cerrando ventana");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana segundo plano");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana restaurada");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana minimizada");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana abierta");
	}
	
	
}