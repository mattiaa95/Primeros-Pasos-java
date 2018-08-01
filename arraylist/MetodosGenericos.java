package arraylist;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombres[]= {"Jose","Mattia","Pepe","Ana","Maria"};
		
		String elementos= MisMatrices.getElementos(nombres);
		
		System.out.println(MisMatrices.getMenor(nombres));
	
		System.out.println(elementos);
		
		Empleado listaEmp[]= {new Empleado("maria"),new Empleado("mattia"),new Empleado("mario"),new Empleado("pepe")};
		
		System.out.println(MisMatrices.getElementos(listaEmp));
		
		System.out.println(MisMatrices.getMenor(listaEmp));
		

	}

}

class MisMatrices{
	public static <T> String getElementos(T[]a) {
		return "El array tiene "+ a.length +" elementos";
	}
	public static <T extends Comparable<T>> T getMenor(T[]a) {
		if (a==null || a.length==0) {
			return null;
		}
		T elementoMenor=a[0];
		for (int i = 0; i < a.length; i++) {
			if (elementoMenor.compareTo(a[i])>0) {
				elementoMenor=a[i];
			}
			
		}
		return elementoMenor;
	}

	
}
