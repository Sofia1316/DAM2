package centroSoft2;

public class Administración extends Comun{
	public String estudios;
	public int antiguo;
	
	public Administración(int dni, String nombre, String apellidos, double salario, String estudios, int antiguo) {
		super(dni, nombre, apellidos, salario);
		this.estudios = estudios;
		this.antiguo = antiguo;
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
		return "Administración [estudios=" + estudios + ", antiguo=" + antiguo + ", dni=" + dni + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", salario=" + salario + "]";
	}
	
	@Override
	protected double getSalario() {
		// TODO Auto-generated method stub
		return salario;
	}
	
	
	
}
