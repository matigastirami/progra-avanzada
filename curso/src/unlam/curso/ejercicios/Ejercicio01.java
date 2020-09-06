package unlam.curso.ejercicios;

public class Ejercicio01 {
	
	public boolean solution(int[][] m) {
		
		for (int[] row : m) {
			for (int cell : row) {
				if(cell == 0)
					return true;
			} 
		}
		
		return false;
	}
}
