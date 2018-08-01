package temporizador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class myTimer{

	public static void main(String[] args) {
		
		DameLaHora accion = new DameLaHora();
		Timer temp =new Timer(5000, accion);
		temp.start();
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");
		System.exit(0);

	}


}

class DameLaHora implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Date hora = new Date();
		System.out.println(hora);
		Toolkit.getDefaultToolkit().beep();
	}
	
}
