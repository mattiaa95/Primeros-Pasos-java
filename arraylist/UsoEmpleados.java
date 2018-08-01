package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleados {

	public static void main(String[] args) {
		
		ArrayList<Empleado> empleados =new ArrayList<Empleado>();
		empleados.ensureCapacity(3);
		empleados.add(new Empleado("Ana", 1800, 1993, 11, 23));
		empleados.add(new Empleado("Mattia", 3344));
		empleados.add(new Empleado("Ana", 1800, 1993, 11, 23));
		empleados.add(new Empleado("Mattia", 3344));
		empleados.add(new Empleado("Ana", 1800, 1993, 11, 23));
		empleados.add(new Empleado("Mattia", 3344));
		empleados.add(new Empleado("Ana", 1800, 1993, 11, 23));
		empleados.add(new Empleado("Mattia", 3344));
		empleados.add(new Empleado("Ana", 1800, 1993, 11, 23));
		empleados.add(new Empleado("Mattia", 3344));
		empleados.set(0,new Empleado("Pepe"));
		empleados.set(3,new Empleado("Pepe"));
		empleados.trimToSize();
		
		for (Empleado empleado : empleados) {
			System.out.println("Nombre: "+empleado.getNombre() +" Fecha contrato: "+empleado.getFecha()+" Sueldo: "+empleado.getSueldo());
			System.out.println("-----------------------------------------------------------------------------");
		}
		
		System.out.println("------------------------------Con Iterator------------------------------------");
		
		Iterator<Empleado> iterador = empleados.iterator();
		
		while (iterador.hasNext()) {
			System.out.println(iterador.next());//usa el .toString()
		}
		
	}
	
	
	

}
