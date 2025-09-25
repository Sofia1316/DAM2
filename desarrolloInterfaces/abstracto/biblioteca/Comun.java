package biblioteca;

public class Comun {
	int cod;
	String titulo;
	int ap;
	
	public Comun(int cod, String titulo, int ap) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.ap = ap;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	@Override
	public String toString() {
		return "Comun [cod=" + cod + ", titulo=" + titulo + ", ap=" + ap + ", getCod()=" + getCod() + ", getTitulo()="
				+ getTitulo() + ", getAp()=" + getAp() + "]";
	}
	
}
