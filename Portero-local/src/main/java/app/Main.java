package app;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hola");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Adios");
	}

}
