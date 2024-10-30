package View;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Empleado;

public class FrmPanelVer extends JPanel {
    private ArrayList<Empleado> empleados;
    private int indiceActual = 0;
    
    private JTextField nombreField, puestoField, salarioField;
    
    public FrmPanelVer() {
        empleados = new ArrayList<>();
        setLayout(new GridLayout(4, 2));
        
        add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        add(nombreField);
        
        add(new JLabel("Puesto:"));
        puestoField = new JTextField(20);
        add(puestoField);
        
        add(new JLabel("Salario:"));
        salarioField = new JTextField(20);
        add(salarioField);

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
//            salarioField.setText(String.valueOf(empleado.getSalario()));
            indiceActual = indice;
        }
    }
}
