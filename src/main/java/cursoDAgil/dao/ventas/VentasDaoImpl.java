package cursoDAgil.dao.ventas;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.bd.mappers.VentaMapper;
@Named
public class VentasDaoImpl implements VentasDao, Serializable {
	private static final long serialVersionUID = 8449934396730354688L;

	SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Ventas> listarVentasTodo() {
		List<Ventas> list = null;
		try{
			VentaMapper ventasMapper =sqlSession.getMapper(VentaMapper.class);
			list = ventasMapper.listarVentasTodo();
			for(Ventas v: list){
				System.out.println("idVenta: " + v.getIdVenta());
				System.out.println("clienteId: " + v.getClienteId());
				System.out.println("totalVenta: " + v.getTotalVenta());
				Date date = v.getFecha();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strDate = dateFormat.format(date);
				System.out.println("fecha: " + strDate);
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevaVenta(Ventas venta) {
		Integer aux = 0;
		try{
			VentaMapper ventasMapper =sqlSession.getMapper(VentaMapper.class);
			aux=ventasMapper.nuevaVenta(venta);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

}
