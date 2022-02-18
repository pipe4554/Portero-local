package app;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Portero portero = new Portero();
		System.out.println();
		for (int i = 0; i < 100; i++) {
			String nombre = "pedro" + i;
			Persona.CrearHiloPersona(nombre , portero);
		}
		//fallo en los limites de los Arrays
	}

}
