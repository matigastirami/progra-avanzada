package unlam.curso.ejercicios;

public class Matrix {
	
	public static void main(String args[]) {
		int[][] m = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		weirdPrint(m);
	}
	
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

	public static void weirdPrint(int[][] m) {
		
		   for (int i = m[0].length - 1; i > 0; i--) {
		       for (int j = 0, x = i; x <= m.length - 1; j++, x++) {
		    	   System.out.print(m[x][j] + " ");
		          
		       }
		       System.out.println("");
		   }


		   for (int i = 0; i <= m.length - 1; i++) {
		        for (int j = 0, y = i; y <= m[0].length - 1; j++, y++) {
		        	System.out.print(m[j][y] + " ");
		        }
		        System.out.println("");
		   }
	}
}
