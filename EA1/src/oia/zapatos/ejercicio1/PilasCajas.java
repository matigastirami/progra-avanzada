package oia.zapatos.ejercicio1;

public class PilasCajas {
	
	private int cantPilas;
	private int[] configCajas;
	private int cantCajasPorPila;
	
	public PilasCajas(int p, int[] cajas) {
		this.cantPilas = p;
		this.configCajas = cajas;
		
		if(p != cajas.length) {
			throw new IllegalArgumentException("La cantidad de pilas debe coincidir con la longitud de la colección de cajas");
		}
		
		this.cantCajasPorPila = Math.round(this.sumaCajas(cajas) / this.cantPilas);
	}
	
	// Complejidad O(n)
	public int sumaCajas(int[] v) {
		int acum = 0;
		
		for (int i = 0; i < v.length; i++) {
			acum += v[i];
		}
		
		return acum;
	}
	
	//Complejidad O(n)
	public int zapatos() {
		int cantMovimientos = 0, posiblesMovimientosEnPosicionActual;
		
		for (int i = 0; i < configCajas.length; i++) { // O(n)
			posiblesMovimientosEnPosicionActual = configCajas[i] - this.cantCajasPorPila; //O(1)
			cantMovimientos += (posiblesMovimientosEnPosicionActual > 0 ? posiblesMovimientosEnPosicionActual : 0); //O(1)
		}
		
		return cantMovimientos;
	}

}
