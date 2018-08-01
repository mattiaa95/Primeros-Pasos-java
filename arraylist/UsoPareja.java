package arraylist;

public class UsoPareja {

	public static void main(String[] args) {
		
		Pareja<String> una = new Pareja<String>();
		
		una.setPrimero("Hola soy una instancia generica");
		
		System.out.println(una.getPrimero());
		
		Persona pers1 = new Persona("mattia");
		
		Pareja<Persona> persona = new Pareja<Persona>();
		
		persona.setPrimero(pers1);
		
		System.out.println(persona.getPrimero().toString());
		

		
	}

}

class Persona{
	private String nombre;
	public Persona(String nombre) {
		this.nombre=nombre;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+this.nombre;
	}
	
}
