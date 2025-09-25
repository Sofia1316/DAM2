package biblioteca;

public class Revista extends Comun{
	int numR;

	public Revista(int cod, String titulo, int ap, int numR) {
		super(cod, titulo, ap);
		this.numR = numR;
	}

	public int getNumR() {
		return numR;
	}

	public void setNumR(int numR) {
		this.numR = numR;
	}

	@Override
	public String toString() {
		return "Revista [numR=" + numR + ", cod=" + cod + ", titulo=" + titulo + ", ap=" + ap + "]";
	}
	
	
	
}
