package cursoDAgil.dao.direccion;

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

import cursoDAgil.bd.domain.Direccion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DireccionDaoImplTest {
	@Inject
	DireccionDao direccionDao;

	@Ignore
	public void consultarDireccionPorId() {
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion = new HashMap<>();
		mapDireccion.put("idDireccion", 1);
		System.out.println("Test consultar direccion por id--");
		try {
			direccion = direccionDao.obtenerDireccionPorId(mapDireccion);
			assertNotNull(direccion);
			System.out.println("id: " + direccion.getIdDireccion());
			System.out.println("Calle: " + direccion.getCalle() );
			System.out.println("Numero: " + direccion.getNumero());
			System.out.println("Colonia: " + direccion.getColonia() );
			System.out.println("Ciudad: " + direccion.getCiudad());
			System.out.println("Pais: " + direccion.getPais());
			System.out.println("Codigo Postal: " + direccion.getCodigoPostal());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void editarDireccion(){
		Direccion direccion = new Direccion();
		Map<String, Integer> mapDireccion=new HashMap<>();
		mapDireccion.put("idDireccion", 1);
		System.out.println("Test editar direccion----");
		try{
			direccion.setIdDireccion(3);
			direccion.setCalle("independencia");
			direccion.setNumero(110);
			direccion.setColonia("linda vista");
			direccion.setCiudad("oaxaca de juarez");
			direccion.setEstado("oaxaca");
			direccion.setPais("mexico");
			direccion.setCodigoPostal(39220);
			direccionDao.editarDireccion(direccion);
		}catch (Exception e){
			System.out.println("Error al editar direccion" + e);
		}
	}
	
	
	@Ignore
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las direcciones--");
		try {
			List<Direccion> lista = direccionDao.obtenerDirecciones();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		} catch (Exception ex) {
			System.out.println("error" + ex);

		}
	}
	

	@Test
	public void nuevoRegistro() {
		Direccion direccion = new Direccion();
		System.out.println("Test nuevo registro--");
		try {
			direccion.setCalle("juannn");
			direccion.setNumero(3);
			direccion.setColonia("Centro");
			direccion.setCiudad("Huajuapan");
			direccion.setEstado("Oaxaca");
			direccion.setPais("Mexico");
			direccion.setCodigoPostal(69000);
			direccionDao.nuevaDireccionCliente(direccion);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void eliminarDireccion(){
		System.out.println("Test eliminar registro--");
		Map<String, Integer> mapDireccion=new HashMap<>();
		mapDireccion.put("idDireccion", 16);
		try{
			direccionDao.eliminarDireccion(mapDireccion);
		}catch (Exception e) {
				System.out.println("Error al eliminar direccion: " + e);
		}
	}
}
