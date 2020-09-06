package unlam.curso.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.curso.ejercicios.Ejercicio00;

public class Ejercicio00Test {

	@Test
	public void shouldReturnTrue() {
		Ejercicio00 ej = new Ejercicio00();
		
		int[][] m = {
			{1,2,3},
			{4,1,6},
			{7,8,2}
		};
		
		assertEquals(true, ej.solution(m));
	}
	
	@Test
	public void shouldReturnFalse() {
		Ejercicio00 ej = new Ejercicio00();
		
		int[][] m = {
			{1,2,3},
			{4,2,6},
			{7,8,2}
		};
		
		assertEquals(false, ej.solution(m));
	}

}
