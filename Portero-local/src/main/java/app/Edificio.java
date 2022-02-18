package app;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
	private static final int AFORO_MAX=31; // Aforo maximo del local el cual es invariable y siempre es 31, por lo tanto no hace falta protegerlo
	private List<Persona> Aforo = new ArrayList<Persona>(); // representacion fisica del aforo actual el cual guarda personas  
	private int Aforo_actual=0; //representacion numerica del aforo actual, sirve solo para representar ese valor y no altera ninguna otra operacion
	/*
	 * variable estatica del aforo total al final del programa, se sumara en la operacion de Entrada()
	 *  y la compartira toda la clase, puede ser una variable no estatica para tratarlo de manera mas simple,
	 *   pero a la vez puede producir errores a la hora del recuento
	 */
	private static int Aforo_Total=0; 
	
	public int getAforo_Actual() {
		return Aforo_actual;
	}
	public static int getAFORO_MAX() {
		return AFORO_MAX;
	}
	
	/*
	 * metodos para el recuento actual y total del aforo
	 */
	
	/**
	 * metodo para la entrada de personas, al sumar el aforo actual tambien se suma el aforo total
	 */
	public void entra() {
		Aforo_actual+=1;
		Aforo_Total+=1;
	}
	/**
	 * metodo para la salida de personas 
	 */
	public void sale() {
		Aforo_actual-=1;
	}
	
	
	
	/*
	 * Metodos de entrada y salida de personas en el Array de personas
	 */
	public Persona getPersona(int i) {
		Aforo.remove(i);
		return Aforo.get(i);
		
	}
	public void addPersona(Persona persona) {
		Aforo.add(persona);
	}
	
	/*
	 * Getters y Setters
	 */
	public int getAforo_actual() {
		return Aforo_actual;
	}
}
