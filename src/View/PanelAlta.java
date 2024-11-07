package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CtrEmpleado;
import Model.Empleado;
import Model.FechaNacimientoInvalidaException;
import Model.SueldoInvalidoException;
import Model.SueldoMaximoInvalidoException;

public class PanelAlta extends JPanel {
    private JButton btnGuardar, btnCancelar;
    
    private JTextField nombreField, sueldoField, sueldoMaxField, fechaField;

    public PanelAlta() {
        setLayout(null);
        
        JLabel nombre = new JLabel("Nombre:");
        nombreField = new JTextField(20);
        
        add(nombreField);
        add(nombre);
        
        nombre.setBounds(28,30,50,20);
        nombreField.setBounds(85,30,100,20);
       
        JLabel fecha = new JLabel("Fecha de nacimiento:");
        fechaField = new JTextField(20);
        
 
        
        add(fecha);
        add(fechaField);
        
        fecha.setBounds(200,28,150,20);
        fechaField.setBounds(330,28,80,20);
        
        JLabel sueldo = new JLabel("Sueldo:");
        sueldoField = new JTextField(20);
        
        add(sueldoField);
        add(sueldo);
        
        sueldo.setBounds(28,60,80,20);
        sueldoField.setBounds(80,60,100,20);
        
        JLabel sueldoMax = new JLabel("Sueldo máximo:");
        sueldoMaxField = new JTextField(20);
        
        add(sueldoMax);
        add(sueldoMaxField);
        
        sueldoMax.setBounds(200,60,100,20);
        sueldoMaxField.setBounds(300,60,100,20);

        btnGuardar = new JButton("Guardar");
        
        btnCancelar = new JButton("Cancelar");
             
        add(btnGuardar);
        add(btnCancelar);
        
        btnGuardar.setBounds(120,125,85,27);
        btnCancelar.setBounds(220,125,85,27);
        
        
        initListeners();
        
  
    }

    private void initListeners() {
    	btnGuardar.addActionListener(e -> agregarEmpleado());
    	btnCancelar.addActionListener(e -> limpiarCampos());
	}

	private void agregarEmpleado() {
        String nombre = nombreField.getText();
        String strSueldo = sueldoField.getText();
        String strSueldoMax = sueldoMaxField.getText();
        String strFecha = fechaField.getText();
        
        // Formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Hacemos los parse dentro del trycatch para gestionar los errores
        try {
	        LocalDate fecha;
	        try {
	        	fecha = LocalDate.parse(strFecha, formatter);
	        }catch(Exception e) {
	        	throw new FechaNacimientoInvalidaException();
	        }
	        
	        Integer sueldo;
	        try{
	        	sueldo = Integer.parseInt(strSueldo);
	        }catch(Exception e) {
	        	throw new SueldoInvalidoException();
	        }
	        Integer sueldoMax;
	        try{
	        	sueldoMax = Integer.parseInt(strSueldo);
	        }catch(Exception e) {
	        	throw new SueldoMaximoInvalidoException();
	        }
        

        Empleado nuevoEmpleado;
		
			nuevoEmpleado = new Empleado(nombre, sueldo, sueldoMax, fecha);
			CtrEmpleado.agregarEmpleado(nuevoEmpleado);
		} catch (SueldoMaximoInvalidoException e) {
			JOptionPane.showMessageDialog(this, "Sueldo Maximo invalido, \ndatos no guardados", "Error", JOptionPane.ERROR_MESSAGE);
			
		} catch (SueldoInvalidoException e1) {
			JOptionPane.showMessageDialog(this, "Sueldo invalido, \ndatos no guardados", "Error", JOptionPane.ERROR_MESSAGE);
			
		} catch (FechaNacimientoInvalidaException e2) {
			JOptionPane.showMessageDialog(this, "Fecha de nacimiento invalida, \ndatos no guardados", "Error", JOptionPane.ERROR_MESSAGE);
			
		}finally {
			limpiarCampos();
		}

    }

    private void limpiarCampos() {
        nombreField.setText("");
        sueldoField.setText("");
        sueldoMaxField.setText("");
        fechaField.setText("");
    }
}