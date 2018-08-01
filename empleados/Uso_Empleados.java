package empleados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Uso_Empleados {

	public static void main(String[] args) {
		Empleado[] empleados =new Empleado[5];
		
		empleados[0]= new Jefatura("Juan", 2343, 1990, 11, 23);
		empleados[1]= new Empleado("Ana", 1800, 1993, 11, 23);
		empleados[2]= new Empleado("Mattia", 3344);
		empleados[3]= new Jefatura("Carlos", 6344, 1989, 11, 23);
		empleados[4]= new Empleado("Pepe");
		Arrays.sort(empleados, Empleado.EmpleadoNameComparator);
		
		try {
			ObjectOutputStream objFile = new ObjectOutputStream(new FileOutputStream("C:/Users/A692945/Desktop/empleados.dat"));
			objFile.writeObject(empleados);
			objFile.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for (Empleado empleado : empleados) {
			System.out.println("Nombre: "+empleado.getNombre() +" Fecha contrato: "+empleado.getFecha()+" Sueldo: "+empleado.getSueldo());
			if (empleado instanceof Jefatura) {
				System.out.println(((Jefatura) empleado).TomarDeciciones("Puedo tomar deciciones"));
				((Jefatura) empleado).estableceIncentivo(300);
			}else {
				empleado.subeSueldo(3);
			}
			System.out.println("Nombre: "+empleado.getNombre() +" Fecha contrato: "+empleado.getFecha()+" Sueldo: "+empleado.getSueldo());
			System.out.println("-----------------------------------------------------------------------------");
		}
		
	}
	
	
	

}
