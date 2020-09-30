package unlam.curso.ejercicios;

public class ArraysOperations {

	
	public static void main(String[] args) {
		int[] v = {1,2,3,4,5,6,7,8};
		
		System.out.println(encontrarMitadSumasIgualesIzqYDer(v));
		
		int[] v1 = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(encontrarMitadSumasIgualesIzqYDer(v1));
		
		int[] v2 = {2,2,1,1};
		
		System.out.println(encontrarMitadSumasIgualesIzqYDer(v2));
	}
	
	public static int encontrarMitadSumasIgualesIzqYDer(int[] v) {
		
		for (int i = 1; i < v.length - 1; i++) {
			int sumDerecha = 0, sumIzquierda = 0;
			
			for (int j = 0; j < i; j++) {
				sumDerecha += v[j];
			}
			
			for (int j = i + 1; j < v.length; j++) {
				sumIzquierda += v[j];
			}
			
			if(sumDerecha == sumIzquierda) return v[i];
		}
		
		return -1;
	}
}
