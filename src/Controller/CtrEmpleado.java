package Controller;

import java.util.ArrayList;

import Model.Empleado;
import View.FrmEmpleado;

public class CtrEmpleado {

	//Tendrá los atributos: inicial (al primer empleado) y actual (al empleado a mostrar)
	
	 private ArrayList<Empleado> empleados;
	 private int indiceActual;
	 private FrmEmpleado framePrincipal;
	    public CtrEmpleado(FrmEmpleado framePrincipal) {
	    	
	    	//Asocio la ventana principal para acceder a los botones desde el ctrll
	    	this.framePrincipal=framePrincipal;
	        empleados = new ArrayList<>();
	        indiceActual = 0;
	        
	        // Precargamos 5 empleados
	        empleados.add(new Empleado("Juan Pérez", "1990-01-15", 30000.0));
	        empleados.add(new Empleado("María López", "1985-05-10", 32000.0));
	        empleados.add(new Empleado("Carlos García", "1978-12-22", 28000.0));
	        empleados.add(new Empleado("Ana Fernández", "1993-03-03", 35000.0));
	        empleados.add(new Empleado("Luis Sánchez", "2000-11-01", 25000.0));

	    }

	    public Empleado getEmpleadoActual() {
	        return empleados.get(indiceActual);
	    }

	    public void siguienteEmpleado() {
	        if (indiceActual < empleados.size()) {
	            indiceActual++;
	        }
	    }

	    public void anteriorEmpleado() {
	        if (indiceActual > 0) {
	            indiceActual--;
	        }
	    }

	    public boolean esUltimoEmpleado() {
	        return indiceActual == empleados.size();
	    }

	    public boolean esPrimerEmpleado() {
	        return indiceActual == 0;
	    }

	    public void agregarEmpleado(Empleado empleado) {
	        empleados.add(empleado);
	        indiceActual = empleados.size(); // Posiciona en el nuevo empleado
	    }

	    public boolean hayCampoNuevo() {
	        return indiceActual == empleados.size(); // Indica si estamos en un "nuevo" registro
	    }

		public void mostrarEmpleadoActual() {
			
			if (hayCampoNuevo()) {
				// Estamos en un nuevo registro
				framePrincipal.setEmpleadoData("", "", 0);
				framePrincipal.setAltaVisible(true);
			} else {
				// Mostrar el empleado actual
				Empleado empleado = getEmpleadoActual();
				framePrincipal.setEmpleadoData(empleado.getNombre(), empleado.getFechaNacimiento(), empleado.getSalario());
				framePrincipal.setAltaVisible(false);
			}

			// Desactivar/activar botones según la posición
			framePrincipal.setAnteriorEnabled(!esPrimerEmpleado());
			framePrincipal.setSiguienteEnabled(!esUltimoEmpleado());
		}

}