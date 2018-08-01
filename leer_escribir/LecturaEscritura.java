package leer_escribir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaEscritura {

	public static void main(String[] args) {
		crea_fichero(lee_fichero());
	}
	
	static void crea_fichero(ArrayList<Integer> array_bytes) {
		
		try {
			FileOutputStream archivoNuevo = new FileOutputStream("C:"+File.separator+"Users"+File.separator+"A692945"+File.separator+"Desktop"+File.separator+"imagenCopia.jpg");
			for (Integer integer : array_bytes) {
				archivoNuevo.write(integer);
			}
			archivoNuevo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	static ArrayList<Integer> lee_fichero() {
		ArrayList<Integer> byte_entrada=new ArrayList<Integer>();
		try {
			FileInputStream archivo = new FileInputStream("C:/Users/A692945/Desktop/imagen.jpg");
			boolean final_ar=false;
			while (!final_ar) {
				byte_entrada.add(archivo.read());
				if (byte_entrada.get(byte_entrada.size()-1).equals(-1)) {
					byte_entrada.remove(byte_entrada.size()-1);
					final_ar=true;
				}
			}
			archivo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return byte_entrada;
	}
}
