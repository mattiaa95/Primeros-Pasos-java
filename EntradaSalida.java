import javax.swing.JOptionPane;

public class EntradaSalida {
	
	public static void main(String args[]) {
	String nombre=JOptionPane.showInputDialog("Introduce tu nombre");

	String edad=JOptionPane.showInputDialog("Introduce tu edad");
	int edad_usr = Integer.parseInt(edad);
	
	System.out.println("Tu nombre es "+nombre+" Y tu edad el proximo año sera "+(edad_usr+1));
	
	}
}
