package hotel.cerrarsesion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import hotel.view.Login;

public class CerrandoApp extends JFrame {

	private static final long serialVersionUID = 6873884536023310623L;
	private Timer timer;
	public CerrandoApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(new Color(0, 128, 192));
		setUndecorated(true);
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel Title = new JLabel("ESPERE...");
		Title.setForeground(new Color(255, 255, 255));
		Title.setFont(new Font("Tahoma", Font.BOLD, 28));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(200, 100, 400, 50);
		getContentPane().add(Title);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CerrandoApp.class.getResource("/imagenes/Loading.gif")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 152, 400, 294);
		getContentPane().add(lblNewLabel_1);

		JPanel header = new JPanel();
		header.setBackground(new Color(0, 128, 192));
		header.setBounds(0, 0, 800, 40);
		getContentPane().add(header);
		header.setLayout(null);

		JLabel BtnExit = new JLabel("");
		BtnExit.setIcon(new ImageIcon(CerrandoApp.class.getResource("/imagenes/disquete.png")));
		BtnExit.setForeground(new Color(255, 255, 255));
		BtnExit.setBackground(new Color(255, 255, 255));
		BtnExit.setHorizontalAlignment(SwingConstants.CENTER);
		BtnExit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		BtnExit.setBounds(0, 0, 50, 40);
		header.add(BtnExit);

		JLabel lblNewLabel_2 = new JLabel("CERRANDO APLICACION");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(48, 0, 207, 40);
		header.add(lblNewLabel_2);

		// Creamos un timer para simular el proceso de cierre de sesión
		timer = new Timer(35, new ActionListener() {
			int i = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				
				if(i == 100) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "DESCONECTADO");
					dispose();
				}else if (i == 95){
					Title.setText("LISTO");
					Title.setForeground(Color.GREEN);
				}else if(i == 80) {
					Title.setText("APAGANDO SERVICIO");
					Title.setForeground(Color.YELLOW);
				}else if(i == 50) {
					Title.setText("VERIFICANDO CIERRE...");
					Title.setForeground(Color.YELLOW);
				}else if(i == 20) {
					Title.setText("CERRANDO CONEXION...");
					Title.setBounds(90,100,600,50);
					Title.setForeground(Color.RED);
					
				}
			}
		});

		// Iniciamos el timer
		timer.start();
	}
}
