package eventos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class EventoTeclado {

		public static void main(String[] args) {
			MarcoTeclas miMarco = new MarcoTeclas();
			miMarco.setVisible(true);
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

}


class MarcoTeclas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1508799252535572523L;

	public MarcoTeclas() {
		setTitle("Teclas y Eventos");
		setBounds(700,300,500,300);
		EventoKey tecla=new EventoKey();
		addKeyListener(tecla);
		}
}

class EventoKey implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.print(arg0.getKeyCode());
		System.out.println(arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
