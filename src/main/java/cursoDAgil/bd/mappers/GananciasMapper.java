package cursoDAgil.bd.mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ganancias;

public interface GananciasMapper {
	List<Ganancias> obtenerGanancias();
	Integer nuevaGanancia(Ganancias ganancias);
	List<Ganancias> obtenerGananciasPorFecha(Map<String, String> mapGanancias);
	Integer numberOfRows();
}
