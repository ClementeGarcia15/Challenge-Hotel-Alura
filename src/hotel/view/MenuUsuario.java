package hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import hotel.cerrarsesion.CierreDeSesion;
import hotel.intermediarioUser.InterUser;


public class MenuUsuario extends JFrame {

	private static final long serialVersionUID = 6653300576635638740L;

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExitRes;
	private JLabel labelRegistro;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario menuUsuario = new MenuUsuario();
					menuUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MenuUsuario() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setAlignmentY(0.0f);
		contentPane.setAlignmentX(0.0f);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

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

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 192));
		panelMenu.setBounds(600, 37, 200, 563);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(26, 55, 150, 150);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));

		JPanel btnRegistro = new JPanel();
		btnRegistro.setBorder(null);
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(0, 128, 192));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 200, 60);
		btnRegistro.setBackground(new Color(0, 128, 192));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);

		labelRegistro = new JLabel("Registro de reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegistro.setForeground(SystemColor.text);
		labelRegistro.setBounds(0, 11, 200, 50);
		labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegistro.add(labelRegistro);

		JPanel btnBusqueda = new JPanel();
		btnBusqueda.setBorder(null);
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(0, 128, 192));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setBounds(0, 314, 200, 60);
		btnBusqueda.setBackground(new Color(0, 128, 192));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);

		JLabel lblBusquedaDeReservas = new JLabel("Búsqueda");
		lblBusquedaDeReservas.setBounds(43, 11, 120, 40);
		btnBusqueda.add(lblBusquedaDeReservas);
		lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusquedaDeReservas.setForeground(Color.WHITE);
		lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));

		JSeparator separator = new JSeparator();
		separator.setAlignmentY(0.0f);
		separator.setAlignmentX(0.0f);
		separator.setBounds(0, 220, 200, 3);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 800, 36);
		contentPane.add(header);

		JPanel btnexitRes = new JPanel();
		btnexitRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnexitRes.setBackground(Color.red);
				labelExitRes.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnexitRes.setBackground(Color.white);
				labelExitRes.setForeground(Color.black);
			}
		});

		btnexitRes.setLayout(null);
		btnexitRes.setBackground(Color.WHITE);
		btnexitRes.setBounds(747, 0, 53, 36);
		header.add(btnexitRes);

		labelExitRes = new JLabel("X");
		labelExitRes.setBounds(0, 0, 53, 36);
		btnexitRes.add(labelExitRes);
		labelExitRes.setHorizontalAlignment(SwingConstants.CENTER);
		labelExitRes.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel lblIconRes = new JLabel("");
		lblIconRes.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		lblIconRes.setBounds(0, 0, 36, 36);
		header.add(lblIconRes);

		JLabel lblTitleRes = new JLabel("Bienvenido ");
		lblTitleRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleRes.setForeground(new Color(0, 128, 255));
		lblTitleRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitleRes.setBounds(40, 0, 183, 36);
		header.add(lblTitleRes);

		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(0, 128, 255));
		panelFecha.setBounds(0, 37, 600, 100);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
		lblNewLabel_1.setBounds(142, 0, 356, 53);
		panelFecha.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));

		JLabel labelFecha = new JLabel("New label");
		labelFecha.setBackground(new Color(0, 128, 255));
		labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		labelFecha.setBounds(152, 53, 300, 36);
		panelFecha.add(labelFecha);
		labelFecha.setForeground(new Color(255, 255, 255));
		labelFecha.setFont(new Font("Dialog", Font.PLAIN, 24));
		Date fechaActual = new Date(); // fecha y hora actual
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); // formatear la fecha en una cadena
		labelFecha.setText("Hoy es " + fecha); // setear la representacion en cadena de la fecha

		JLabel lblBienvenida = new JLabel("Bienvenido ");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Roboto", Font.BOLD, 24));
		lblBienvenida.setBounds(27, 158, 283, 46);
		contentPane.add(lblBienvenida);

		String textoDescripcion = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
		JLabel labelDescripcion = new JLabel(textoDescripcion);
		labelDescripcion.setFont(new Font("Roboto", Font.PLAIN, 17));

		labelDescripcion.setBounds(27, 197, 563, 66);
		contentPane.add(labelDescripcion);

		String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
		JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
		labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		labelDescripcion_1.setBounds(30, 260, 570, 88);
		contentPane.add(labelDescripcion_1);

		JLabel lblNewLabel_3 = new JLabel("- Registro de Reservas y Huéspedes");
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(30, 340, 280, 30);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("- Edición de Reservas y Huéspedes existentes");
		lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(30, 370, 340, 30);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros");
		lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(30, 400, 240, 30);
		contentPane.add(lblNewLabel_3_2);

		JButton btnExitRes = new JButton("");
		btnExitRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Object[] opciones = { "Aceptar", "Cancelar" };
				int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Deseas Cerrar sesion?", "Mensaje Confirmar",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
				if (eleccion == JOptionPane.YES_OPTION) {
					dispose();
					CierreDeSesion cerrarsesion = new CierreDeSesion();
					cerrarsesion.setVisible(true);

				}
			}
		});

		btnExitRes.setHorizontalAlignment(SwingConstants.CENTER);
		btnExitRes.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnExitRes.setBounds(10, 539, 50, 50);
		contentPane.add(btnExitRes);
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
