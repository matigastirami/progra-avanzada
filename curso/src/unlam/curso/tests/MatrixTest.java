package unlam.curso.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.curso.ejercicios.Matrix;

public class MatrixTest {

	@Test
	public void getModesWorks() {		
		// TODO Auto-generated method stub
		int[][] m = {
				{1,2,3,4},
				{5,-6,-6,10},
				{10,1,1,10}
		};
		
		int[] modes = Matrix.getModeByEachRow(m);
		
		int[] expected = {
			4, -6, 10
		};
		
		
		assertArrayEquals(expected, modes);
	}

}
