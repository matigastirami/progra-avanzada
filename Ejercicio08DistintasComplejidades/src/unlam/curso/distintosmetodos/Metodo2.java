package unlam.curso.distintosmetodos;

import javax.swing.JOptionPane;

/*
 * Complejidad de la primera solución es n*log(n) ya que se usa el algoritmo de quicksort O(n*log(n))
 * 
 * */
public class Metodo2 {
	public static void main(String[] args) {
		int vector[] = new int[10];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "º Numero :", 0));
		}
		String Cadena = "Numeros Sin Ordernar \n";
		for (int i = 0; i < vector.length; i++) {
			Cadena = Cadena + vector[i] + "    ";
		}
		quickSort(vector, 0, vector.length - 1);
		Cadena = Cadena + "\nNumeros Impares Ordenados De Forma Ascendente";
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 != 0) {
				Cadena = Cadena + "\n" + vector[i];
			}
		}
		JOptionPane.showMessageDialog(null, Cadena);

	}

	static int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); 
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
}
