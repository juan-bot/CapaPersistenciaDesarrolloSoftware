package cursoDAgil.dao.ventas;

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

import cursoDAgil.bd.domain.Cliente;
import cursoDAgil.bd.domain.DetalleVentas;
import cursoDAgil.bd.domain.Ganancias;
import cursoDAgil.bd.domain.Productos;
import cursoDAgil.bd.domain.Ventas;
import cursoDAgil.dao.cliente.ClienteDao;
import cursoDAgil.dao.detalleventas.DetalleVentasDao;
import cursoDAgil.dao.ganancias.GananciasDao;
import cursoDAgil.dao.productos.ProductosDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class VentasDaoImplTest {
	@Inject
	VentasDao ventasDao;
	@Inject
	GananciasDao gananciasDao;
	@Inject
	ClienteDao clienteDao;
	@Inject
	DetalleVentasDao detallesVentasDao;
	@Inject
	ProductosDao productosDao;
	
	
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
	@Ignore
	public void nuevaVenta(){
		Ventas venta =new Ventas();
		Ganancias ganancia = new Ganancias();
		System.out.println("Test nuevo registro");
		try{
			Integer aux;
			venta.setIdVenta(5);
			venta.setClienteId(1);
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
	@Test
	public void RealizarVenta(){//realizar una venta
		//producto que desea comprar
		Productos producto = new Productos();
		Map<String, Integer> mapProductos = new HashMap<>();
		mapProductos.put("idProducto", 5);
		try{
			producto = productosDao.listarProductosPorId(mapProductos);
			if(producto==null)
				System.out.println("el producto no esta en stock");
			//assertNotNull(producto);
			
			
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
	@Ignore
	public void comprasPorCliente() {////CONSULTA DE DETALLE DE VENTA
		Cliente cliente = new Cliente();		
		Map<String, Integer> mapCliente = new HashMap<>();
		//
		List<Ventas> list = null;
		Map<String, Integer> mapVentas = new HashMap<>();
		//
		List<DetalleVentas> list3 = null;
		DetalleVentas detalleVentas = new DetalleVentas();
		Map<String, Integer> mapDetalle = new HashMap<>();
		//
		Productos producto = new Productos();
		Map<String, Integer> mapProductos = new HashMap<>();
		
		mapCliente.put("id", 3);
		try {
			cliente = clienteDao.obtenerClientePorId(mapCliente);
			assertNotNull(cliente);
			System.out.println("Cliente: "+cliente.getNombre()+ " " + cliente.getApellido()); //nombre del cliente
			mapVentas.put("clienteId", cliente.getId());
			try{
				list=ventasDao.obtenerVentaPorClienteId(mapVentas);
				for(Ventas v:list){
					/*System.out.println("idVenta :"+v.getIdVenta()); // ventas
					System.out.println("clienteId :"+ v.getClienteId());*/
					mapDetalle.put("ventaId", v.getIdVenta());
					Date date = v.getFecha();  //convertir tipo date to string
		            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
		            String strDate = dateFormat.format(date);
					try{
						list3 = detallesVentasDao.DetalleVentaPorId(mapDetalle);
						for(DetalleVentas d:list3){
							/*System.out.println("ventaId: "+d.getVentaId()); //detalles venta
							System.out.println("productoId: "+d.getProductoId());*/
							mapProductos.put("idProducto", d.getProductoId());
							try{
								producto = productosDao.listarProductosPorId(mapProductos);
								assertNotNull(producto);
								System.out.println("Compro #" + d.getCantidad() +" producto:"+ producto.getNombre()+" el: "+strDate);
							}catch(Exception e){
								System.out.println("Error: " + e);
							}
						}
					}catch(Exception e){
						System.out.println("Error: " + e);
					}
				}
			}catch (Exception e){
				System.out.println("Error: " + e);
			}

		} catch (Exception e) {
			System.out.println("Error en consultar cliente por id: " + e);
		}
	}
	@Ignore
	public void clientesId() {///compras por cliente
		List<Ventas> list = null;
		Map<String, Integer> mapVentas = new HashMap<>();
		mapVentas.put("clienteId", 3);
		try{
			list=ventasDao.obtenerVentaPorClienteId(mapVentas);
			for(Ventas v:list){
				System.out.println("idVenta :"+v.getIdVenta());
				System.out.println("clienteId :"+ v.getClienteId());
			}
		}catch (Exception e){
			System.out.println("Error: " + e);
		}
	}
}
