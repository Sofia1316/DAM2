package biblioteca;

public class Libro extends Comun {
	static boolean prestado = false;

	public Libro(int cod, String titulo, int ap, boolean prestado) {
		super(cod, titulo, ap);
		this.prestado = prestado;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	@Override
	public String toString() {
		return "Libro [prestado=" + prestado + ", cod=" + cod + ", titulo=" + titulo + ", ap=" + ap + "]";
	}
	
	public static void prestar() {
		prestado = true;
	}
	
	public static boolean prestado() {
		return prestado;
	}
	
	public static void devolver() {
		prestado = false;
	}
	
}
