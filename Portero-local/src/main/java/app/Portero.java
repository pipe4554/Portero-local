package app;

import java.util.concurrent.Semaphore;

public class Portero {
	private static final int MAX_AVAILABLE = Edificio.getAFORO_MAX(); //tamaÃ±o maximo del aforo
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true); // el semaforo

	
	protected Edificio edificio = new Edificio();

	protected boolean[] used = new boolean[MAX_AVAILABLE];

	public Persona getItem() throws InterruptedException {
		//el hilo "pide turno"
		available.acquire();
		return getNextAvailableItem();
	}

	public void putItem(Persona persona) throws InterruptedException {
		//el hilo "pide turno"
		available.acquire();
		if (markAsUnused(persona)) {
			available.release();
		}
	}
	
	
	protected synchronized Persona getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				edificio.sale();
				return edificio.getPersona(i);
			}
		}
		Persona persona = new Persona("error");
		return persona; // not reached
	}

	protected synchronized boolean markAsUnused(Persona persona) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				edificio.setPersona(i, persona);
				edificio.entra();
				return true;
			}

		}
		return false;

	}
}
