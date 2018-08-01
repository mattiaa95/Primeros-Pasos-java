package archivos;

import java.io.File;

public class PruebaRutas {
	public static void main(String[] args) {
		File file = new File("bin");
		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());
		
		if (file.isDirectory()) {
			String[] listaRuta =file.list();
			for (String archivo : listaRuta) {
				File hijo =new File(file.getAbsolutePath(), archivo);
				if (hijo.isDirectory()) {
					String[] listaHijo =hijo.list();
					System.out.println("--"+archivo);
					for (String elemento : listaHijo) {
						System.out.println("--->"+elemento);
					}
				} else {
				System.out.println(archivo);
				}
			}
		}
	
		
	}
}
