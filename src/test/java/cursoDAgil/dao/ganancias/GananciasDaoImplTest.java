package cursoDAgil.dao.ganancias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Ganancias;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GananciasDaoImplTest {
	@Inject
	GananciasDao gananciasDao;

	@Test
	public void pruebaConsultarTodo() {
		int reg;
		System.out.println("Test consultar todas las ganancias");
		try{
			List<Ganancias> lista = gananciasDao.obtenerGanancias();
			reg = lista.size();
			assertEquals(lista.size(), reg);
			System.out.println("\nRegistros en la tabla: " + reg);
		}catch (Exception e) {
			System.out.println("error5" + e);
		}
	}
	
	@Ignore
	public void obtenerGananciasPorFecha() {
		Ganancias ganancias = new Ganancias();
		Map<String, String> mapGanancias = new HashMap<>();
		mapGanancias.put("fecha", "08/07/2019");
		System.out.println("Test consultar ganancia por fecha");
		List <Ganancias> lista = gananciasDao.obtenerGananciasPorFecha(mapGanancias);
		int reg = lista.size();
		assertEquals(lista.size(), reg);
		System.out.println("TOTAL: "+ reg);
	}
	
	
	@Ignore
	public void nuevoRegistro() {
		Ganancias ganancia = new Ganancias();
		System.out.println("Test nuevo registro");
		try {
			ganancia.setVentaId(3);
			ganancia.setTotalGanancia(11.2);
			ganancia.setFecha("08/07/2019");			
			
			gananciasDao.nuevaGanancia(ganancia);
		} catch (Exception e) {
			System.out.println("Error6: " + e);
		}
	}
}
