package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Empleado;

public class PanelAlta extends JPanel {
    private JTextField nombreField, puestoField, salarioField;

    public PanelAlta() {
        setLayout(new GridLayout(5, 2));
        
        add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        add(nombreField);
        
        add(new JLabel("Puesto:"));
        puestoField = new JTextField(20);
        add(puestoField);
        
        add(new JLabel("Salario:"));
        salarioField = new JTextField(20);
        add(salarioField);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> agregarEmpleado());
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> limpiarCampos());
        
        add(btnAceptar);
        add(btnCancelar);
    }

    private void agregarEmpleado() {
        String nombre = nombreField.getText();
        String puesto = puestoField.getText();
        double salario = Double.parseDouble(salarioField.getText());
//        Empleado nuevoEmpleado = new Empleado(nombre, salario);
//        FrmPanelVer.agregarEmpleado(nuevoEmpleado); // Necesita agregar el empleado al PanelVer
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreField.setText("");
        puestoField.setText("");
        salarioField.setText("");
    }
}