package hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import hotel.controller.HuespedesCTLR;
import hotel.controller.ReservaCTLR;
import hotel.model.HuespedesModel;
import hotel.model.ReservaModel;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private ReservaCTLR reservaCTLR;
	private HuespedesCTLR huespedesCTLR;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	String reserva;
	String huespedes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {

		this.reservaCTLR = new ReservaCTLR();
		this.huespedesCTLR = new HuespedesCTLR();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblTitleFind = new JLabel("SISTEMA DE BÚSQUEDA");
		lblTitleFind.setForeground(new Color(12, 138, 199));
		lblTitleFind.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblTitleFind.setBounds(305, 70, 300, 40);
		contentPane.add(lblTitleFind);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(20, 169, 865, 328);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		LlenarTablaReservas();

		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table,
				null);
		scroll_table.setVisible(true);

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		LlenarTablaHuespedes();

		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

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
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MenuUsuario MenuUser = new MenuUsuario();
				MenuUser.setVisible(true);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
				// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiarTabla();
				if (txtBuscar.getText().equals("")) {
					LlenarTablaHuespedes();
					LlenarTablaReservas();
				} else {
					LlenarTablaReservasId();
					LlenarTablaHuespedesId();
					LlenarTableHuespedesApellido();
				}
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();

				if (filaReservas >= 0) {
					System.out.println("Fila seleccionada Reserva: " + filaReservas);
					ActualizarReservas();
					limpiarTabla();
					LlenarTablaReservas();
					LlenarTablaHuespedes();
				} else if (filaHuespedes >= 0) {
					System.out.println("Fila seleccionada Huesped: " + filaHuespedes);
					ActualizarHuesped();
					limpiarTabla();
					LlenarTablaHuespedes();
					LlenarTablaReservas();
				}
			}
		});
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setLayout(null);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setBounds(767, 508, 122, 35);

		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHuespedes = tbHuespedes.getSelectedRow();
				
				if (filaReservas >= 0 ) {
					try {
						reserva = tbReservas.getValueAt(filaReservas, 0).toString();
					}catch(ArrayIndexOutOfBoundsException ea) {
						new  RuntimeException(ea);
					}
					
					int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?");

					if (confirmar == JOptionPane.YES_OPTION) {

						String valor = tbReservas.getValueAt(filaReservas, 0).toString();
						reservaCTLR.Eliminar(Integer.valueOf(valor));
						System.out.println("Reserva: " + reserva);
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
						limpiarTabla();
						LlenarTablaReservas();
						LlenarTablaHuespedes();
					}
				}
				else if (filaHuespedes >= 0) {

					huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
					int confirmarh = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar los datos?");

					if (confirmarh == JOptionPane.YES_OPTION) {

						String valor = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
						huespedesCTLR.Eliminar(Integer.valueOf(valor));
						System.out.println("Huesped ID: " + valor);
						System.out.println("Huesped: " + huespedes);
						JOptionPane.showMessageDialog(contentPane, "Registro Eliminado");
						limpiarTabla();
						LlenarTablaHuespedes();
						LlenarTablaReservas();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Error fila no seleccionada, por favor realice una busqueda y seleccione una fila para eliminar");
				}
			}
		});

		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

	private List<ReservaModel> BuscarReservas() {
		return this.reservaCTLR.buscar();
	}

	private List<ReservaModel> BuscarReservasId() {
		return this.reservaCTLR.buscarId(txtBuscar.getText());
	}
	
	private List<HuespedesModel> BuscarHuespedeApellido(){
		return this.huespedesCTLR.listarHuespedesApellido(txtBuscar.getText());
	}

	private List<HuespedesModel> BuscarHuespedes() {
		return this.huespedesCTLR.listarHuespedes();
	}

	private List<HuespedesModel> BuscarHuespedesId() {
		return this.huespedesCTLR.listarHuespedesId(txtBuscar.getText());
	}

	private void limpiarTabla() {
		((DefaultTableModel) tbHuespedes.getModel()).setRowCount(0);
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
	}
	
	private boolean tieneFilaElegida() {
		int filaReservas = tbReservas.getSelectedRowCount();
		int filaHuespedes = tbHuespedes.getSelectedRowCount();
		
		boolean Seleccionada = false;
		
		if(filaReservas == 0 || tbReservas.getSelectedColumnCount() ==0 ) {
			Seleccionada = true;
		}else if(filaHuespedes == 0 || tbHuespedes.getSelectedColumnCount() ==0) {
			Seleccionada = true;
		}else {
			Seleccionada = false;
		}
		
		return Seleccionada;
	}

	private void LlenarTablaReservas() {

		// Llenar tabla
		List<ReservaModel> reserva = BuscarReservas();
		try {
			for (ReservaModel reservas : reserva) {
				modelo.addRow(new Object[] { reservas.getId(), reservas.getfechaE(), reservas.getfechaS(),
						reservas.getvalor(), reservas.getformaPago() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void LlenarTablaReservasId() {

		// Llenar tabla
		List<ReservaModel> reserva = BuscarReservasId();
		try {
			for (ReservaModel reservas : reserva) {
				modelo.addRow(new Object[] { reservas.getId(), reservas.getfechaE(), reservas.getfechaS(),
						reservas.getvalor(), reservas.getformaPago() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void LlenarTableHuespedesApellido() {
		List<HuespedesModel> huesped =  BuscarHuespedeApellido();
		try {
			for (HuespedesModel huespedes : huesped) {
				modeloHuesped.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(),
						huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono(),
						huespedes.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void LlenarTablaHuespedes() {
		// Llenar Tabla
		List<HuespedesModel> huesped = BuscarHuespedes();
		try {
			for (HuespedesModel huespedes : huesped) {
				modeloHuesped.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(),
						huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono(),
						huespedes.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void LlenarTablaHuespedesId() {
		// Llenar Tabla
		List<HuespedesModel> huesped = BuscarHuespedesId();
		try {
			for (HuespedesModel huespedes : huesped) {
				modeloHuesped.addRow(new Object[] { huespedes.getId(), huespedes.getNombre(), huespedes.getApellido(),
						huespedes.getFechaNacimiento(), huespedes.getNacionalidad(), huespedes.getTelefono(),
						huespedes.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void ActualizarReservas() {
		
		if(tieneFilaElegida()) {	
			
			System.out.println("Fila seleccionada Reservas: " + tieneFilaElegida());
			Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
			.ifPresentOrElse(fila -> {
	
				Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
				Date fechaE = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
				Date fechaS = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
				String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
				String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
				this.reservaCTLR.actualizar(fechaE, fechaS, valor, formaPago, id);
				JOptionPane.showMessageDialog(this, String.format("Registro modificado con éxito"));
			}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un registro"));
		}else if(tieneFilaElegida()) {
			System.out.println("Fila seleccionada Reservas: " + tieneFilaElegida());
		}
	}

	private void ActualizarHuesped() {
		
		if(tieneFilaElegida()) {	
			System.out.println("Fila seleccionada Huesped: " + tieneFilaElegida());
			Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
			.ifPresentOrElse(filaHuesped -> {
	
				Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
				String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
				String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
				Date fechaN = Date.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
				String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
				String telefono = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);
				Integer idReserva = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 6).toString());
				this.huespedesCTLR.actualizar(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
				System.out.printf("NombreRegistrado: " + nombre 
						+ "FechaNRegistrado: " + fechaN 
						+ " NacionalidadRegistrado: " + nacionalidad 
						+ " TelefonoRegistrado: " + telefono 
						+ " idReservaRegistrado: " + idReserva 
						+ " IdRegistrado: " + id);
				JOptionPane.showMessageDialog(this, String.format("Registro modificado con éxito"));
			}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un registro"));
		}else {
			System.out.println(" Fila seleccionada Huesped: " + tieneFilaElegida());
		}
	}

	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
