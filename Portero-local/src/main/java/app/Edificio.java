package app;

import java.util.ArrayList;
import java.util.List;

public class Edificio {
	public static final int AFORO_MAX=31; // Aforo maximo del local el cual es invariable y siempre es 31, por lo tanto no hace falta protegerlo
	private List<Persona> Aforo = new ArrayList<Persona>(); // representacion fisica del aforo actual el cual guarda personas  
	private int Aforo_actual=Aforo.size(); //representacion numerica del aforo actual, sirve solo para representar ese valor y no altera ninguna otra operaci�n
	private static int Aforo_Total; //variable estatica del aforo total al final del d�a/programa, se sumara en la operaci�n de Entrada() y la compartira toda la clase
	
	
}
