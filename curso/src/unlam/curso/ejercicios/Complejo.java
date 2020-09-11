package unlam.curso.ejercicios;

public class Complejo {

	private double real, imag;
	
	public Complejo(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	@Override
	public String toString() {
		return "Complejo [real=" + real + ", imag=" + imag + "]";
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public Complejo sum(Complejo c) {
		return new Complejo(this.real + c.getReal(), this.imag + c.getImag());
	}
	
	
}
