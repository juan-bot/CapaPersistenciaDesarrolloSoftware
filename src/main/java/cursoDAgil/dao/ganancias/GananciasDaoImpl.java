package cursoDAgil.dao.ganancias;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.mappers.GananciasMapper;

@Named
public class GananciasDaoImpl implements GananciasDao {

	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Ganancias> obtenerGanancias() {
		List<Ganancias> list = null;
		try{
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			list = gananciasMapper.obtenerGanancias();
			for(Ganancias g:list){
				System.out.println("idGanancia"+ g.getIdGanancia());
				System.out.println("ventaId"+ g.getIdVenta());
				System.out.println("totalGanancia"+ g.getTotalGanancia());
			}
			//return gananciasMapper.obtenerGanancias();
		}catch(Exception e){
			System.out.println("Error1: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaGanancia(Ganancias ganancias) {
		try{
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			System.out.println("ganancia creada con �xito");
			return gananciasMapper.nuevaGanancia(ganancias);
		}catch(Exception e){
			System.out.println("Error2: " + e);
		}
		return null;
	}

	@Override
	public Ganancias obtenerGananciasPorFecha(Map<String, Date> mapGanancias) {
		try{
			GananciasMapper gananciasMapper = sqlSession.getMapper(GananciasMapper.class);
			return gananciasMapper.obtenerGananciasPorFecha(mapGanancias);
		}catch(Exception e){
			System.out.println("Error3: " + e);
		}
		return null;
	}

}
