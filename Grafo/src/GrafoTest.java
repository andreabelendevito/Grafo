import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest {
	
	
	public Grafo grafo(){
		return  new Grafo(5);
	}
	
	@Test
	public void testCrearArista() {
		Grafo aTestear = grafo();
		//arista posible
		aTestear.crearArista(0, 1);
		
		assertTrue(aTestear.existeArista(0, 1));
		assertEquals(1, aTestear.getCantAristas());
		
	}
	@Test
	public void testCrearAristaRepetidaTest(){
		Grafo aTestear=grafo();
		//agrego la misma arista varias veces
		aTestear.crearArista(2, 3);
		aTestear.crearArista(2, 3);
		aTestear.crearArista(2, 3);
		aTestear.crearArista(2, 3);
		
		assertEquals(1,aTestear.getCantAristas());
	}
	@Test(expected=IllegalArgumentException.class)
	public void crearAristaFueraDeRangoTest(){
		Grafo aTestear=grafo();
		//arista fuera de rango
		
		aTestear.crearArista(3, 6);
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void crearAristaNegativaTest(){
		Grafo aTestear= grafo();
		aTestear.crearArista(-1, 4);
		aTestear.crearArista(2, -1);
		
	}
	@Test
	public void existeAristaTest(){
		Grafo aTestear= grafo();
		//creo una arista pero chequeo esa y otra inexistente
		aTestear.crearArista(1, 0);
		assertTrue(aTestear.existeArista(1, 0));
		assertTrue(aTestear.existeArista(0, 1));
		assertFalse(aTestear.existeArista(2,0));
		
	}
	@Test
	public void eliminarAristaTest(){
		Grafo aTestear= grafo();
		//creo una arista y luegp la elimino
		
		aTestear.crearArista(1, 2);
		assertEquals(1,aTestear.getCantAristas());
		aTestear.eliminarArista(1, 2);
		assertEquals(0,aTestear.getCantAristas());
		
		//elimino una arista que no existe
		aTestear.eliminarArista(1, 2);
		assertEquals(0, aTestear.getCantAristas());
		
	}
	
	

	
	
	
	
	
	
}
