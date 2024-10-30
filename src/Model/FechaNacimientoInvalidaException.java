package Model;

public class FechaNacimientoInvalidaException extends Exception {
	
	final static String mensaje="La fecha de nacimiento debe estrar entre el 01/01/1900 y el 31/12/2015";
	
	public FechaNacimientoInvalidaException() {
		super(mensaje);
	}


}
