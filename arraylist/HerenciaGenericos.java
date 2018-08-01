package arraylist;

public class HerenciaGenericos {

	public static void main(String[] args) {
		/*Empleado admin = new Empleado("Elena");
		Jefe direct = new Jefe("Martina");
		Empleado newEmp = direct;*/
		Pareja<Empleado> admin = new Pareja<Empleado>();
		Pareja<Jefe> dir = new Pareja<Jefe>();
		Pareja.imprimirEmp(admin);
		Pareja.imprimirEmp(dir);
		
	}

}
