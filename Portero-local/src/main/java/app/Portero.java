package app;

import java.util.concurrent.Semaphore;

public class Portero {
	private static final int MAX_AVAILABLE = Edificio.getAFORO_MAX(); //tamaÃ±o maximo del aforo
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true); // el semaforo

	
	protected Edificio edificio = new Edificio();

	protected boolean[] used = new boolean[MAX_AVAILABLE];

	public Persona getItem() throws InterruptedException {
		available.acquire(); //el hilo "pide turno"
		return getNextAvailableItem();
	}

	public void putItem(Persona persona) throws InterruptedException {
		available.acquire(); //el hilo "pide turno"
		if (markAsUnused(persona)) {
			available.release();
		}
	}
	
	
	protected synchronized Persona getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				edificio.sale();
				System.out.println("Aforo actual: " + edificio.getAforo_actual());
				return edificio.getPersona(i);
			}
		}
		Persona persona = new Persona("error");
		return persona; // not reached
	}

	protected synchronized boolean markAsUnused(Persona persona) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				edificio.addPersona(persona);
				edificio.entra();
				System.out.println("Aforo actual: " + edificio.getAforo_actual()); 
				return true;
			}

		}
		return false;

	}
}
