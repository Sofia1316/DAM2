package centroSoft;

public class Directivo extends Comun {
	public double salario;
	public boolean salesiano;
	public boolean turno;
	
	public Directivo(int dni, String nombre, String apellidos, double salario, boolean salesiano, boolean turno) {
		super(dni, nombre, apellidos);
		this.salario = salario;
		this.salesiano = salesiano;
		this.turno = turno;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
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

}
