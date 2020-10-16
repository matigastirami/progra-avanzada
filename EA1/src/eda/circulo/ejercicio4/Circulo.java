package eda.circulo.ejercicio4;

public class Circulo {

	private Punto p;
	private int radio;
	
	public Circulo(Integer radio) {
		this.p = new Punto(0,0);
		
		if(radio == null || radio <= 0) {
			throw new RadioNoValidado("Radio inválido", null);
		}
		
		this.radio = radio;
	}
}
