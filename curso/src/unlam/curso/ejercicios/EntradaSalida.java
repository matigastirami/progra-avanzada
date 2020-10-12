package unlam.curso.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EntradaSalida {

	public static void main(String[] args) {
		generarArchivoNumerosRandom();
		procesarArchivoEImprimir();
	}

	public static void generarArchivoNumerosRandom() {

		int minQuantity = 10000, maxQuantity = 20000,
				rand = (int) (Math.random() * (maxQuantity - minQuantity + 1) + minQuantity);

		try {
			File f = new File("random.txt");

			if (!f.exists()) {
				f.createNewFile();
			}

			FileWriter fw = new FileWriter(f);

			for (int i = 0; i < rand; i++) {
				int num = (int) (Math.random() * 12000);
				fw.write(new Integer(num).toString() + '\n');
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] archivoAVector(File f) {
		int fLength = (int) f.length();
		int[] result = new int[fLength];
		String linea;
		int i = 0;

		try {

			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				int num = Integer.parseInt(linea);
				result[i] = num;
				i++;
			}

			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}

	public static int obtenerMayor(int[] v) {
		int mayor = v[0];

		for (int i = 0; i < v.length; i++) {
			if (v[i] > mayor) {
				mayor = v[i];
			}
		}

		return mayor;
	}

	public static int obtenerMenor(int[] v) {
		int menor = v[0];

		for (int i = 0; i < v.length; i++) {
			if (v[i] < menor) {
				menor = v[i];
			}
		}

		return menor;
	}

	public static int obtenerPromedio(int[] v) {
		int acum = 0;

		for (int i = 0; i < v.length; i++) {
			acum += v[i];
		}

		return acum / v.length;
	}

	public static void procesarArchivoEImprimir() {
		File f = new File("random.txt");
		int[] values = archivoAVector(f);

		System.out.println("+----------+-------+");
		System.out.printf("| Máximo   | %5d |\n", obtenerMayor(values));
		System.out.println("+----------+-------+");
		System.out.printf("| Mínimo   | %5d |\n", obtenerMenor(values));
		System.out.println("+----------+-------+");
		System.out.printf("| Promedio | %5d |\n", obtenerPromedio(values));
		System.out.println("+----------+-------+");
	}

}
