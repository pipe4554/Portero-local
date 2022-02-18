package app;
/**
 * 
 * @author Luis Felipe Mejia 
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Portero portero = new Portero();
		System.out.println("\n*Inicio del programa*");
		for (int i = 0; i < 100; i++) {
			String nombre = "pedro" + i;
			Persona.CrearHiloPersona(nombre , portero);
		}
	}

}
