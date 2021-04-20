package cursoDAgil.dao.cliente;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.Direccion;
import cursoDAgil.dao.cliente.ClienteDao;
import cursoDAgil.dao.direccion.DireccionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })

public class ClienteDaoImplTest {
	@Inject
	ClienteDao clienteDao;
	@Inject
	DireccionDao direccionDao;
	
	@Test
	//YA SALE
	public void pruebaConsultarTodo() {
		System.out.println("Test consultar todos los clientes");
		try {
			List<Cliente> lista = clienteDao.listarTodosClientes();
			assertEquals(lista.size(), 2);
			System.out.println("//------------------------------------");
		} catch (Exception ex) {
			System.out.println("Error en consultar todos los clientes" + ex);
		}
	}
	@Ignore
	public void editarRegistro(){
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente=new HashMap<>();
		mapCliente.put("id", 2);
		try{
			System.out.println("Editar cliente");
			cliente.setId(2);
			cliente.setNombre("Alfredo");
			cliente.setApellido("García");
			cliente.setEmail("alfredo@gmail.com");
			cliente.setSexo("Masculino");
			cliente.setIdDireccion(14);
			clienteDao.editarCliente(cliente);
		}catch (Exception e){
			System.out.println("Error en editar cliente" + e);
		}
		
	}
	@Ignore
	//YA SALE
	public void nuevoCliente() {
		Cliente cliente = new Cliente();
		Direccion direccion= new Direccion();
		Map<String, Integer> mapDireccion= new HashMap<>();
		mapDireccion.put("idDireccion",3);
		System.out.println("Ingresa un nuevo cliente");
		try {
			cliente.setNombre("Ricardo3");
			cliente.setApellido("Garcia");
			cliente.setEmail("ricardo@gmail.com");
			cliente.setSexo("Masculino");
			direccion= direccionDao.obtenerDireccionPorId(mapDireccion);
			cliente.setIdDireccion(direccion.getIdDireccion());
			cliente.setDireccion(direccion);
			System.out.println("entraa");
			clienteDao.nuevoCliente(cliente);
		} catch (Exception e) {
			System.out.println("Error al crear cliente: " + e);
		}
	}
	@Ignore
	//YA SALE
	public void consultarClientePorId() {
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		mapCliente.put("id", 1);
		try {
			cliente = clienteDao.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			System.out.println("Id: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Apellido: " + cliente.getApellido());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("idDireccion: " + cliente.getIdDireccion());
		} catch (Exception e) {
			System.out.println("Error en consultar cliente por id: " + e);
		}
	}

	
	@Ignore
	//YA SALE
	public void eliminarCliente(){
		Map<String, Integer> mapCliente=new HashMap<>();
		mapCliente.put("id", 2);
		try{
			clienteDao.eliminarCliente(mapCliente);
		}catch (Exception e) {
				System.out.println("Error al eliminar cliente: " + e);
		}
	}

}
