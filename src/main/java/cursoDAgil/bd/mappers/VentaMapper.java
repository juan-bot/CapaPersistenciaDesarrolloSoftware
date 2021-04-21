package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ventas;

public interface VentaMapper {
	List<Ventas> listarVentasTodo();
	Integer nuevaVenta(Ventas venta);
	List<Ventas> listarVentasPorCliente();
	List<Ventas> ListarDetalleVenta();
	List<Ventas> obtenerVentaPorClienteId(Map<String, Integer> mapVentas);
}
