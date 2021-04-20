package cursoDAgil.bd.mappers;

import java.util.List;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasMapper {
	List<DetalleVentas> listarTodasDetalleVentas();
	Integer nuevoDetalleVenta(DetalleVentas detalleventas);
}
