package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasMapper {
	List<DetalleVentas> listarTodasDetalleVentas();
	Integer nuevoDetalleVenta(DetalleVentas detalleventas);
	DetalleVentas DetalleVentaPorId(Map<String, Integer> mapDetalle);
}
