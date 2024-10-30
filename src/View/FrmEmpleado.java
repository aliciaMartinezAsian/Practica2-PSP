package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.CtrEmpleado;
import Model.Empleado;

public class FrmEmpleado extends JFrame {

	private JFrame frame = this;

	private JTextField nombreField, fechaNacimientoField, salarioField;
	private JButton anteriorButton, siguienteButton, altaButton, cancelarButton;

    public FrmEmpleado() {
        // Configuramos la ventana
        setTitle("Gestión de Empleados");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos los paneles intermedios con layouts
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        JPanel panelDatos = new JPanel(new GridLayout(3, 2));
        JPanel panelBotones = new JPanel(new FlowLayout());

        // Campos de texto y etiquetas
        panelDatos.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelDatos.add(nombreField);

        panelDatos.add(new JLabel("Fecha Nacimiento:"));
        fechaNacimientoField = new JTextField();
        panelDatos.add(fechaNacimientoField);

        panelDatos.add(new JLabel("Salario:"));
        salarioField = new JTextField();
        panelDatos.add(salarioField);

        // Botones
        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");
        altaButton = new JButton("Alta");
        cancelarButton = new JButton("Cancelar");
        
        panelBotones.add(anteriorButton);
        panelBotones.add(siguienteButton);
        panelBotones.add(altaButton);
        panelBotones.add(cancelarButton);

        panelPrincipal.add(panelDatos, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        addListeners();
        
        add(panelPrincipal);
        setVisible(true);
    }
    // Getters de los botones
    public JButton getAnteriorButton() {
        return anteriorButton;
    }

    public JButton getSiguienteButton() {
        return siguienteButton;
    }

    public JButton getAltaButton() {
        return altaButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    // Métodos para actualizar los campos de texto
    public void setEmpleadoData(String nombre, double sueldo, double sueldoMax, LocalDate fechaNacimiento) {
        nombreField.setText(nombre);
        fechaNacimientoField.setText(fechaNacimiento.toString());
        salarioField.setText(String.valueOf(sueldo));
    }

    // Métodos para recoger la información de los campos de texto
    public String getNombre() {
        return nombreField.getText();
    }

    public String getFechaNacimiento() {
        return fechaNacimientoField.getText();
    }

    public double getSalario() {
        return Double.parseDouble(salarioField.getText());
    }

    // Métodos para habilitar/deshabilitar botones
    public void setAnteriorEnabled(boolean enabled) {
        anteriorButton.setEnabled(enabled);
    }

    public void setSiguienteEnabled(boolean enabled) {
        siguienteButton.setEnabled(enabled);
    }

    public void setAltaVisible(boolean visible) {
        altaButton.setVisible(visible);
        cancelarButton.setVisible(visible);
    }
    
	public void addListeners() {

		CtrEmpleado ctr = new CtrEmpleado(this);

        // Inicializamos la vista con el primer empleado
        ctr.mostrarEmpleadoActual();

        // Listeners para los botones
        getAnteriorButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctr.anteriorEmpleado();
                ctr.mostrarEmpleadoActual();
            }
        });

        getSiguienteButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctr.siguienteEmpleado();
                ctr.mostrarEmpleadoActual();
            }
        });

        getAltaButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para agregar un nuevo empleado
                String nombre = getNombre();
                String fechaNacimiento = getFechaNacimiento();
                double salario = getSalario();
                ctr.agregarEmpleado(new Empleado(nombre, fechaNacimiento, salario));
                ctr.mostrarEmpleadoActual();
            }
        });

        getCancelarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctr.mostrarEmpleadoActual();
            }
        });
    }

}
