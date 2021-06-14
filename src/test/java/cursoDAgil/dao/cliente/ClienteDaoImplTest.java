package cursoDAgil.dao.cliente;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	
	@Ignore
	public void pruebaConsultarTodo() {
		System.out.println("Test consultar todos los clientes");
		try {
			List<Cliente> lista = clienteDao.listarTodosClientes();
			assertEquals(lista.size(), lista.size());
			System.out.println("//------------------------------------");
		} catch (Exception ex) {
			System.out.println("Error en consultar todos los clientes" + ex);
		}
	}
	@Ignore
	public void editarRegistro(){
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente=new HashMap<>();
		mapCliente.put("id", 1);
		try{
			System.out.println("Editar cliente");
			cliente.setId(2);
			cliente.setNombre("Alfredo");
			cliente.setApellido("Garcia");
			cliente.setEmail("alfredo@gmail.com");
			cliente.setSexo("Masculino");
			cliente.setIdDireccion(14);
			clienteDao.editarCliente(cliente);
		}catch (Exception e){
			System.out.println("Error en editar cliente" + e);
		}
	}
	@Test
	public void nuevoCliente() {
		Cliente cliente = new Cliente();
		Direccion direccion= new Direccion();
		Map<String, Integer> mapDireccion= new HashMap<>();
		mapDireccion.put("idDireccion",1);
		System.out.println("Ingresa un nuevo cliente");
		try {
			cliente.setNombre("Ricardo");
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
	public void consultarClientePorId() {
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		mapCliente.put("id", 3);
		System.out.println("Test cliente por id");
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
	public void consultarClienteDireccionPorId() {
		Cliente cliente = new Cliente();
		Map<String, Integer> mapCliente = new HashMap<>();
		mapCliente.put("id", 3);
		System.out.println("Test cliente por id");
		try {
			cliente = clienteDao.obtenerClientePorId(mapCliente);
			//assertNotNull(cliente);
			System.out.println("Id: " + cliente.getId());
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Apellido: " + cliente.getApellido());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Sexo: " + cliente.getSexo());
			/*System.out.println("Calle: " + cliente.getDireccion().getCalle() );
			System.out.println("Numero: " + cliente.getDireccion().getNumero());
			System.out.println("Colonia: " + cliente.getDireccion().getColonia() );
			System.out.println("Ciudad: " + cliente.getDireccion().getCiudad());
			System.out.println("Pais: " + cliente.getDireccion().getPais());
			System.out.println("Codigo Postal: " + cliente.getDireccion().getCodigoPostal());*/
		} catch (Exception e) {
			System.out.println("Error en consultar cliente por id: " + e);
		}
	}
	@Ignore
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
