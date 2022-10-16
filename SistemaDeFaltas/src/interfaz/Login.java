package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import configuration.Conexion;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login{

	private JFrame frmAgendaDocente;
	private JTextField textField_Login;
	private JTextField passwordField_Password;
	Conexion conexion=new Conexion();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDocente = new JFrame();
		frmAgendaDocente.setTitle("Agenda docente");
		frmAgendaDocente.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imgs/botonLogin1.png")));
		frmAgendaDocente.getContentPane().setBackground(Color.WHITE);
		frmAgendaDocente.setResizable(false);
		frmAgendaDocente.setBounds(100, 100, 772, 597);
		frmAgendaDocente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgendaDocente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(514, 0, 242, 558);
		frmAgendaDocente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel background_Right = new JLabel("");
		background_Right.setIcon(new ImageIcon(Login.class.getResource("/imgs/logoDerechaLogin.jpg")));
		background_Right.setBounds(0, 0, 242, 558);
		panel.add(background_Right);
		
		textField_Login = new JTextField();
		textField_Login.setBorder(null);
		textField_Login.setOpaque(false);
		textField_Login.setBounds(141, 189, 322, 33);
		frmAgendaDocente.getContentPane().add(textField_Login);
		textField_Login.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(141, 220, 322, 2);
		frmAgendaDocente.getContentPane().add(separator);
		
		JLabel prettyTextField_1 = new JLabel("New label");
		prettyTextField_1.setIcon(new ImageIcon(Login.class.getResource("/imgs/textFieldDecoration.png")));
		prettyTextField_1.setBounds(141, 189, 322, 33);
		frmAgendaDocente.getContentPane().add(prettyTextField_1);
		
		passwordField_Password = new JTextField();
		passwordField_Password.setOpaque(false);
		passwordField_Password.setColumns(10);
		passwordField_Password.setBorder(null);
		passwordField_Password.setBounds(141, 308, 322, 33);
		frmAgendaDocente.getContentPane().add(passwordField_Password);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(141, 339, 322, 2);
		frmAgendaDocente.getContentPane().add(separator_1);
		
		JLabel prettyTextField_2 = new JLabel("New label");
		prettyTextField_2.setIcon(new ImageIcon(Login.class.getResource("/imgs/textFieldDecoration.png")));
		prettyTextField_2.setBounds(141, 308, 322, 33);
		frmAgendaDocente.getContentPane().add(prettyTextField_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imgs/logoLogin.png")));
		lblNewLabel.setBounds(233, 29, 141, 133);
		frmAgendaDocente.getContentPane().add(lblNewLabel);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				conexion.setUser(textField_Login.getText());
				conexion.setPassword(passwordField_Password.getText());
				if(conexion.consulta()==true) {
					
				}else {
					JOptionPane.showMessageDialog(null,"User or password wrong","Hey!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnLogin.setIcon(new ImageIcon(Login.class.getResource("/imgs/botonLogin2.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnLogin.setIcon(new ImageIcon(Login.class.getResource("/imgs/botonLogin1.png")));
			}
		});
		
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/imgs/botonLogin1.png")));
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setOpaque(false);
		btnLogin.setBounds(233, 368, 141, 133);
		frmAgendaDocente.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1.setFont(new Font("Liberation Mono", Font.BOLD, 19));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(41, 189, 90, 33);
		frmAgendaDocente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1.setFont(new Font("Liberation Mono", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(41, 308, 90, 33);
		frmAgendaDocente.getContentPane().add(lblNewLabel_1_1);
		
	}
	
	
	
}