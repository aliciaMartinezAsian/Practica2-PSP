package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {
    
    public PanelVer panelVer;
    public PanelAlta panelAlta;
    public PanelAcercaDe panelAcercaDe;
    private MenuBar menuBar;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public FrmPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);
        
        setTitle("Gestión de Empleados");
        setSize(500, 300);
        
        menuBar = new MenuBar();
        setJMenuBar(menuBar);

       
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout()); // Añadir BorderLayout aquí para la correcta visualización
        setContentPane(contentPane); // Importante: establecer el contentPane en el JFrame

        // Inicializar paneles
        panelVer = new PanelVer();
        panelAlta = new PanelAlta();
        panelAcercaDe = new PanelAcercaDe();
        
        // Añadir el primer panel por defecto
        contentPane.add(panelVer, BorderLayout.CENTER);
        
        initListeners();
        
        setVisible(true);
    }

    private void initListeners() {
        menuBar.verItem.addActionListener(e -> showPanel(panelVer));
        menuBar.altaItem.addActionListener(e -> showPanel(panelAlta));
        menuBar.acercaDeItem.addActionListener(e -> showPanel(panelAcercaDe));
    }

    private void showPanel(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
    }
}

