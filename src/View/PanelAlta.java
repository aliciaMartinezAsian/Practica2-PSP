package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CtrEmpleado;
import Model.Empleado;
import Model.FechaNacimientoInvalidaException;
import Model.SuledoInvalidoException;
import Model.SuledoMaximoInvalidoException;

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
        nombreField.setBounds(80,30,100,20);
       
        JLabel fecha = new JLabel("Fecha de nacimiento:");
        fechaField = new JTextField(20);
        
        add(fecha);
        add(fechaField);
        
        fecha.setBounds(200,28,150,20);
        fechaField.setBounds(320,28,80,20);
        
        JLabel sueldo = new JLabel("Sueldo:");
        sueldoField = new JTextField(20);
        
        add(sueldoField);
        add(sueldo);
        
        sueldo.setBounds(28,60,80,20);
        sueldoField.setBounds(70,60,100,20);
        
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
        btnCancelar.setBounds(220,125,75,27);
        
        
        initListeners();
        
  
    }

    private void initListeners() {
    	btnGuardar.addActionListener(e -> agregarEmpleado());
    	btnCancelar.addActionListener(e -> limpiarCampos());
	}

	private void agregarEmpleado() {
        String nombre = nombreField.getText();
        String strSueldo = sueldoField.getText();
        Integer sueldo = Integer.parseInt(strSueldo);
        String strSueldoMax = sueldoMaxField.getText();
        Integer sueldoMax = Integer.parseInt(strSueldoMax);
        String strFecha = fechaField.getText();
        
        // Formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Conversión de String a LocalDate
        LocalDate fecha = LocalDate.parse(strFecha, formatter);
        
        CtrEmpleado ctr = new CtrEmpleado();
        Empleado nuevoEmpleado;
		try {
			nuevoEmpleado = new Empleado(nombre, sueldo, sueldoMax, fecha);
			ctr.agregarEmpleado(nuevoEmpleado);
		} catch (SuledoMaximoInvalidoException e) {
			System.err.println("Sueldo máximo no válido");
			System.out.println(e.getMessage());
		} catch (SuledoInvalidoException e1) {
			System.err.println("Sueldo no válido");
			System.out.println(e1.getMessage());
		} catch (FechaNacimientoInvalidaException e2) {
			System.err.println("Sueldo máximo no válido");
			System.out.println(e2.getMessage());
		}
        
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreField.setText("");
        sueldoField.setText("");
        sueldoMaxField.setText("");
        fechaField.setText("");
    }
}