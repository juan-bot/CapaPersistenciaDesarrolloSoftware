package cursoDAgil.dao.detalleventas;

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

import cursoDAgil.bd.domain.DetalleVentas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})

public class DetalleVentasDaoImpTest {
	@Inject
	DetalleVentasDao detalleVentasDao;
	
	@Test
	public void pruebaListarTodasDetallVentas(){
		System.out.println("Test consultar todas detalle ventas");
		try{
			List<DetalleVentas> lista = detalleVentasDao.listarTodasDetalleVentas();
			assertEquals(lista.size(),18);
			for(DetalleVentas d: lista){
				System.out.println("VentaId: " + d.getVentaId());
				System.out.println("ProductoId: " + d.getProductoId());
				System.out.println("Cantidad: " + d.getCantidad());
			}
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	@Ignore
	public void nuevoDetalle(){
		DetalleVentas detalleventas = new DetalleVentas();
		try{
			detalleventas.setVentaId(2);
			detalleventas.setProductoId(2);
			detalleventas.setCantidad(2);
			detalleVentasDao.nuevoDetalleVenta(detalleventas);
		}catch (Exception e) {
			System.out.println("Error al crear cliente: " + e);
		}
	}
}
