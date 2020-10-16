package oia.zapatos.ejercicio1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilasCajasTest {

	@Test
	public void debeArmarPilasDe2CajasCadaUna() {
		PilasCajas p1 = new PilasCajas(8, new int[] {0,1,2,1,3,4,2,3});
		
		int cantMovimientos = p1.zapatos();
		
		assertEquals(4, cantMovimientos);
	}
	
	@Test
	public void debeArmarPilasDe5CajasCadaUna() {
		PilasCajas p1 = new PilasCajas(7, new int[] {3,6,4,8,6,6,2}); 
		
		int cantMovimientos = p1.zapatos();
		
		assertEquals(6, cantMovimientos);
	}
	
	@Test
	public void debeRetonarCeroSiYaEstanOrdenadas() {
		PilasCajas p1 = new PilasCajas(2, new int[] {1,1}); 
		
		int cantMovimientos = p1.zapatos();
		
		assertEquals(0, cantMovimientos);
	}
	
	@Test
	public void debeRetonarUnoSiSoloSeDesordenoUnaCaja() {
		PilasCajas p1 = new PilasCajas(2, new int[] {0,2}); 
		
		int cantMovimientos = p1.zapatos();
		
		assertEquals(1, cantMovimientos);
	}
	
	@Test
	public void debeRetonarCeroSiNoHayCajas() {
		PilasCajas p1 = new PilasCajas(7, new int[] {0,0,0,0,0,0,0}); 
		
		int cantMovimientos = p1.zapatos();
		
		assertEquals(0, cantMovimientos);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void debeDarErrorConCantPilasDiferenteAlArray() {
		new PilasCajas(7, new int[] {3,6,4,8,6,6});
	}

}
