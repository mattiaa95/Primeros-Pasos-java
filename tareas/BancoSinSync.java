package tareas;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class BancoSinSync {
	public static void main(String[] args) {
		Banco2 b=new Banco2();
		for (int i = 0; i < 100; i++) {
			EjecucionTransferencias2 run=new EjecucionTransferencias2(b, i, 2000);
			Thread t=new Thread(run);
			t.start();
		}		
	}
}

class Banco2{
	private final double[] cuentas;
	private Lock cierreBanco=new ReentrantLock();
	private Condition saldoSuficiente;
	public Banco2() {
		cuentas= new double[100];
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i]=2000;
		}
		saldoSuficiente=cierreBanco.newCondition();
	}
	public void transferencia(int cuentaOr,int cuentaDst,double cantidad) throws InterruptedException {
		cierreBanco.lock();
		try {
			while(cuentas[cuentaOr]<cantidad) {
				saldoSuficiente.await();
			} 
			System.out.println(Thread.currentThread());
			cuentas[cuentaOr]-=cantidad;
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOr,cuentaDst);
			cuentas[cuentaDst]+=cantidad;
			System.out.printf("Saldo Total: %10.2f%n",getSaldoTotal());
			saldoSuficiente.signalAll();
		}finally{
			cierreBanco.unlock();
		}
	}
	
	public double getSaldoTotal() {
		double suma_cuentas=0;
		for (double cuenta : cuentas) {
			suma_cuentas+=cuenta;
		}
		return suma_cuentas;
	}
}


class EjecucionTransferencias2 implements Runnable{
	private Banco2 banco;
	private int deLaCuenta;
	private double cantidadMax;
	public EjecucionTransferencias2(Banco2 b,int de,double max) {
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
				Thread.sleep((int)(5*Math.random()));
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}