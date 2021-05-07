package cursoDAgil.bd.domain;

import java.util.Date;

public class Ganancias {
	private Integer idGanancia;
	private Integer ventaId;
	private Double totalGanancia;
	private Date fecha;

	public void setIdGanancia(Integer idGanancia) {
		this.idGanancia = idGanancia;
	}
	public Integer getIdGanancia() {
		return idGanancia;
	}
	
	
	public void setIdVenta(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Integer getIdVenta() {
		return ventaId;
	}
	
	
	public void setTotalGanancia(Double totalGanancia) {
		this.totalGanancia = totalGanancia;
	}
	public Double getTotalGanancia() {
		return totalGanancia;
	}
	
	public void setDate(Date fecha) {
		this.fecha = fecha;
	}
	public Date getDate() {
		return fecha;
	}
}
