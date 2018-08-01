package eventos;

import java.awt.Graphics;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FocoVentana {

	public static void main(String[] args) {
		MarcoFoco miMarco = new MarcoFoco();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
 class MarcoFoco extends JFrame{
	 
		/**
	 * 
	 */
	private static final long serialVersionUID = 8938002981166896052L;

		public MarcoFoco() {
			setTitle("Foco,Eventos");
			setBounds(700,300,500,300);
			LaminaFoco lamina = new LaminaFoco();
			add(lamina); 
			
			}

 }
 
 class LaminaFoco extends JPanel{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 4105979614866402615L;
	JTextField cuadro1;
	JTextField cuadro2;
	public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 setLayout(null);
		 cuadro1=new JTextField();
		 cuadro2=new JTextField();
		 cuadro1.setBounds(120,10,150,20);
		 cuadro2.setBounds(120,50,150,20);
		 add(cuadro1);
		 add(cuadro2);
		 LanzaFoco elFoco = new LanzaFoco();
		 cuadro1.addFocusListener(elFoco);
	}
	
	  class LanzaFoco extends FocusAdapter{
		public void focusLost(FocusEvent arg0) {
			String email = cuadro1.getText();
			if (email.contains("@")) {
				System.out.println("Email Valido");
			}
		}
		 
	 }
 }
 
 
 