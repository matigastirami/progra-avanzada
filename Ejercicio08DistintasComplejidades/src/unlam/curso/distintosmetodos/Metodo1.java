package unlam.curso.distintosmetodos;

import javax.swing.JOptionPane;
/*
 * Complejidad de la primera soluci�n es cuadr�trica ya que se usa el algoritmo de inserci�n O(n^2)
 * 
 * */
public class Metodo1 {
	public static void main(String[] args) {
		int vector[] = new int[10];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "� Numero :", 0));
		}
		String Cadena = "Numeros Sin Ordernar \n";
		for (int i = 0; i < vector.length; i++) {
			Cadena = Cadena + vector[i] + "    ";
		}
		Insercion(vector);
		Cadena = Cadena + "\nNumeros Impares Ordenados De Forma Ascendente";
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 != 0) {
				Cadena = Cadena + "\n" + vector[i];
			}
		}
		JOptionPane.showMessageDialog(null, Cadena);

	}

	
	public static void Insercion(int[] vector) {
		for (int i = 1; i < vector.length; i++) {
			int aux = vector[i];
			int j;
			for (j = i - 1; j >= 0 && vector[j] > aux; j--) {
				vector[j + 1] = vector[j];
			}
			vector[j + 1] = aux;
		}
	}
}
