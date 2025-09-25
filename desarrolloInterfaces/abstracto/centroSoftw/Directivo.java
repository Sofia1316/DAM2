package centroSoft2;

public class Directivo extends Comun {
	public boolean salesiano;
	public boolean turno;
	
	public Directivo(int dni, String nombre, String apellidos, double salario, boolean salesiano,
			boolean turno) {
		super(dni, nombre, apellidos, salario);
		this.salesiano = salesiano;
		this.turno = turno;
	}
	
	public boolean isSalesiano() {
		return salesiano;
	}
	public void setSalesiano(boolean salesiano) {
		this.salesiano = salesiano;
	}
	public boolean isTurno() {
		return turno;
	}
	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	@Override
	public String toString() {
		return "Directivo [salario=" + salario + ", salesiano=" + salesiano + ", turno=" + turno + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

	@Override
	protected double getSalario() {
		// TODO Auto-generated method stub
		return salario;
	}

}
