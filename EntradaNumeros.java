import javax.swing.JOptionPane;

public class EntradaNumeros {
	public static void main(String[] args) {
		
		
		String numero=JOptionPane.showInputDialog("Introduce un numero");
		
		double num2 = Double.parseDouble(numero);
		
		System.out.print("La raiz de " + num2 + " es " );
		System.out.printf("%1.2f",Math.sqrt(num2));
		
		
	}
}
