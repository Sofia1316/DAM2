package centroSoft;

public class Alumno extends Comun{
	public String fechaNac;
	public boolean sexo;
	public boolean repetidor;
	public Modulo modulo;
	
	public Alumno(int dni, String nombre, String apellidos, String fechaNac, boolean sexo, boolean repetidor,
			Modulo modulo) {
		super(dni, nombre, apellidos);
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.repetidor = repetidor;
		this.modulo = modulo;
	}
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public boolean isRepetidor() {
		return repetidor;
	}
	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	
	@Override
	public String toString() {
		return "Alumno [fechaNac=" + fechaNac + ", sexo=" + sexo + ", repetidor=" + repetidor + ", modulo=" + modulo
				+ ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
}
