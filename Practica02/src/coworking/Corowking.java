package coworking;

import java.util.ArrayList;
import java.util.Random;



public class Corowking {

public static void main(String[] args) {
	
		//Creo un array de trabajadores, en este caso con 5
		Trabajador[] trabajadores = new Trabajador[5];
		//Creo un array de tarjetas,en este caso 5 también
		Tarjeta[] tarjetas = new Tarjeta[5];
		//Creo el objeto ordenador
		Ordenador o=new Ordenador();
	   //creo las tarjetas y los trabajadores y comienzan los hilos.
		for (int i = 0; i < tarjetas.length; i++) {
			tarjetas[i] = new Tarjeta(i);
		}
		
		for (int i = 0; i < trabajadores.length; i++) {
			trabajadores[i] = new Trabajador(i,o,trabajadores.length,tarjetas);	
		}



	}








}
