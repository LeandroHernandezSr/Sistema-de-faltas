package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;


import configuration.Conexion;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class Menu{

	private JFrame frmAgendaDocente;
	Conexion conexion=new Conexion();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmAgendaDocente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDocente = new JFrame();
		frmAgendaDocente.setTitle("Agenda docente");
		frmAgendaDocente.getContentPane().setBackground(Color.WHITE);
		frmAgendaDocente.setResizable(false);
		frmAgendaDocente.setBounds(100, 100, 772, 597);
		frmAgendaDocente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaDocente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 756, 558);
		frmAgendaDocente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBounds(0, 0, 756, 558);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		tabbedPane.setBackground(Color.BLUE);
		panel.add(tabbedPane);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Registro de falta", new ImageIcon(Menu.class.getResource("/imgs/21.png")), panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		tabbedPane.addTab("New tab", null, panel_2, null);
		
	}
}