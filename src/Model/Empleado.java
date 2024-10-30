package Model;

import java.time.LocalDate;
import java.util.Date;

public class Empleado {
	/*- Número de empleado: generado por el sistema de forma creciente desde
	- Fecha de nacimiento, de tipo GregorianCalendar.
	- Sueldo de tipo real.
	- Sueldo máximo, de tipo real.
	- Otro de libre elección.*/

	private static int contadorEmpleados = 0; // Contador de empleados
	private int numeroEmpleado; // Número de empleado
	private double sueldo;
	private double sueldoMax;
	private String nombre;
	private LocalDate fechaNacimiento;

	public Empleado(String nombre, double sueldo, double sueldoMax, LocalDate fechaNacimiento) {

		contadorEmpleados++; // Incrementar el contador
		this.numeroEmpleado = contadorEmpleados; // Asignar el número de empleado

		setSueldoMax(sueldoMax);
		setSueldo(sueldo);
		setNombre(nombre);

	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		LocalDate fechaMax = LocalDate.of(2015, 12, 31);
		LocalDate fechaMin = LocalDate.of(1900, 01, 01);

		if (fechaNacimiento.compareTo(fechaMin) >= 0 && fechaNacimiento.compareTo(fechaMax) <= 0) {
			this.fechaNacimiento = fechaNacimiento;
		} else {
			if (fechaNacimiento.compareTo(fechaMin) < 0) {
				this.fechaNacimiento = fechaMin;
			} else {
				if (fechaNacimiento.compareTo(fechaMax) > 0) {
					this.fechaNacimiento = fechaMax;
				}
			}
		}

	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {

		if (this.sueldoMax < sueldo)
			this.sueldo = this.sueldoMax;
		else {
			if (sueldo < 0)
				this.sueldo = -sueldo;
			else
				this.sueldo = sueldo;
		}

	}

	public double getSueldoMax() {
		return sueldoMax;
	}

	public void setSueldoMax(double sueldoMax) {
		if (sueldoMax < 0)
			this.sueldoMax = -sueldoMax;
		else
			this.sueldoMax = sueldoMax;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Empleado [numeroEmpleado=" + numeroEmpleado + ", sueldo=" + sueldo + ", sueldoMax=" + sueldoMax
				+ ", nombre=" + nombre + "]";
	}

}