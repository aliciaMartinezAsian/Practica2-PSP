package Model;

import java.util.Date;

public class Empleado {
	
	private String nombre;
	private String fechaNacimiento;
	private Double salario;
	
	public Empleado(String nombre, String string, Double salario) {
		super();
		setNombre(nombre);
		setFechaNacimiento(string);
		setSalario(salario);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	

}
