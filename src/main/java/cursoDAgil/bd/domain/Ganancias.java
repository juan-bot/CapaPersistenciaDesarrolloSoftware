package cursoDAgil.bd.domain;


public class Ganancias {
	private Integer idGanancia;
	private Integer ventaId;
	private Double totalGanancia;
	private String fecha;
	
	public void setIdGanancia(Integer idGanancia) {
		this.idGanancia = idGanancia;
	}
	public Integer getIdGanancia() {
		return idGanancia;
	}
	
	
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Integer getVentaId() {
		return ventaId;
	}
	
	
	public void setTotalGanancia(Double totalGanancia) {
		this.totalGanancia = totalGanancia;
	}
	public Double getTotalGanancia() {
		return totalGanancia;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFecha() {
		return fecha;
	}
	public boolean equals(Object object){
		if(!(object instanceof Ganancias)){
			return false;
		}
		Ganancias regGanancias = (Ganancias) object;
		return (this.idGanancia == regGanancias.idGanancia);
	}

}
