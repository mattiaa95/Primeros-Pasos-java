package eventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class EventosVentana2 {

	public static void main(String[] args) {
		MarcoVent miMarco = new MarcoVent();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoVent extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3656755845762380803L;

	public MarcoVent() {
		setTitle("Botones y Eventos");
		setBounds(700,300,500,300);
		addWindowListener(new M_Vent());
	}
}


class M_Vent extends WindowAdapter{

	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana restaurada");
	}

	
}