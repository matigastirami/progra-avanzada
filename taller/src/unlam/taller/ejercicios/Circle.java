package unlam.taller.ejercicios;

import unlam.taller.lib.Punto;

public class Circle {

	private Punto center;
	private double radius;

	public Circle(Punto center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public Punto getCenter() {
		return this.center;
	}

	public double getRadius() {
		return this.radius;
	}

	public boolean intersectWith(Circle c) {

		double distance = Math.sqrt(Math.pow(this.center.getX() - c.getCenter().getX(), 2)
				+ Math.pow(this.center.getY() - c.getCenter().getY(), 2));

		if (distance == 0 && this.radius != c.getRadius())
			return false;

		return distance <= this.radius + c.getRadius();
	}
}
