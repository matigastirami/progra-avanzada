package unlam.curso.ejercicios;

public class Matrix {
	
	public static int countOcurrences(int[] v, int elem) {
		int count = 0;
		
		for (int i = 0; i < v.length; i++) {
			if(v[i] == elem) count++;
		}
		
		return count;
	}
	
	public static boolean elementExists(int[] v, int elem) {
		for (int i = 0; i < v.length; i++) {
			if(v[i] == elem) return true;
		}
		
		return false;
	}
	
	public static int[] getModeByEachRow(int[][] m) {
		int rowLength = m[0].length;
		int[] result = new int[m.length];
		int rowMode = -1;
		int maxOcurrences = 1;
		int[] ocurredInCurrentIteration = new int[rowLength];
		
		for(int i = 0; i < m.length; i++) {
			for (int j = 0; j < rowLength; j++) {
				if(elementExists(ocurredInCurrentIteration, m[i][j])) continue;
				else {
					ocurredInCurrentIteration[j] = m[i][j];
					int repetitions = countOcurrences(m[i], m[i][j]);
					
					if(repetitions > maxOcurrences) {
						rowMode = m[i][j];
						maxOcurrences = repetitions;
					}
					else if(repetitions == maxOcurrences) {
						rowMode = rowMode > m[i][j] ? rowMode : m[i][j];
					}
				}
			}
			result[i] = rowMode;
			ocurredInCurrentIteration = new int[rowLength];
		}
		
		return result;
		
	}

}
