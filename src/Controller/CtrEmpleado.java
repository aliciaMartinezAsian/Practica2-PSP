package Controller;

import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
import java.util.ArrayList;

import Model.Empleado;
import View.FrmEmpleado;

public class CtrEmpleado {

	//Tendrá los atributos: inicial (al primer empleado) y actual (al empleado a mostrar)
	
	 private static ArrayList<Empleado> empleados;
	 private int indiceActual;
	 private FrmEmpleado framePrincipal;
	 
	 
	    public CtrEmpleado(FrmEmpleado framePrincipal) {
	    	
	    	//Asocio la ventana principal para acceder a los botones desde el ctrll
	    	this.framePrincipal=framePrincipal;
	        empleados = new ArrayList<>();
	        indiceActual = 0;
	        
	        try {
	        	if(this.empleados.isEmpty()) {
	        		// Precargamos 5 empleados
	    	        empleados.add(new Empleado("Juan", 3000.00, 5000.00, LocalDate.of(1990, 5, 15)));
	                empleados.add(new Empleado("María", 3500.00, 6000.00, LocalDate.of(1985, 8, 20)));
	                empleados.add(new Empleado("Pedro", 4000.00, 7000.00, LocalDate.of(1992, 11, 30)));
	                empleados.add(new Empleado("Ana", 2800.00, 4500.00, LocalDate.of(1995, 3, 10)));
	                empleados.add(new Empleado("Luis", 3200.00, 5500.00, LocalDate.of(1988, 6, 25)));
	        	}
	        
	        }catch(Exception e) {
	        	System.err.println(e.getMessage());
	        }
	    }

	    public void reiniciarPosicionamiento() {
	    	this.indiceActual=0;
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
	         // Posiciona en el nuevo empleado
	    }

	    public boolean estamosAlFinal() {
	        return indiceActual == empleados.size(); // Indica si estamos en un "nuevo" registro
	    }

		public void mostrarEmpleadoActual() {

			// Mostrar el empleado actual
			Empleado empleado = getEmpleadoActual();
			framePrincipal.setEmpleadoData(empleado.getNombre(), empleado.getFechaNacimiento(), empleado.getSueldo(),empleado.getSueldoMax());
			framePrincipal.setAltaVisible(false);

			// Desactivar/activar botones según la posición
			framePrincipal.setAnteriorEnabled(!esPrimerEmpleado());
			framePrincipal.setSiguienteEnabled(!esUltimoEmpleado());
		}

}