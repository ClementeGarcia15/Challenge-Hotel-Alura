package hotel.cerrarsesion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.border.EmptyBorder;

import hotel.intermediarioUser.InterUser;
import hotel.view.Login;
import hotel.view.MenuPrincipal;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.ComponentOrientation;

public class RegistroUsuario extends JFrame {
	
	//Intermediario sive para almacenar el 
	//nombre de usuario que se va a registrar
	private InterUser interuser;

	private static final long serialVersionUID = -8189051881882230619L;
	private JPanel contentPane;
	public JTextField txtUsuario;
	private JPasswordField txtContrasena;
	int xMouse, yMouse;
	private JButton btnExit;
	private PreparedStatement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuario frame = new RegistroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroUsuario() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		// crea instancia de intermediario
		interuser = new InterUser();
		

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(500, 40, 300, 560);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblutilizaUnaContrasea = new JLabel();
		lblutilizaUnaContrasea.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/img-hotel-login-.png")));
		lblutilizaUnaContrasea.setBackground(new Color(0, 128, 255));
		lblutilizaUnaContrasea.setForeground(new Color(255, 255, 255));
		lblutilizaUnaContrasea.setVerticalAlignment(SwingConstants.TOP);
		lblutilizaUnaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblutilizaUnaContrasea.setBounds(10, 11, 280, 538);
		panel_1.add(lblutilizaUnaContrasea);

		btnExit = new JButton("X");
		btnExit.setAlignmentY(0.0f);
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				btnExit.setForeground(Color.WHITE);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(255, 255, 255));
				btnExit.setForeground(Color.BLACK);
			}
		});
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(747, 0, 53, 40);
		header.add(btnExit);
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTITLE = new JLabel("REGISTRO DE USUARIO");
		lblTITLE.setHorizontalAlignment(SwingConstants.CENTER);
		lblTITLE.setForeground(new Color(0, 128, 255));
		lblTITLE.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTITLE.setBounds(54, 1, 260, 40);
		header.add(lblTITLE);

		JLabel lblIMG_1_1 = new JLabel("");
		lblIMG_1_1.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/login.png")));
		lblIMG_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG_1_1.setBounds(0, 0, 53, 40);
		header.add(lblIMG_1_1);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(75, 176, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(75, 219, 324, 2);
		panel.add(separator);

		JLabel labelTitulo = new JLabel("REGISTRO USUARIO");
		labelTitulo.setForeground(SystemColor.textHighlight);
		labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		labelTitulo.setBounds(65, 93, 260, 26);
		panel.add(labelTitulo);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(75, 294, 324, 2);
		panel.add(separator_1);

		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(SystemColor.activeCaptionBorder);
		txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtContrasena.setBounds(75, 251, 324, 32);
		panel.add(txtContrasena);

		JLabel LabelUsuario = new JLabel("USUARIO");
		LabelUsuario.setForeground(SystemColor.textInactiveText);
		LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		LabelUsuario.setBounds(73, 155, 107, 26);
		panel.add(LabelUsuario);

		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		lblContrasea.setForeground(SystemColor.textInactiveText);
		lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblContrasea.setBounds(75, 226, 140, 26);
		panel.add(lblContrasea);

		JButton btnREGISTRO = new JButton("REGISTRAR USUARIO");
		btnREGISTRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;

				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_alura", "root",
							"Alura1234");
				} catch (SQLException e1) {
					System.out.println("Error al conectar a la base de datos: " + e1.getMessage());
					System.exit(0);
				}

				try {
					String user = txtUsuario.getText();
					String pass = new String(txtContrasena.getPassword());
					String sql = "SELECT * FROM users WHERE user = ?";
					// se almacena en la clase instanceada
					interuser.setUser(user);
					
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, user);
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {// Si el resultado de la consulta no está vacío, significa que el usuario ya
						// existe
						JOptionPane.showMessageDialog(btnREGISTRO,
								"El usuario ya existe. Por favor, elige otro nombre de usuario.");
					} else if (!user.isEmpty() && !pass.isEmpty()) {

						sql = "INSERT INTO users (user, pass) VALUES (?, ?)";
						stmt = conn.prepareStatement(sql);

						stmt.setString(1, user);
						stmt.setString(2, pass);

						int rowsInserted = stmt.executeUpdate();
						if (rowsInserted > 0) {
							
							// se envia a otro JFrame 
							CreandoUsuario UserReg = new CreandoUsuario(interuser);
							UserReg.setVisible(true);
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(btnREGISTRO,
								"Se requiere un usuario y contraseña para el registro");
					}

				} catch (SQLException e1) {
					System.out.println("Error al agregar un nuevo usuario: " + e1.getMessage());
					e1.printStackTrace();
				} catch (Exception e2) {
					System.out.println("Ocurrió un error: " + e2.getMessage());
					e2.printStackTrace();
				}

				// Cerrar la conexión
				try {
					if (conn != null || stmt != null) {
						stmt.close();
						conn.close();
					}
				} catch (SQLException e1) {
					System.out.println("Error al cerrar la conexión: " + e1.getMessage());
				}

			}
		});
		btnREGISTRO.setBackground(new Color(0, 128, 255));
		btnREGISTRO.setBounds(100, 360, 270, 50);
		panel.add(btnREGISTRO);
		btnREGISTRO.setForeground(new Color(255, 255, 255));
		btnREGISTRO.setHorizontalAlignment(SwingConstants.CENTER);
		btnREGISTRO.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel IconPass = new JLabel("");
		IconPass.setHorizontalAlignment(SwingConstants.CENTER);
		IconPass.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/icon_password.png")));
		IconPass.setBounds(10, 251, 30, 40);
		panel.add(IconPass);

		JLabel lblIMG_1 = new JLabel("");
		lblIMG_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMG_1.setBounds(0, 176, 49, 40);
		panel.add(lblIMG_1);
		lblIMG_1.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/login.png")));
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
