package cursoDAgil.dao.ganancias;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ganancias;

public interface GananciasDao {
	List<Ganancias> obtenerGanancias();
	Integer nuevaGanancia(Ganancias ganancias);
	Ganancias obtenerGananciasPorId(Map<String, Integer> mapGanancias);
}
