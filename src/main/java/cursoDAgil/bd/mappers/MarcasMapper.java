package cursoDAgil.bd.mappers;

import java.util.List;
import java.util.Map;

import cursoDAgil.bd.domain.Marcas;


public interface MarcasMapper {
	List<Marcas> listarTodasMarcas();
	Marcas listarMarcasPorId(Map<String, Integer> mapMarcas);
	Integer nuevaMarca(Marcas marca);
	Integer eliminaMarca(Map<String, Integer> mapMarcas);
	Integer actualizaMarca(Marcas marca);
	Integer numberOfRows();
}
