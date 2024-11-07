package Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.Empleado;
import View.FrmPrincipal;

public class CtrEmpleado {

	//Tendrá los atributos: inicial (al primer empleado) y actual (al empleado a mostrar)
	
	 private static ArrayList<Empleado> empleados;
	 private int indiceActual;
	 
	 
	    public CtrEmpleado() {
	    	
	    	//Asocio la ventana principal para acceder a los botones desde el ctrll
	    	
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


	    
	    public Empleado getEmpleadoActual() {
	        return empleados.get(indiceActual);
	    }

	    public static void agregarEmpleado(Empleado empleado) {
	        empleados.add(empleado);
	         
	    }

	    public ArrayList<Empleado> listaEmpleados(){
	    	return empleados;
	    }



}