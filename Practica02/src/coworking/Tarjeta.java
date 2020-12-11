package coworking;

import java.util.Random;
/**
 *
 * @author Paula
 *  Esta clase representa las tarjetas con las que acceder al PC., tiene un numero de tarjeta para identificarlas y un una variable para
 *  representar si están disponibles para cogerlas
 *
 */

public class Tarjeta {

	//Variable para almacenar el número de tarjeta
	private int nTarjeta;
	//Variable para controlar si la tarjeta está libre
	private boolean ocupado;

	

	public Tarjeta(int num) {
		this.nTarjeta = num; 
		this.ocupado = false; 
		this.ocupado=false;
		
	}

	public int getNTarjeta() {
		return this.nTarjeta;
	}
	
	public  void cogerTarjeta()  {
		this.ocupado=true;
		System.out.println("cojo la tarjeta  " +this.nTarjeta);
			
	}
	
	public synchronized void soltarTarjeta() {
		this.ocupado=false;
		System.out.println("suelto la tarjeta  " +this.nTarjeta);	
	}
	
	public boolean getOcupado() {
		return this.ocupado;
	}
	public void settOcupado(boolean ocupado) {
		this.ocupado=ocupado;
	}

}
