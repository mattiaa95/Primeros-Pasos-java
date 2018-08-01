package empleados;

public class Empleados {

	
	public static void main(String[] args) {
		Empleados empl1 = new Empleados("mattia");
		Empleados empl2 = new Empleados("ana");
		Empleados empl3 = new Empleados("fran");
		empl1.cambiaSeccion("Bosses");
		System.out.println(empl1.datosEmpleado());
		System.out.println(empl2.datosEmpleado());
		System.out.println(empl3.datosEmpleado());
		System.out.println(Empleados.getIdCount());
	}
	private int id;
	private static int idSiguiente=1;
	private final String nombre;
	private String seccion;
	
	public Empleados(String nom) {
		this.id=Empleados.idSiguiente;
		Empleados.idSiguiente++;
		this.nombre=nom;
		this.seccion="Noobs";
	}
	
	public void cambiaSeccion(String seccion) {
		this.seccion=seccion;
	}
	
	public String datosEmpleado(){
		return this.id+"-Nombre: "+this.nombre+" Seccion: "+this.seccion;
	}
	public static int getIdCount() {
		return idSiguiente;
	}
	
}
