package cursoDAgil.dao.direccion;

import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.bd.mappers.DireccionMapper;

@Named
public class DireccionDaoImpl implements DireccionDao {

	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Integer nuevaDireccionCliente(Direccion direccion) {
		// TODO Auto-generated method stub
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			System.out.println("direccion creada con éxito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Direccion> obtenerDirecciones() {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);

			return direccionMapper.obtenerDirecciones();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Direccion obtenerDireccionPorId(Map<String, Integer> mapDireccion) {
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			return direccionMapper.obtenerDireccionPorId(mapDireccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminarDireccion(Map<String, Integer> mapDireccion) {
		try{
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Dirección eliminado con éxito");
			return direccionMapper.eliminarDireccion(mapDireccion);
		}catch(Exception e){
			System.out.println("ErrorDireccion2: " + e);
		}
		
		return null;
	}

}

