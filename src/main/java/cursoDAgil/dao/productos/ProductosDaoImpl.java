package cursoDAgil.dao.productos;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.mappers.ProductosMapper;

@Named
public class ProductosDaoImpl implements ProductosDao, Serializable{

	private static final long serialVersionUID = 6008379547740188226L;
	SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Productos> listarTodosProductos() {
		List<Productos> lista = null;
		try{
			ProductosMapper productoMapper= sqlSession.getMapper(ProductosMapper.class);
			lista = productoMapper.listarTodosProductos();
			for(Productos p: lista){
				System.out.println("idProducto: "+p.getIdProducto());
				System.out.println("nombre: "+p.getNombre());
				System.out.println("precio: "+p.getPrecio()); 
				System.out.println("precioVta: "+p.getPrecio());
				System.out.println("cantidad: "+p.getCantidad());
				System.out.println("marcaId: "+p.getMarcaId());
			}
			return lista;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Productos listarProductosPorId(Map<String, Integer> mapProductos) {
		Productos producto = new Productos();
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			producto = productoMapper.listarProductosPorId(mapProductos);
			return producto;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevoProducto(Productos producto) {
		Integer aux =0;
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			aux =productoMapper.nuevoProducto(producto);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminaProducto(Map<String, Integer> mapProductos) {
		Integer aux = 0;
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			aux = productoMapper.eliminaProducto(mapProductos);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer actualizaProducto(Productos producto) {
		Integer aux = 0;
		try{
			ProductosMapper productoMapper = sqlSession.getMapper(ProductosMapper.class);
			aux = productoMapper.actualizaProducto(producto);
			return aux;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

}
