
public class EjercicioValidacion {
	
	public static void main(String[] args) {
		int[] v = {1,2,3,4,5,6,7,8};
		
		try {
			resolucion(v, 2);
			mostrar(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void mostrar(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}
	}

	/*
	 * Idea del ejercicio: "Rotar un vector" respecto a un número M pasado por parámetro
	 * */
	public static void resolucion(int[] v, int m) throws Exception {
		
		
		int cantElementos = v.length;
		int cantLugares = cantElementos - (m + 1);
		
		if(m >= cantElementos) {
			throw new Exception("M debe ser menor a N");
		}
		
		for (int i = 0; i < m + 1; i++) {
			int aux = v[i];
			v[i] = v[cantLugares + i];
			v[cantLugares + i] = aux;
		}
		
		if(cantElementos % 2 != 0) {
			int aux = v[cantElementos - 1];
			v[cantElementos - 1] = v[cantElementos - 2];
			v[cantElementos - 2] = aux;
		}
	}
}
