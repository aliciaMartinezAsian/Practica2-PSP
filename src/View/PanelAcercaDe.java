package View;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelAcercaDe extends JPanel {
	private static final long serialVersionUID = 1L;

	public PanelAcercaDe() {
        setLayout(new BorderLayout());
        JTextArea infoArea = new JTextArea("Aplicación de Gestión de Empleados.\nAutores: José Luis y Alicia\nFecha: 2024");
        infoArea.setEditable(false);
        add(infoArea, BorderLayout.CENTER);
    }
}
