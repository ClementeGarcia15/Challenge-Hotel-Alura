package hotel.model;

import java.sql.Date;

public class ReservaModel {
	
	private Long id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String valor;
	private String formaPago;

	public ReservaModel(Date fechaE, Date fechaS, String valor, String formaPago) {		
		this.fechaEntrada = fechaE;
		this.fechaSalida = fechaS;
		this.valor = valor;
		this.formaPago = formaPago;
	}
		
	public ReservaModel(Long id, Date fechaE, Date fechaS, String valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaE;
		this.fechaSalida = fechaS;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getfechaE() {
		return fechaEntrada;
	}

	public Date getfechaS() {
		return fechaSalida;
	}

	public String getvalor() {
		return valor;
	}

	public String getformaPago() {
		return formaPago;
	}

}
