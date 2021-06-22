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
			System.out.println("direccion creada con exito");
			return direccionMapper.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Direccion> obtenerDirecciones() {
		List<Direccion> list = null;
		
		try {
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			list = direccionMapper.obtenerDirecciones();
			for(Direccion d:list){
				System.out.println("idDirección: "+ d.getIdDireccion());
				System.out.println("Calle: "+ d.getCalle());
				System.out.println("Número: "+ d.getNumero());
				System.out.println("Colonia: "+ d.getColonia());
				System.out.println("Ciudad: "+ d.getCiudad());
				System.out.println("Pais: "+ d.getPais());
				System.out.println("Número: "+ d.getCodigoPostal());
			}
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
			System.out.println("Direccion eliminado con exito");
			return direccionMapper.eliminarDireccion(mapDireccion);
		}catch(Exception e){
			System.out.println("ErrorDireccion2: " + e);
		}
		
		return null;
	}

	@Override
	public Integer editarDireccion(Direccion direccion) {
		try{
			DireccionMapper direccionMapper = sqlSession.getMapper(DireccionMapper.class);
			System.out.println("Direccion editada con Exito");
			return direccionMapper.editarDireccion(direccion);
		}catch(Exception e){
			System.out.println("ErrorCliente1: " + e);
		}
		return null;
	}

}

