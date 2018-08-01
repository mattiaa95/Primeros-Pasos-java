package tareas;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class PelotaHilos implements Runnable {
	private Pelota pelota;
	private Component componente;
	
	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		this.pelota=unaPelota;
		this.componente=unComponente;
	}
	public void run() {
		
		System.out.println("Estado del hilo: "+ Thread.currentThread().isInterrupted());
		//for (int i=1; i<=3000; i++){
		//while(!Thread.interrupted()) {
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} 
		}
		System.out.println("Estado del hilo: "+ Thread.currentThread().isInterrupted());
		
	}
}




//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7496164796882534521L;

	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2351505076367202847L;

	public MarcoRebote(){
		
		setBounds(600,300,600,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "Hilo1", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				if (t1==null||t1.isInterrupted()) {					
					comienza_el_juego(evento);
				}else {
					detener(evento);
				}
			}
			
		});
		
		ponerBoton(laminaBotones, "Hilo2", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				if (t2==null||t2.isInterrupted()) {					
					comienza_el_juego(evento);
				}else {
					detener(evento);
				}
			}
			
		});
		
		ponerBoton(laminaBotones, "Hilo3", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				if (t3==null||t3.isInterrupted()) {					
					comienza_el_juego(evento);
				}else {
					detener(evento);
				}
			}
			
		});		
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego (ActionEvent e){
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r= new PelotaHilos(pelota, lamina);
			JButton o =(JButton)e.getSource();
			if (o.getText().equals("Hilo1")) {
				t1=new Thread(r);
				t1.start();				
			}else if (o.getText().equals("Hilo2")) {
				t2=new Thread(r);
				t2.start();	
			} else if(o.getText().equals("Hilo3")) {
				t3=new Thread(r);
				t3.start();	
			}
			
		
	}
	
	
	
	public void detener(ActionEvent e) {
		//t.stop();
		JButton o =(JButton)e.getSource();
		if (o.getText().equals("Hilo1")) {
			t1.interrupt();				
		}else if (o.getText().equals("Hilo2")) {
			t2.interrupt();
		} else if(o.getText().equals("Hilo3")) {
			t3.interrupt();	
		}
		
		
	}
	
	private LaminaPelota lamina;
	
	Thread t1,t2,t3;
}
