package eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


public class EventoRaton {


		public static void main(String[] args) {
			MarcoRaton miMarco = new MarcoRaton();
			miMarco.setVisible(true);
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

}
 class MarcoRaton extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -261811275993985502L;
	 public MarcoRaton() {
		 setVisible(true);
		 setBounds(700,300,600,450);
		 EventosDeRaton EventoRtn = new EventosDeRaton();
		 addMouseListener(EventoRtn);
	 }
	 
 }
 
 class EventosDeRaton extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Has hecho click izq");
		} else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("Has hecho click drch");
		}else if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
			System.out.println("Has hecho click ctr");
		}
		System.out.println(e.getClickCount());
		System.out.println(e.getX()+" "+e.getY());
	}
	 
 }