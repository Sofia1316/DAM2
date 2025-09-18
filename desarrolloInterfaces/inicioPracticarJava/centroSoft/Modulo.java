package centroSoft;

public class Modulo {
	public String nombre;
	public int horas;
	public Profesor profesor;
	public boolean convalidar;
	
	public Modulo(String nombre, int horas, Profesor profesor, boolean convalidar) {
		super();
		this.nombre = nombre;
		this.horas = horas;
		this.profesor = profesor;
		this.convalidar = convalidar;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public boolean isConvalidar() {
		return convalidar;
	}
	public void setConvalidar(boolean convalidar) {
		this.convalidar = convalidar;
	}

	@Override
	public String toString() {
		return "Modulo [nombre=" + nombre + ", horas=" + horas + ", profesor=" + profesor + ", convalidar=" + convalidar
				+ "]";
	}
	
}
