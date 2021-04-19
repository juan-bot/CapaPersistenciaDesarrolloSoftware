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
			for(Cliente c:list){
				System.out.println("Id: " + c.getId());
				System.out.println("Nombre: " + c.getNombre());
				System.out.println("Apellido: " + c.getApellido());
				System.out.println("Email: " + c.getEmail());
				System.out.println("Sexo: " + c.getSexo());
				System.out.println("Id Direccion: " + c.getIdDireccion() );
				System.out.println("Calle: " + c.getDireccion().getCalle() );
				System.out.println("Numero: " + c.getDireccion().getNumero());
				System.out.println("Colonia: " + c.getDireccion().getColonia() );
				System.out.println("Ciudad: " + c.getDireccion().getCiudad());
				System.out.println("Pais: " + c.getDireccion().getPais());
				System.out.println("Codigo Postal: " + c.getDireccion().getCodigoPostal());
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
		try{
			ClienteMapper clienteMapper = sqlSession.getMapper(ClienteMapper.class);
			return clienteMapper.obtenerClientePorId(mapCliente);
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
	
	
}
