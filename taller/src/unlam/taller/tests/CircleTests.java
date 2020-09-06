package unlam.taller.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.taller.ejercicios.Circle;
import unlam.taller.lib.Punto;

public class CircleTests {

	@Test
	public void circleIntersects() {
		Circle c1 = new Circle(new Punto(2, 3), 12);
		Circle c2 = new Circle(new Punto(15, 28), 18);

		boolean intersects = c1.intersectWith(c2);

		assertEquals(true, intersects);
	}

	@Test
	public void circleInsideOther() {
		Circle c1 = new Circle(new Punto(2, 3), 12);
		Circle c2 = new Circle(new Punto(2, 3), 10);

		boolean intersects = c1.intersectWith(c2);

		assertEquals(false, intersects);
	}

	@Test
	public void circlesDoNotIntersect() {
		Circle c1 = new Circle(new Punto(2, 3), 1);
		Circle c2 = new Circle(new Punto(2, 15), 1);

		boolean intersects = c1.intersectWith(c2);

		assertEquals(false, intersects);
	}

}
