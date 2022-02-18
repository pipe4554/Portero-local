package app;

public class Persona extends Thread {
	private String Nombre; // nombre de la persona que puede funcionar como id
	private Portero portero; // portero/semáforo
	private Persona persona; //Persona para implementar en los metodos 

	/**
	 * Constructor de clase normal
	 */
	public Persona(String nombre, Portero portero) {
		this.Nombre = nombre;
		this.portero = portero;

	}

	/**
	 * Constructor de personas que surgieron de un error
	 */
	public Persona(String ErrorNom) {
		this.Nombre = ErrorNom;
	}

	/*
	 * Metodo run para inicio de hilos 
	 */
	@Override
	public void run() {
		try {
			
			System.out.println("soy " + Nombre + " y estoy entrando");
			portero.putItem(persona); // Entra una persona al edificio atravez del portero
			
			Thread.sleep(2 * 1000);
			
			System.out.println("soy " + Nombre + " y estoy saliendo");
			portero.getItem();
			
		} catch (InterruptedException Ie) {
			Ie.printStackTrace();
			System.out.println();
		}
	}
	/**
	 * Metodo para instanciar la propia clase persona, asi poder crear y lanzar los hilos de manera statica desde la propia clase
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * Metodo estático de creación de hilos.
	 * Crea hilos de manera automatica sin necesidad de crearlos en Main
	 */
	public static void CrearHiloPersona(String nombre, Portero portero) throws InterruptedException {
		 Persona persona = new Persona(nombre, portero);
		 persona.setPersona(persona);
		 
		 persona.start();
		 persona.join();
		
	}
	
	
}
