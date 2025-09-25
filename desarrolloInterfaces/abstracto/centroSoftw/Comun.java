package centroSoft2;

public abstract class Comun implements Comparable<Comun>{
	int dni;
	String nombre;
	String apellidos;
	double salario;
	
	public Comun(int dni, String nombre, String apellidos, double salario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	// Se convierten en clases abstractas en el caso de que quieras modificarlo en las clases hijas en función de otras variables,
	// por ejemplo, en profesor cambia el salario en función de si es salesiano o no
//	protected abstract double Salario();
	protected abstract double getSalario();
	
	@Override
	public int compareTo(Comun o) {
		if(salario > o.getSalario())
			return 1;
		if(salario < o.getSalario())
			return -1;
		return 0;
	}
	
}
