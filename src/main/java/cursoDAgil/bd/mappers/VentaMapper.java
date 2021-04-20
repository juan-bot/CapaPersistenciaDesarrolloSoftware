package cursoDAgil.bd.mappers;

import java.util.List;

import cursoDAgil.bd.domain.Ventas;

public interface VentaMapper {
	List<Ventas> listarVentasTodo();
	Integer nuevaVenta(Ventas venta);
	List<Ventas> listarVentasPorCliente();
	List<Ventas> ListarDetalleVenta();
}
