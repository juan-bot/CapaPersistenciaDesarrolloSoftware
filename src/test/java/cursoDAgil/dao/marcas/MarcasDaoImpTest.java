package cursoDAgil.dao.marcas;

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

import cursoDAgil.bd.domain.Marcas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class MarcasDaoImpTest {
	
	@Inject
	MarcasDao marcasDao;
	
	@Ignore
	public void pruebaConsultarTodo(){
		System.out.println("Test consultar todas las marcas");
		try{
			List<Marcas> lista = marcasDao.listarTodasMarcas();
			assertEquals(lista.size(),2);
		}catch (Exception e){
			System.out.println("Error: " +e);
		}
	}
	
	@Ignore
	public void pruebaConsultarMarcasPorId(){
		Marcas marca = new Marcas();
		Map<String, Integer> mapMarcas = new HashMap<>();
		mapMarcas.put("idMarca", 4);
		try{
			marca = marcasDao.listarMarcaPorId(mapMarcas);
			assertNotNull(marca);
			System.out.println("consulta por id");
			System.out.println("Id marca: " + marca.getIdMarca());
			System.out.println("Nombre: " + marca.getNombreMarca());
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	
	@Ignore
	public void pruebaNuevaMarca(){
		Marcas marca = new Marcas();
		Integer aux;
		marca.setIdMarca(4);
		marca.setNombreMarca("Vans");
		aux = marcasDao.nuevaMarca(marca);
		if (aux == 1){
			System.out.println("Marca agregada con exito");
		}
		else{
			System.out.println("Error al agregar marca");
		}
	}
	
	@Test
	public void eliminaMarca(){
		Map<String, Integer> mapMarcas = new HashMap<>();
		Integer aux;
		mapMarcas.put("idMarca", 2);
		try{
			aux = marcasDao.eliminaMarca(mapMarcas);
			if(aux == 1){
				System.out.println("Marca eliminado con exito");
			}
			else{
				System.out.println("Error al elimnar marca");
			}
		}catch(Exception e){
			System.out.println("Error:" + e);
		}
	}
	
	@Ignore
	public void actualizaMarca(){
		Integer aux;
		Marcas marca = new Marcas();
		marca.setIdMarca(2);
		marca.setNombreMarca("Gucci");
		try{
			aux = marcasDao.actualizaMarca(marca);
			if(aux == 1){
				System.out.println("Marca actualizada con exito");
			}
			else{
				System.out.println("Error al actualizar marca");
			}
		}catch(Exception e){
			System.out.println("Error: "+e );
		}
	}

}
