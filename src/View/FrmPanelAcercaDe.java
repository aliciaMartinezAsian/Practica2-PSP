package View;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FrmPanelAcercaDe extends JPanel {
	private static final long serialVersionUID = 1L;

	public FrmPanelAcercaDe() {
        setLayout(new BorderLayout());
        JTextArea infoArea = new JTextArea("Aplicación de Gestión de Empleados.\nAutor: Tu Nombre\nFecha: 2024");
        infoArea.setEditable(false);
        add(infoArea, BorderLayout.CENTER);
    }
}
