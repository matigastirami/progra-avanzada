package unlam.taller.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.taller.ejercicios.PonyExpress;

public class PonyExpressTest {

	@Test
	public void distanciaEntreEstacionesValida() {
		
		assertEquals(1, PonyExpress.jinetes(new int[] {18, 15}));
		assertEquals(2, PonyExpress.jinetes(new int[] {43, 23, 40, 13}));
		assertEquals(3, PonyExpress.jinetes(new int[] {33, 8, 16, 47, 30, 30, 46}));
		assertEquals(3, PonyExpress.jinetes(new int[] {51, 51, 51}));
		assertEquals(4, PonyExpress.jinetes(new int[] {6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49}));
	}
	
	@Test
	public void distanciaEntreEstacionesIncorrecta() {
		assertEquals(-1, PonyExpress.jinetes(new int[] {101}));
	}

}
