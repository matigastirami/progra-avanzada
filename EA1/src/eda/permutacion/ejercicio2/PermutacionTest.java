package eda.permutacion.ejercicio2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermutacionTest {

	@Test
	public void debeRetornarTrue() {
		assertTrue(Permutacion.esPermutacion(new int[] {1,3,0,4,2}));
		assertTrue(Permutacion.esPermutacion(new int[] {0,1,2,3,4}));
		assertTrue(Permutacion.esPermutacion(new int[] {4,3,2,1,0}));
	}
	
	@Test
	public void debeRetornarFalse() {
		assertFalse(Permutacion.esPermutacion(new int[] {1,3,0,4,6}));
		assertFalse(Permutacion.esPermutacion(new int[] {1,1,0,4,2}));
		assertFalse(Permutacion.esPermutacion(new int[] {1,3,0,8,2}));
	}

}
