package tareas;

public class SincronizandoHilos {
	public static void main(String[] args) {
		Hilos t0 = new Hilos();
		Hilos2 t1 = new Hilos2(t0);
		
		t1.start();
		t0.start();
		
		System.out.println("Tareas Terminadas en orden");
		
	}
}

class Hilos extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecuentado hilo: "+getName());
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class Hilos2 extends Thread{
	private Thread hilo;
	public Hilos2(Thread hilo) {
		this.hilo=hilo;
	}
	@Override
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecuentado hilo: "+getName());
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}