package leer_escribir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		File ruta = new File("NuevoDir");
		ruta.mkdir();
		
		File file = new File("NuevoDir"+File.separator+"miFile.txt");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File rutaCreada = new File("NuevoDir");
		System.out.println(rutaCreada.exists()+" "+rutaCreada.isDirectory()+" "+rutaCreada.getAbsolutePath());
		String[] miRuta = rutaCreada.list();
		for (String string : miRuta) {			
			System.out.println("Escribinedo en :"+rutaCreada.getAbsolutePath()+File.separator+string);
			try {
				FileWriter writeFile = new FileWriter(rutaCreada.getAbsolutePath()+File.separator+string);
				writeFile.write("Estoy aqui y funciono");
				writeFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Escrito");
			
		}
	}

}
