package unlam.curso.ejercicios;

public class Ejercicio02 {
	
	public void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public int[][] getAdjacentSum(int[][] m){
			
		int quantityRows = m.length,
			quantityCols = m[0].length;
		
		int[][] aux = new int[quantityRows][quantityCols];
		
		for(int i = 0; i < quantityRows; i++) {
			for (int j = 0; j < quantityCols; j++) {
				
				int partialSum = m[i][j];
				
				if(i == 0) {
					partialSum += m[i + 1][j];
				}
				else if(i == quantityRows - 1) {
					partialSum += m[i - 1][j];
				}
				else if(i > 0 && i < quantityRows - 1) {
					partialSum += m[i + 1][j] + m[i - 1][j];
				}
				
				if(j == 0) {
					partialSum += m[i][j + 1];
				}
				else if(j == quantityCols - 1) {
					partialSum += m[i][j - 1];
				}				
				else if(j > 0 && j < quantityCols - 1) {
					partialSum += m[i][j + 1] + m[i][j - 1];
				}
				
				aux[i][j] = partialSum;
			}
		}
		
		return aux;
	}
	
	public void SumarCiertosElementosDEeMatriz(int mat[][], int matRes[][]) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				int acum = mat[i][j];
				if (i > 0)
					acum += mat[i - 1][j];
				if (j > 0)
					acum += mat[i][j - 1];
				if (i < mat.length - 1)
					acum += mat[i + 1][j];
				if (j < mat[i].length - 1)
					acum += mat[i][j + 1];

				matRes[i][j] = acum;
			}
		}
	}

}
