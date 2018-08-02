package tareas;

public class BancoSync {
	public static void main(String[] args) {
		Banco b=new Banco();
		for (int i = 0; i < 100; i++) {
			EjecucionTransferencias run=new EjecucionTransferencias(b, i, 2000);
			Thread t=new Thread(run);
			t.start();
		}		
	}
}

class Banco{
	private final double[] cuentas;
	//private Lock cierreBanco=new ReentrantLock();
	//private Condition saldoSuficiente;
	public Banco() {
		cuentas= new double[100];
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i]=2000;
		}
		//saldoSuficiente=cierreBanco.newCondition();
	}
	public synchronized void transferencia(int cuentaOr,int cuentaDst,double cantidad) throws InterruptedException {
		//cierreBanco.lock();
		//try {
		long startTime = System.currentTimeMillis();
			while(cuentas[cuentaOr]<cantidad) {
				//saldoSuficiente.await();
				System.out.println("--------------Hilo en espera "+Thread.currentThread());
				wait();
			}
			
			cuentas[cuentaOr]-=cantidad;
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOr,cuentaDst);
			cuentas[cuentaDst]+=cantidad;
			System.out.printf("Saldo Total: %10.2f%n",getSaldoTotal());
			
			long endTime = System.currentTimeMillis() - startTime;
			System.out.println("-----------------"+Thread.currentThread()+"Termino(con espera) en "+endTime+". Desbloqueando Hilos en espera.");
			
			notifyAll();
			
			//saldoSuficiente.signalAll();
		//}finally{
			//cierreBanco.unlock();
		//}
	}
	
	public double getSaldoTotal() {
		double suma_cuentas=0;
		for (double cuenta : cuentas) {
			suma_cuentas+=cuenta;
		}
		return suma_cuentas;
	}
}


class EjecucionTransferencias implements Runnable{
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
	public EjecucionTransferencias(Banco b,int de,double max) {
		banco=b;
		deLaCuenta=de;
		cantidadMax=max;
	}
	@Override
	public void run() {
		try {
			while(true) {
				int paraLaCuenta=(int)(100*Math.random());
				double cantidad=cantidadMax*Math.random();
				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
				Thread.sleep((int)(50*Math.random()));
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}