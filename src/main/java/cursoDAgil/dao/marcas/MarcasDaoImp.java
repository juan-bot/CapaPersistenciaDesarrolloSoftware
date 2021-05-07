package cursoDAgil.dao.marcas;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Marcas;
import cursoDAgil.bd.mappers.MarcasMapper;

@Named
public class MarcasDaoImp implements MarcasDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2808379671988699944L;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Marcas> listarTodasMarcas() {
		List<Marcas> lista = null;
		try{
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			lista = marcasMapper.listarTodasMarcas();
			for(Marcas m: lista){
				System.out.println("idMarca: " + m.getIdMarca());
				System.out.println("Nombre: " + m.getNombreMarca());
			}
			return lista;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Marcas listarMarcaPorId(Map<String, Integer> mapMarcas) {
		Marcas marca = new Marcas();
		try{
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			marca = marcasMapper.listarMarcasPorId(mapMarcas);
			return marca; 
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaMarca(Marcas marca) {
		Integer aux = 0;
		try{
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			aux = marcasMapper.nuevaMarca(marca);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminaMarca(Map<String, Integer> mapMarcas) {
		Integer aux = 0;
		try{
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			aux = marcasMapper.eliminaMarca(mapMarcas);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " +e);
		}
		return null;
	}

	@Override
	public Integer actualizaMarca(Marcas marca) {
		Integer aux = 0;
		try{
			MarcasMapper marcasMapper = sqlSession.getMapper(MarcasMapper.class);
			aux = marcasMapper.actualizaMarca(marca);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	

}
