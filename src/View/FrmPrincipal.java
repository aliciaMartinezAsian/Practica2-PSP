package View;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmPrincipal extends JFrame {

	private FrmPanelVer panelVer;
    private FrmPanelAlta panelAlta;
    private FrmPanelAcercaDe panelAcercaDe;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JFrame frame;

	public FrmPrincipal() {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("Gestión de Empleados");
        setSize(500,300);

		setContentPane(contentPane);
		

	        panelVer = new FrmPanelVer();
	        panelAlta = new FrmPanelAlta();
	        panelAcercaDe = new FrmPanelAcercaDe();
	        setJMenuBar();

	       
	        this.setVisible(true);
	}
	public void setJMenuBar() {
		
		JMenuBar menuBar = new MenuBar(this);
		this.add(menuBar);
		
	}
	
	public void showPanelVer() {
        setContentPane(panelVer);
        revalidate();
        repaint();
    }

    public void showPanelAlta() {
        setContentPane(panelAlta);
        revalidate();
        repaint();
    }

    public void showPanelAcercaDe() {
        setContentPane(panelAcercaDe);
        revalidate();
        repaint();
    }

}
