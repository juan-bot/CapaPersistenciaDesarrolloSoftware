package cursoDAgil.dao.ventas;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.ganancias.GananciasDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class VentasDaoImplTest {
	@Inject
	VentasDao ventasDao;
	@Inject
	GananciasDao gananciasDao;
	
	@Ignore
	public void listarVentasTodo(){
		System.out.println("Test consultar todas las ventas");
		try{
			List<Ventas> lista =ventasDao.listarVentasTodo();
			assertEquals(lista.size(),2);
		}catch(Exception e){
			System.out.println("Errortest: " + e);
		}
	}
	@Test
	public void nuevaVenta(){
		Ventas venta =new Ventas();
		Ganancias ganancia = new Ganancias();
		System.out.println("Test nuevo registro");
		try{
			Integer aux;
			venta.setIdVenta(5);
			venta.setClienteId(3);
			venta.setTotalVenta(233.5);
			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");//convertir tipo string to date
			try{
				Date date = DateFor.parse("08/07/2019");
				venta.setFecha(date);
				ganancia.setDate(date);
			}catch(ParseException e){
				e.printStackTrace();
			}
			ganancia.setIdVenta(5);
			ganancia.setTotalGanancia(233.5);
			ventasDao.nuevaVenta(venta);
			gananciasDao.nuevaGanancia(ganancia);
			
		}catch(Exception e){
			System.out.println("Error6: " + e);
		}
	}
	@Ignore
	public void listarVentasPorCliente(){
		System.out.println("Test consultar todas las ventas por cliente");
		try{
			List<Ventas> lista = ventasDao.listarVentasPorCliente();
			assertEquals(lista.size(),3);
		}catch(Exception e){
			System.out.println("Errortest: " + e);
		}
	}
	@Ignore
	public void listarDetalleVentas(){
		System.out.println("Test consultar compras del cliente");
		try{
			List<Ventas> lista = ventasDao.ListarDetalleVenta();
			assertEquals(lista.size(),2);
		}catch(Exception e){
			System.out.println("Errortest: " + e);
		}
	}
}
