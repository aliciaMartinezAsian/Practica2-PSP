package View;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Empleado;

public class PanelVer extends JPanel {
    private ArrayList<Empleado> empleados;
    private int indiceActual = 0;
    
    private JTextField nombreField, sueldoField, sueldoMaxField, fechaField;
    
    public PanelVer() {
        empleados = new ArrayList<>();
        setLayout(new GridLayout(5, 2));
        
        add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        add(nombreField);
        
        add(new JLabel("Sueldo:"));
        sueldoField = new JTextField(20);
        add(sueldoField);
        
        add(new JLabel("Sueldo máximo:"));
        sueldoMaxField = new JTextField(20);
        add(sueldoMaxField);
        
        add(new JLabel("Fecha de nacimiento:"));
        fechaField = new JTextField(20);
        add(fechaField);

        JButton btnPrimero = new JButton("Primero");
        btnPrimero.addActionListener(e -> mostrarEmpleado(0));
        JButton btnAnterior = new JButton("Anterior");
        btnAnterior.addActionListener(e -> mostrarEmpleado(indiceActual - 1));
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(e -> mostrarEmpleado(indiceActual + 1));
        JButton btnUltimo = new JButton("Último");
        btnUltimo.addActionListener(e -> mostrarEmpleado(empleados.size() - 1));
        
        add(btnPrimero);
        add(btnAnterior);
        add(btnSiguiente);
        add(btnUltimo);
        
        if (!empleados.isEmpty()) mostrarEmpleado(0);
    }

    public void mostrarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size()) {
            Empleado empleado = empleados.get(indice);
            nombreField.setText(empleado.getNombre());
            sueldoField.setText(String.valueOf(empleado.getSueldo()));
            sueldoMaxField.setText(String.valueOf(empleado.getSueldoMax()));
            fechaField.setText(String.valueOf(empleado.getFechaNacimiento()));
            indiceActual = indice;
        }
    }
}
