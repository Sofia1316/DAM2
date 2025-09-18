package centroSoft;

public class Profesor extends Comun{
	public double salario;
	public int nAsign;
	public boolean tutor;
	
	public Profesor(int dni, String nombre, String apellidos, double salario, int nAsign, boolean tutor) {
		super(dni, nombre, apellidos);
		this.salario = salario;
		this.nAsign = nAsign;
		this.tutor = tutor;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getnAsign() {
		return nAsign;
	}
	public void setnAsign(int nAsign) {
		this.nAsign = nAsign;
	}
	public boolean isTutor() {
		return tutor;
	}
	public void setTutor(boolean tutor) {
		this.tutor = tutor;
	}
	
	@Override
	public String toString() {
		return "Profesor [salario=" + salario + ", nAsign=" + nAsign + ", tutor=" + tutor + ", dni=" + dni + ", nombre="
				+ nombre + ", apellidos=" + apellidos + "]";
	}

}
