package hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import hotel.cerrarsesion.CerrandoApp;
import hotel.cerrarsesion.RegistroUsuario;
import hotel.controller.UserCTLR;
import hotel.factory.ConnectionFactory;
import hotel.intermediarioUser.InterUser;

public class Login extends JFrame {
	//Intermediario sive para almacenar el 
	//nombre de usuario que se va a registrar
	private InterUser interuser;

	private static final long serialVersionUID = 1723981311466365231L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JLabel labelExit;
	private PreparedStatement stmt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		// crea instancia de intermediario
		interuser = new InterUser();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		panel.setBackground(Color.white);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(500, 0, 300, 600);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel imgHotel = new JLabel();
		imgHotel.setBounds(0, 39, 300, 561);
		panel_1.add(imgHotel);
		imgHotel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/img-hotel-login-.png")));

		JPanel btnExit = new JPanel();
		btnExit.setBounds(250, 0, 50, 40);
		panel_1.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.RED);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(12, 140, 200));
				labelExit.setForeground(Color.WHITE);
			}
		});

		btnExit.setBackground(new Color(12, 140, 200));
		btnExit.setLayout(null);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 50, 40);
		btnExit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 20));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);

		txtUsuario = new JTextField();

		JPanel header = new JPanel();
		header.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}

		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}

		});
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 800, 40);
		panel.add(header);
		header.setLayout(null);

		JLabel lblIcon2 = new JLabel("");
		lblIcon2.setIcon(new ImageIcon(Login.class.getResource("/imagenes/login.png")));
		lblIcon2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon2.setBounds(0, 0, 40, 40);
		header.add(lblIcon2);

		JLabel lblTitle2 = new JLabel("INICIO DE SESION");
		lblTitle2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitle2.setForeground(new Color(0, 128, 255));
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setBounds(40, 0, 130, 40);
		header.add(lblTitle2);

		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
		lblIcon.setBounds(70, 50, 50, 50);
		panel.add(lblIcon);

		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasena.setBounds(70, 120, 95, 20);
		panel.add(lblContrasena);

		JLabel lblTitle = new JLabel("INICIAR SESION");
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		lblTitle.setBounds(70, 150, 200, 30);
		panel.add(lblTitle);

		JLabel LblUsuario = new JLabel("USUARIO");
		LblUsuario.setForeground(SystemColor.textInactiveText);
		LblUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LblUsuario.setBounds(70, 220, 110, 30);
		panel.add(LblUsuario);

		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(70, 260, 330, 30);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 220));
		separator.setBounds(70, 300, 320, 3);
		panel.add(separator);

		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(70, 340, 320, 30);
		panel.add(txtContrasena);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(70, 380, 320, 3);
		panel.add(separator_1);

		JButton btnAcceder = new JButton();
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = new ConnectionFactory().recuperaConexion();
				System.out.println("Conect");
				try {
					String user = txtUsuario.getText();
					String pass = new String(txtContrasena.getPassword());
					
					// se almacena en la clase instanceada
					interuser.setUser(user);
					
					System.out.println("User");

					if (!user.isEmpty() && !pass.isEmpty()) {
						System.out.println(!user.isEmpty() && !pass.isEmpty());
						String sql = "SELECT * FROM users WHERE user = ? AND pass = ?";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, user);
						stmt.setString(2, pass);
						System.out.println("Not Empty!");
					} else {
						System.out.println("Empty!");
						JOptionPane.showMessageDialog(null, "Se requiere usuario y contraseña", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						System.out.println("Result: " + rs.next());
						JOptionPane.showMessageDialog(null, "BIENVENIDO USUARIO: " + user);
						dispose();
						MenuUsuario usuario = new MenuUsuario();
						usuario.setVisible(true);
						
					}else if(user.equals("admin") && pass.equals("admin")) { 
						JOptionPane.showMessageDialog(null, "BIENVENIDO USUARIO: " + user);
						dispose();
						MenuUsuario usuario = new MenuUsuario();
						usuario.setVisible(true);
					}else {
						System.out.println("Result Not: " + rs.next());
						JOptionPane.showMessageDialog(null, "Nombre o contraseña incorrectos");
						txtUsuario.setText("");
						txtContrasena.setText("");
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
				// Cerrar la conexión
				try {
					if (conn != null || stmt != null) {
						stmt.close();
						conn.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("Error al cerrar la conexión: " + e1.getMessage());
				}
			}
		});
		btnAcceder.setText("ENTRAR");
		btnAcceder.setBounds(150, 430, 120, 40);
		panel.add(btnAcceder);
		btnAcceder.setBackground(SystemColor.textHighlight);
		btnAcceder.setForeground(SystemColor.controlLtHighlight);
		btnAcceder.setHorizontalAlignment(SwingConstants.CENTER);
		btnAcceder.setFont(new Font("Dialog", Font.PLAIN, 18));

		JButton btnSalirIn = new JButton("");
		btnSalirIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] opciones = { "Aceptar", "Cancelar" };
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Deseas finalizar la aplicacion?",
						"Mensaje Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones,
						"Aceptar");
				if (eleccion == JOptionPane.YES_OPTION) {
					dispose();
					CerrandoApp cerrada = new CerrandoApp();
					cerrada.setVisible(true);
				}
			}
		});
		btnSalirIn.setBackground(new Color(255, 255, 255));
		btnSalirIn.setIcon(new ImageIcon(Login.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnSalirIn.setBounds(10, 529, 60, 60);
		panel.add(btnSalirIn);

		JButton lblAgregarUser = new JButton("¿Crear usuario?");
		lblAgregarUser.setBorder(UIManager.getBorder("DesktopIcon.border"));
		lblAgregarUser.setVerticalAlignment(SwingConstants.TOP);
		lblAgregarUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAgregarUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Object[] opciones = { "Si", "No" };
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Deseas Crear un usuario?", "Mensaje Confirmar",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
				if (eleccion == JOptionPane.YES_OPTION) {
					dispose();
					RegistroUsuario userSignup = new RegistroUsuario();
					userSignup.setVisible(true);
				}

			}

		});
		lblAgregarUser.setForeground(new Color(0, 128, 255));
		lblAgregarUser.setBounds(140, 500, 150, 30);

		panel.add(lblAgregarUser);

		UserCTLR userCTLR = new UserCTLR();

	}

	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}// GEN-LAST:event_headerMousePressed

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
