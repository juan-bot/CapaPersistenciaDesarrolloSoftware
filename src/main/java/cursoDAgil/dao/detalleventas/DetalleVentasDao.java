package cursoDAgil.dao.detalleventas;

import java.util.List;

import cursoDAgil.bd.domain.DetalleVentas;

public interface DetalleVentasDao {
	List<DetalleVentas> listarTodasDetalleVentas();
	Integer nuevoDetalleVenta(DetalleVentas detalleventas);
}
