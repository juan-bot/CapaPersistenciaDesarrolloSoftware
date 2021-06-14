package cursoDAgil.bd.domain;

public class DetalleVentas {
	private Integer ventaId;
	private Integer productoId;
	private Integer cantidad;
	
	private Ventas venta;
	private Productos producto;
	
	public Ventas getVenta(){
		return this.venta;
	}
	
	public void setVenta(Ventas venta){
		this.venta = venta;
	}
	
	public Productos getProducto(){
		return this.producto;
	}
	
	public void setProducto(Productos producto){
		this.producto = producto;
	}
	
	public Integer getVentaId() {
		return ventaId;
	}
	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}
	public Integer getProductoId() {
		return productoId;
	}
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public DetalleVentas(){
		setVenta( new Ventas());
		setProducto( new Productos());
	}
	
	public boolean equals(Object object){
		if(!(object instanceof DetalleVentas)){
			return false;
		}
		DetalleVentas regDetalle = (DetalleVentas) object;
		return (this.ventaId == regDetalle.ventaId && this.productoId == regDetalle.productoId && this.cantidad == regDetalle.cantidad);
	}
}