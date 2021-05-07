package cursoDAgil.dao.ganancias;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Ganancias;

public interface GananciasDao {
	List<Ganancias> obtenerGanancias();
	Integer nuevaGanancia(Ganancias ganancias);
	List<Ganancias> obtenerGananciasPorFecha(Map<String, Date> mapGanancias);
}
