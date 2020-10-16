package eda.circulo.ejercicio4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirculoTest {

	@Test(expected = RadioNoValidado.class)
	public void debeArrojarExcepcionSiElRadioEsNulo() {
		new Circulo(null);
	}
	
	@Test(expected = RadioNoValidado.class)
	public void debeArrojarExcepcionSiElRadioEsMenorOIgualACero() {
		new Circulo(0);
	}

}
