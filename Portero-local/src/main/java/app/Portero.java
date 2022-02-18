package app;

import java.util.concurrent.Semaphore;

public class Portero {
	private static final int MAX_AVAILABLE = Edificio.getAFORO_MAX(); // tamaÃ±o maximo del aforo
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true); // el semaforo
	protected Edificio edificio = new Edificio(); // Variable que almacena las personas
	/*
	 * Vector de booleanos que almecena el estado de la lista de las personas del
	 * aforo
	 */
	protected boolean[] used = new boolean[MAX_AVAILABLE];

	/*
	 * Metodos de entrada de personas
	 */
	/**
	 * Metodo que pide permiso al semaforo para introducir una persona posteriormente.
	 * 
	 * @param persona que entra
	 * @throws InterruptedException
	 */
	public void putItem(Persona persona) throws InterruptedException {
		available.acquire(); // el hilo "pide turno"
		if (markAsUnused(persona)) {
			available.release();
		}
	}

	/**
	 * Metodo que introduce una persona en la cola
	 * 
	 * @param persona
	 * @return valor del vector de
	 */
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

	/**
	 * Metodo para obtener el permiso del semaforo para sacar una persona que se
	 * encuentra en la cola.
	 * 
	 * @throws InterruptedException
	 */
	public void getItem() throws InterruptedException {
		available.acquire(); // el hilo "pide turno"
		this.getNextAvailableItem();
	}

	/**
	 * Metodo que saca una persona de la cola a la vez que actualiza el estado del
	 * vector de booleanos
	 * 
	 * @return Persona que sale
	 */
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
		return persona; // Persona error
	}

}
