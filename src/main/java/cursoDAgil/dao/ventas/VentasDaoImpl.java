package cursoDAgil.dao.ventas;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
			/*for(Ventas v: list){
				System.out.println("idVenta: " + v.getIdVenta());
				System.out.println("clienteId: " + v.getClienteId());
				System.out.println("totalVenta: " + v.getTotalVenta());
				Date date = v.getFecha();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strDate = dateFormat.format(date);
				System.out.println("fecha: " + strDate);
			}*/
			return list;
		}catch(Exception e){
			System.out.println("Error: c" + e);
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

	@Override
	public List<Ventas> listarVentasPorCliente() {
		List<Ventas> list = null;
		try{
			VentaMapper ventasMapper =sqlSession.getMapper(VentaMapper.class);
			list = ventasMapper.listarVentasPorCliente();
			for(Ventas v: list){
				System.out.println("Venta-------");
				System.out.println("idVenta: " + v.getIdVenta());
				System.out.println("clienteId: " + v.getClienteId());
				System.out.println("totalVenta: " + v.getTotalVenta());
				Date date = v.getFecha();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strDate = dateFormat.format(date);
				System.out.println("fecha: " + strDate);
				
				System.out.println("Id: " + v.getCliente().getId());
				System.out.println("Nombre: " + v.getCliente().getNombre());
				System.out.println("Apellido: " + v.getCliente().getApellido());
				System.out.println("Email: " + v.getCliente().getEmail());
				System.out.println("Sexo: " + v.getCliente().getSexo());
				System.out.println("Id Direccion: " + v.getCliente().getIdDireccion());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Ventas> ListarDetalleVenta() {
		List<Ventas> list = null;
		try{
			VentaMapper ventasMapper =sqlSession.getMapper(VentaMapper.class);
			list = ventasMapper.ListarDetalleVenta();
			for(Ventas v: list){
				System.out.println("Venta-------");
				System.out.println("idVenta: " + v.getIdVenta());
				System.out.println("clienteId: " + v.getClienteId());
				System.out.println("totalVenta: " + v.getTotalVenta());
				Date date = v.getFecha();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strDate = dateFormat.format(date);
				System.out.println("fecha: " + strDate);
				
				System.out.println("VentaId: " + v.getDetalle().getVentaId());
				System.out.println("ProductoId: " + v.getDetalle().getProductoId());
				System.out.println("Cantidad: " + v.getDetalle().getCantidad());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public List<Ventas> obtenerVentaPorClienteId(Map<String, Integer> mapVentas) {
		List<Ventas> list = null;
		try{
			VentaMapper ventasMapper =sqlSession.getMapper(VentaMapper.class);
			list = ventasMapper.obtenerVentaPorClienteId(mapVentas);
			for(Ventas v:list){
				System.out.println("idVenta :"+v.getIdVenta());
				System.out.println("clienteId :"+ v.getClienteId());
			}
			return list;
		}catch(Exception e){
			System.out.println("Error al obtener la venta por el idcliente: " + e);
		}
		return null;
	}

	@Override
	public Integer actualizaVenta(Ventas venta) {
		Integer aux = 0;
		try{
			VentaMapper ventasMapper =sqlSession.getMapper(VentaMapper.class);
			System.out.println("Actualizo venta con exito");
			aux=ventasMapper.actualizaVenta(venta);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}
	@Override
	public Integer numberOfRows() {
		VentaMapper ventasMapper = sqlSession.getMapper(VentaMapper.class);
		return ventasMapper.numberOfRows();
	}
	@Override
	public List<Ventas> ListarVentaPorId(Map<String, Integer> map) {
		VentaMapper ventasMapper = sqlSession.getMapper(VentaMapper.class);
		return ventasMapper.ListarVentaPorId(map);
	}
}
