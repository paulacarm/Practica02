package coworking;

import java.util.Random;

/**
 * @author Paula
 * Clase trabajador. Esta clase representa a cada uno de los trabajadores(hilos) que intentan acceder al PC
 * 
 *   */
public class Trabajador implements Runnable {

	//Variable para guardar el numero de trabajador 
	private int nTrabajador;
	//random para esperar un tiempo aleatorio
	private Random r = new Random();
	//Variable que representa el hilo
	Thread t;
	//variables para guardar el número de tarjeta que le corresponde a cada trabajador
	private int nt1,nt2;
	//variable que guarda el número de trabajadores que existen
	private int ntrabajadores;
	private Ordenador ordenador;
	//Variable para guardar el turno que se le asigne a cada trabajador
	private int turnotrabajador;
	//Array donde están todas las tarjetas para buscar las que necesito
	private Tarjeta[] tarjetas;
	//Variables para guardar las tarjetas que necesita el trabajador
	private Tarjeta tarjeta1,tarjeta2;
	//variables para saber si tengo las tarjetas en mi poder
	private boolean t1,t2;
	
	public Trabajador(int nTrabajador,Ordenador ordenador,int ntrabajadores,Tarjeta[] tarjetas) {
		this.nTrabajador = nTrabajador;
		t = new Thread(this);
		this.ordenador=ordenador;
		this.ntrabajadores=ntrabajadores;
		this.tarjetas=tarjetas;
		//Para saber que tarjeta le corresponde coger a cada trabajador
				if(this.nTrabajador==this.ntrabajadores-1) {
					this.nt1=4;
					this.nt2=0;	
				}
				else{
					this.nt1=this.nTrabajador;
					this.nt2=this.nTrabajador+1;
					}	
				buscarTarjetas();			
		//Se le asigna el turno al trabajador, siempre el primero sera el thread 0 y va seguidamente el de su derecha para implementar el turno ciclico
		pedirTurno();
		t.start();
	}
	
	@Override
	public void run() {
		
		System.out.println("El trabajador " + nTrabajador+ ", está pensando ideas..........");	
		int espera = r.nextInt(1000); 
		//El trabajador piensa un tiempo aleatorio
		try {
			
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
				Thread.currentThread().interrupt();
		}
		//Despues de un tiempo pensando el trabajador intenta usar el ordenador. Se muestra información del hilo
	
		this.ordenador.entrar(tarjeta1, tarjeta2, this);
	}
	
	
	public synchronized  void pedirTurno() {
		this.turnotrabajador=AsignarTurnos.dameTurno();
	}
	
	public int getTurno() {
		return this.turnotrabajador;
	}
	public void setTurno(int turno) {
		this.turnotrabajador=turno;
	}
	public int getNtrabajador() {
		return this.nTrabajador;
	}
	public void buscarTarjetas() {
	//Busco las tarjetas necesarias para cada trabajador
		for(int i=0;i<this.tarjetas.length;i++) {
			if(tarjetas[i].getNTarjeta()==nt1) {
				this.tarjeta1=tarjetas[i];
			}
			if(tarjetas[i].getNTarjeta()==nt2) {
				this.tarjeta2=tarjetas[i];
			}
		}
	}
	

}
