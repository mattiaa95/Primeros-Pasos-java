package empleados;

public class Jefatura extends Empleado implements Jefe{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4824218834970174308L;
	private double incentivo;

	public Jefatura(String nombre, double sueldo, int agno, int mes, int dia) {
		super(nombre, sueldo, agno, mes, dia);
	}
	
	public void estableceIncentivo(double b) {
		
		incentivo=b+this.estableceBonus(500);
	}
	
	public double getSueldo() {
		return super.getSueldo()+incentivo;
	}

	@Override
	public String TomarDeciciones(String D) {
		return D;
	}

	@Override
	public double estableceBonus(double extra) {
		double bonus = Trabajadores.bonus_base + extra;
		return bonus;
	}
	
}
