
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamPrueba2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer_fichero acceso = new Leer_fichero();
		acceso.Lee();
		Escribiendo escr = new Escribiendo();
		escr.escribir();
	}

}

class Leer_fichero{
	public void Lee() {
		try {
			FileReader entrada= new FileReader("C:/Users/A692945/Desktop/prueba.txt");
			BufferedReader mibuffer = new BufferedReader(entrada);
			String linea="";
			while(linea!=null) {
					System.out.println(linea);
					linea=mibuffer.readLine();
			
			}
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se encuentra el archivo");
			e.printStackTrace();
		}
	}
}

class Escribiendo{
	public void escribir() {		
		String frase="Frase nueva";
		try {
			FileWriter escritura = new FileWriter("C:/Users/A692945/Desktop/nuevo.txt");
			for (int i = 0; i < frase.length(); i++) {
				escritura.write(frase.charAt(i));	
			}
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}