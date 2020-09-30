package unlam.taller.ejercicios;

public class PonyExpress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jinetes(new int[] {100, 1}));
	}

	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 * extremo hasta el otro del recorrido
	 */
	public static int jinetes(int[] estaciones) { 
		int millasAcumuladas = 0;
		int cantJinetes = 1; //Al menos voy a usar 1
		int dist;		
		
		for (int i = 0; i < estaciones.length; i++) {
			if(estaciones[i] > 100) {
				return -1;
			}
			else if((dist = millasAcumuladas + estaciones[i]) > 100 ) {
				cantJinetes++;
				millasAcumuladas = estaciones[i];
			}
			else {
				millasAcumuladas = dist;
			}
		}		
		return cantJinetes;
	}
}
