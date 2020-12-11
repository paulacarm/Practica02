package coworking;
/**
 * 
 * @author Paula
 *
 *
 */
public class AsignarTurnos {
	
	static int turno;
	static int siguienteturno=1;
	
	public static int dameTurno() {
		//Cada vez que un hilo pide turno se incrementa la variable de manera que el primero que llegue tendra el primer turno
		turno++;
		return turno;		
	}
	
	public static void incrementarturno(){
		siguienteturno++;
			
	}

}






