package unlam.curso.ejercicios;

public class Ejercicio00 {
	
	private int getArraySumUpToIndex(int[] a, int idx) {
		
		int sum = 0;
		
		for(int i = 0; i < a.length && i <= idx; i++) {
			sum += a[i];
		}
		
		return sum;
	}

	public boolean solution(int[][] m) {
		
		int rowLen = m[0].length;
		int[] diagPpal = new int[rowLen];
		
		for(int i = 0; i < rowLen; i++) {
			diagPpal[i] = m[i][i];
		}
		
		for(int i = 1; i < rowLen; i++) {
			if(diagPpal[i] != this.getArraySumUpToIndex(diagPpal, i - 1)) {
				return false;
			}
		}
		
		return true;
	}
}
