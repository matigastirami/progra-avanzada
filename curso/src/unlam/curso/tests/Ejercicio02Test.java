package unlam.curso.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import unlam.curso.ejercicios.Ejercicio02;

public class Ejercicio02Test {
	
	@Test
	public void shouldReturnTheMatrixAdjacentPositionsSum() {
		
		Ejercicio02 ej = new Ejercicio02();
		
		int[][] inputMatrix = new int[][]{
			{8,2,-3,4},
			{5,-6,-6,20},
			{21,1,-5,0}
		};
		
		int[][] expectedOutput = new int[][]{
			{15,1,-3,21},
			{28,-4,0,18},
			{27,11,-10,15}
		};
		
		
		
		assertArrayEquals(expectedOutput, ej.getAdjacentSum(inputMatrix));
	}
	
	
	@Test
	public void testRevisionLoom1() {
		Ejercicio02 ej = new Ejercicio02();
		
		int[][] inputMatrix = new int[][]{
			{8,2,-3,4},
			{5,-6,-6,20},
			{21,1,-5,0}
		};
		
		int[][] auxM = new int[3][4];
		
		int[][] expectedOutput = new int[][]{
			{15,1,-3,21},
			{28,-4,0,18},
			{27,11,-10,15}
		};
		
		ej.SumarCiertosElementosDEeMatriz(inputMatrix, auxM);
		
		assertArrayEquals(expectedOutput, auxM);
	}
}
