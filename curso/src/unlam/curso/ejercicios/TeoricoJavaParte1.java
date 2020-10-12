
import java.util.*;

public class TeoricoJavaParte1 {
	private String title;
	private int value;

	public TeoricoJavaParte1() {
		this.title += " World";
	}

	public TeoricoJavaParte1(int value) {
		this.value = value;
		this.title = "Hello ";
		new TeoricoJavaParte1();
	}

	public static void main(String[] args) {
		TeoricoJavaParte1 c = new TeoricoJavaParte1(5);
		System.out.println(c.title);
	}
}