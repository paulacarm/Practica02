package coworking;

import java.util.Random;
import java.util.concurrent.locks.Lock;
/**
 * 
 * @author Paula
 * La clase Ordenador representa un objeto compartido entre los hilos.
 * Tiene m�todos sincronizados para acceder a �l
 *
 */
public class Ordenador {
	//aleatorio para usar el PC un tiempo
	private Random r = new Random();
	
	public synchronized  void entrar(Tarjeta t1,Tarjeta t2,Trabajador t) {
		/**
		 * M�todo para entrar al PC. Se le pasa por par�metro los tarjetas para utilizarlas y el trabajador para saber que hilo es.
		 * Se comprueba que es el turno del trabajador que lo solicita y que las tarjetas esten disponibles, en caso contrario el hilo espera 
		 * a que sea su turno. Si es su turno coge las dos tarjetas y llama ala funci�n de usar PC.
		 */
		//t.setTurno(AsignarTurnos.dameTurno());
		System.out.println("El trabajador " +t.getNtrabajador()+ ", se le ha ocurrido una idea y tiene el turno " 
				+t.getTurno()); 
		while(t.getTurno()!=AsignarTurnos.siguienteturno ||t1.getOcupado() || t2.getOcupado() ) {
			try {
				System.out.println("El trabajador " +t.getNtrabajador()+ ", esta esperando turno...........");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}	
		t1.cogerTarjeta();	
		t2.cogerTarjeta();
		usar(t1,t2,t);	
	
			
		
		
	}
	
	public  synchronized  void usar(Tarjeta t1,Tarjeta t2,Trabajador t) {
		/**
		 * M�todo para usar el ordenador, se muestra por pantalla un mensaje y se espera un tiempo aleatorio
		 * para despu�s soltar las tarjetas y despertar a los hilos que estan esperando
		 * Se incrementa el contador de turnos para que pase el siguiente que le toque
		 */
		System.out.println("LE TOCA AL TURNO: " +AsignarTurnos.siguienteturno);
		System.out.println("TRABAJADOR "+t.getNtrabajador()+ " USANDO EL PC.................");
		int espera = r.nextInt(100); 
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		t1.soltarTarjeta();
		t2.soltarTarjeta();
		notifyAll();
		AsignarTurnos.incrementarturno();
	}

	
}
