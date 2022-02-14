package app;

import java.util.ArrayList;

import java.util.concurrent.Semaphore;

public class Portero {
	private static final int MAX_AVAILABLE = Edificio.getAFORO_MAX(); //tamaño maximo del aforo
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true); // el semaforo

	
	protected ArrayList<Persona> Aforo = new ArrayList<Persona>();

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
				return Aforo.get(i);
			}
		}
		Persona persona = new Persona(null);
		return persona; // not reached
	}

	protected synchronized boolean markAsUnused(Persona persona) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				Aforo.set(i, persona);
				return true;
			}

		}
		return false;

	}
}
