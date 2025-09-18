package centroSoft;

public class Administración extends Comun{
	public double salario;
	public String estudios;
	public int antiguo;
	
	public Administración(int dni, String nombre, String apellidos, double salario, String estudios, int antiguo) {
		super(dni, nombre, apellidos);
		this.salario = salario;
		this.estudios = estudios;
		this.antiguo = antiguo;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	public int getAntiguo() {
		return antiguo;
	}
	public void setAntiguo(int antiguo) {
		this.antiguo = antiguo;
	}

	@Override
	public String toString() {
		return "Administración [salario=" + salario + ", estudios=" + estudios + ", antiguo=" + antiguo + ", dni=" + dni
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
}
