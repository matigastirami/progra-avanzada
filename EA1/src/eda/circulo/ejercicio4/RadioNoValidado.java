package eda.circulo.ejercicio4;

public class RadioNoValidado extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RadioNoValidado(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}