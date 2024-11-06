package View;

import javax.swing.JMenuBar; 
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	public JMenuItem verItem;
	public JMenuItem altaItem;
	public JMenuItem acercaDeItem;
	
    public MenuBar() {

        verItem = new JMenuItem("Ver Empleados");
        
        altaItem = new JMenuItem("Alta Empleado");     

        acercaDeItem = new JMenuItem("Acerca de");
       

        add(verItem);
        add(altaItem);
        add(acercaDeItem);
    }
}

