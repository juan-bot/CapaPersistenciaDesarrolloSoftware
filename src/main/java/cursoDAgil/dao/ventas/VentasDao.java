package cursoDAgil.dao.ventas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ventas;

public interface VentasDao {
	List<Ventas> listarVentasTodo();
	Integer nuevaVenta(Ventas venta);
	List<Ventas> listarVentasPorCliente();
	List<Ventas> ListarDetalleVenta();
	List<Ventas> obtenerVentaPorClienteId(Map<String, Integer> mapVentas);
	Integer actualizaVenta(Ventas venta);
}
