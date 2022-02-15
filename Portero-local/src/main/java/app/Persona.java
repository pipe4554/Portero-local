package app;

public class Persona extends Thread{
	private String Nombre;
	private Portero portero;
	
	/*
	 * Constructor de clase normal
	 */
	public Persona(String nombre,Portero portero) {
		this.Nombre = nombre;
		this.portero = portero;
		
	}
	/*
	 * Constructor de personas que surgieron de un error
	 */
	public Persona(String ErrorNom) {
		this.Nombre = ErrorNom;
	}
	
	@Override
	public void run() {
		this.entra();
		try {
			Thread.sleep(2*1000);
		} catch (InterruptedException Ie) {
			Ie.printStackTrace();
		}
		this.sale();
	}
	
	//Metodos para limpieza de código
	public void entra(Persona persona) throws InterruptedException { 
		System.out.println("soy " + Nombre + " y estoy entrando");
		portero.putItem(persona);
		
	}
	public void sale() {
		System.out.println("soy " + Nombre + " y estoy saliendo");
	}
	
	
}
