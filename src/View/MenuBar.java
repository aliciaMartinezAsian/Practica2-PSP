package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
    public MenuBar(FrmPrincipal frm) {
        
        JMenuItem verItem = new JMenuItem("Ver Empleados");
        verItem.addActionListener(e -> frm.showPanelVer());
        
        
        JMenuItem altaItem = new JMenuItem("Alta Empleado");
        altaItem.addActionListener(e -> frm.showPanelAlta());
        
        JMenuItem acercaDeItem = new JMenuItem("Acerca de");
        acercaDeItem.addActionListener(e -> frm.showPanelAcercaDe());

        add(verItem);
        add(altaItem);
        add(acercaDeItem);
        
    }
}
