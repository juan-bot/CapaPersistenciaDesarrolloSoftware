package cursoDAgil.dao.marcas;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marcas;

public interface MarcasDao {
	List<Marcas> listarTodasMarcas();
	Marcas listarMarcaPorId(Map<String, Integer> mapMarcas);
	Integer nuevaMarca(Marcas marca);
	Integer eliminaMarca(Map<String, Integer> mapMarcas);
	Integer actualizaMarca(Marcas marca);
	Integer numberOfRows();
}
