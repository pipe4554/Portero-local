package app;

public class Persona extends Thread{
	private String Nombre;
	
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
	public void entra() { 
		System.out.println("soy " + Nombre + " y estoy entrando");
	}
	public void sale() {
		System.out.println("soy " + Nombre + " y estoy saliendo");
	}
}
