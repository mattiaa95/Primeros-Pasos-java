package temporizador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MyTimer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reloj miReloj = new Reloj();
		miReloj.enMarcha(500,true);
		JOptionPane.showMessageDialog(null, "Aceptar para parar");
		System.exit(0);
	}

}

class Reloj {	
	public void enMarcha( int intervalo,final boolean sonido) {
	 class DameLaHora2 implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Date hora = new Date();
				System.out.println(hora);
				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		ActionListener oyente=new DameLaHora2();
		Timer tmp = new Timer(intervalo, oyente);
		tmp.start();
	}
	
}
