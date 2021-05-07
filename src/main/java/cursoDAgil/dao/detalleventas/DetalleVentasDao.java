package cursoDAgil.dao.detalleventas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasDao {
	List<DetalleVentas> listarTodasDetalleVentas();
	Integer nuevoDetalleVenta(DetalleVentas detalleventas);
	List<DetalleVentas> DetalleVentaPorId(Map<String, Integer> mapDetalle);
}
