package empleados;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RecuperandoEmpleados {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			ObjectInputStream objFile = new ObjectInputStream(new FileInputStream("C:/Users/A692945/Desktop/empleados.dat"));
			Empleado[] personal_recuperado=(Empleado[]) objFile.readObject();
			for (Empleado empleado : personal_recuperado) {
				System.out.println(empleado.toString());
			}
			objFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
