package cursoDAgil.bd.domain;

import java.util.Date;

public class Ventas {
	
	private Integer idVenta;
	private Integer clienteId;
	private Double totalVenta;
	private Date fecha;

	private Cliente cliente;
	private DetalleVentas detalleventas;
	private Ganancias ganancia;
	private Productos producto;
	
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

	// agregar relacion con cliente
	public Ventas() {
		setCliente( new Cliente());
		//setDetalleVentas( new DetalleVentas());
		//setGanancia(  new Ganancias());
		//setProducto( new Productos());
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	// agregar relacion con detalle ventas

	public void setDetalleVentas(DetalleVentas detalleventas) {
		this.detalleventas = detalleventas;
	}

	public DetalleVentas getDetalle() {
		return detalleventas;
	}
	
	public void setGanancia(Ganancias ganancia){
		this.ganancia = ganancia;
	}
	
	public Ganancias getGanancia(){
		return ganancia;
	}
	
	public void setProducto(Productos producto){
		this.producto = producto;
	}
	
	public Productos getProducto(){
		return this.producto;
	}
	
	public boolean equals(Object object){
		if(!(object instanceof Ventas)){
			return false;
		}
		Ventas regVentas = (Ventas) object;
		return (this.idVenta == regVentas.idVenta);
	}

}
