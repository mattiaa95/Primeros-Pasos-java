import java.util.Scanner;

public class PrimeraClase {

	public static void main(String args[]) {
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduce tu nombre:");
		String nombre = entrada.nextLine();
		System.out.println("Introduce tu edad:");
		int edad = entrada.nextInt();
		System.out.println("Tu nombre es "+nombre+" Y tu edad es "+edad);
		entrada.close();
	}
}
