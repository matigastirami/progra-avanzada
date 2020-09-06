package unlam.curso.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.curso.ejercicios.Ejercicio01;

public class Ejercicio01Test {

	@Test
	public void shouldReturnTrueIfMatrixHasAZero() {
		
		Ejercicio01 ej = new Ejercicio01();
		
		int[][] m = {
			{1,2,3},
			{4,0,6},
			{7,1,2}
		};
		
		assertEquals(true, ej.solution(m));
	}
	
	@Test
	public void shouldReturnFalseIfMatrixDoesNotHaveAZero() {
		
		Ejercicio01 ej = new Ejercicio01();
		
		int[][] m = {
			{1,2,3},
			{4,5,6},
			{7,1,2}
		};
		
		assertEquals(false, ej.solution(m));
	}

}
