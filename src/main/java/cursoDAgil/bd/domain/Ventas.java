package cursoDAgil.bd.domain;

import java.util.Date;

public class Ventas {
	private Integer idVenta;
	private Integer clienteId;
	private Double totalVenta;
	private Date fecha;
	
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	
	public Integer getIdVenta() {
		return idVenta;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	public Integer getClienteId() {
		return clienteId;
	}

	
	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	public Double getTotalVenta() {
		return totalVenta;
	}

	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getFecha() {
		return fecha;
	}

}
