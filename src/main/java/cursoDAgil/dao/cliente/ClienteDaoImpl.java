package cursoDAgil.dao.cliente;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.mappers.ClienteMapper;

@Named
public class ClienteDaoImpl implements ClienteDao, Serializable {

	private static final long serialVersionUID = 2258246685723751527L;	
	SqlSession sqlSession;	
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Cliente> listarTodosClientes() {
		List<Cliente> list = null;
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			list = clienteMapper.listarTodosClientes();
			System.out.println("Listar Clientes");
			for(Cliente c:list){
				System.out.println("Cliente-------");
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido: " + c.getApellido());
				System.out.println("Email: " + c.getEmail());
				System.out.println("Sexo: " + c.getSexo());
				System.out.println("Id Direccion: " + c.getIdDireccion() );
			}
			return list;
		}catch (Exception e){
			System.out.println("Error: " + e);
		}
		return null;
	}

	@Override
	public Integer nuevoCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente creado con exito");
			return clienteMapper.nuevoCliente(cliente);
		}catch(Exception e){
			System.out.println("ErrorCliente0: " + e);
		}
		
		return null;
	}
	
	

	@Override
	public Integer editarCliente(Cliente cliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente editado con Exito");
			return clienteMapper.editarCliente(cliente);
		}catch(Exception e){
			System.out.println("ErrorCliente1: " + e);
		}
		
		return null;
	}

	@Override
	public Cliente obtenerClientePorId(Map<String, Integer> mapCliente) {
		Cliente cliente =new Cliente();
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			cliente=clienteMapper.obtenerClientePorId(mapCliente);
			System.out.println("Cliente :" + cliente.getNombre()+" "+ cliente.getApellido()+"\n");
			return cliente;
		}catch(Exception e){
			System.out.println("Error al obtener el cliente por el id: " + e);
		}
		return null;
	}

	@Override
	public Integer eliminarCliente(Map<String, Integer> mapCliente) {
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			System.out.println("Cliente eliminado con Exito");
			return clienteMapper.eliminarCliente(mapCliente);
		}catch(Exception e){
			System.out.println("ErrorCliente2: " + e);
		}
		
		return null;
	}
	@Override
	public Integer numberOfRows() {
		ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
		return clienteMapper.numberOfRows();
	}

}
