package hotel.cerrarsesion;

import java.awt.Color;
import java.awt.EventQueue;
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

public class CierreDeSesion extends JFrame {

	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CierreDeSesion window = new CierreDeSesion();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CierreDeSesion() {
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
		lblNewLabel_1.setIcon(new ImageIcon(CierreDeSesion.class.getResource("/imagenes/Loading.gif")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 152, 400, 294);
		getContentPane().add(lblNewLabel_1);

		JPanel header = new JPanel();
		header.setBackground(new Color(0, 128, 192));
		header.setBounds(0, 0, 800, 40);
		getContentPane().add(header);
		header.setLayout(null);

		JLabel BtnExit = new JLabel("");
		BtnExit.setIcon(new ImageIcon(CierreDeSesion.class.getResource("/imagenes/disquete.png")));
		BtnExit.setForeground(new Color(255, 255, 255));
		BtnExit.setBackground(new Color(255, 255, 255));
		BtnExit.setHorizontalAlignment(SwingConstants.CENTER);
		BtnExit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		BtnExit.setBounds(0, 0, 50, 40);
		header.add(BtnExit);

		JLabel lblNewLabel_2 = new JLabel("CERRANDO SESION");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(48, 0, 170, 40);
		header.add(lblNewLabel_2);

		// Creamos un timer para simular el proceso de cierre de sesión
		timer = new Timer(35, new ActionListener() {
			int i = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				
				if(i == 100) {
					timer.stop();
					dispose();
					JOptionPane.showMessageDialog(null, "SESION CERRADA");
					Login login = new Login();
					login.setVisible(true);
					
				}else if (i == 95){
					Title.setText("LISTO");
					Title.setForeground(Color.GREEN);
				}
					
			}
		});

		// Iniciamos el timer
		timer.start();
	}
}
