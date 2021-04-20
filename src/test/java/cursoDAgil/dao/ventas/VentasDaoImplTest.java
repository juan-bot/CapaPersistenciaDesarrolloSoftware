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

import cursoDAgil.bd.domain.Ventas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class VentasDaoImplTest {
	@Inject
	VentasDao ventasDao;
	
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
		System.out.println("Test nuevo registro");
		try{
			Integer aux;
			venta.setIdVenta(3);
			venta.setClienteId(3);
			venta.setTotalVenta(233.5);
			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");//convertir tipo string to date
			try{
				Date date = DateFor.parse("08/07/2019");
				venta.setFecha(date);
			}catch(ParseException e){
				e.printStackTrace();
			}
			ventasDao.nuevaVenta(venta);
		}catch(Exception e){
			System.out.println("Error6: " + e);
		}
		
	}
	
}