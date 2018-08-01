package arraylist;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class Empleado implements Comparable<Empleado>,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1599621986555923315L;
	
	private String nombre;
	private double sueldo;
	private Date fecha;
	
	public Empleado(String nombre,double sueldo,int agno,int mes, int dia) {
		this.nombre=nombre;
		this.sueldo=sueldo;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		this.fecha= calendario.getTime();
	}
	
	public Empleado(String nombre,double sueldo) {
		this.nombre=nombre;
		this.sueldo=sueldo;
		this.fecha= new Date();
	}
	
	public Empleado(String nombre) {
		this(nombre, 1555);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento= sueldo*porcentaje/100;
		sueldo= sueldo+aumento;
	}
	
	public String toString() {
		return "Nombre: "+this.nombre+" Sueldo: "+this.sueldo+" Fecha: "+this.fecha;
	}

	@Override
	public int compareTo(Empleado o) {
		if(this.sueldo > o.sueldo) return 1; 
		if(this.sueldo < o.sueldo) return -1;
		else                   return 0;
	}
	
	public static Comparator<Empleado> EmpleadoNameComparator = new Comparator<Empleado>() {

		public int compare(Empleado emp1, Empleado emp2) {
			
			return emp1.compareTo(emp2);

		}

	};
	
}
