package eda.permutacion.ejercicio2;

import java.util.HashSet;
import java.util.Set;

public class Permutacion {

	//Complejidad O(n) (Se usa set que sus operaciones básicas tienen complejidad O(1)
	static boolean esPermutacion(int[] vec) {
		Set<Integer> set = new HashSet<Integer>();
		int n = vec.length;

		int maxEle = 0; //O(1)

		for (int i = 0; i < n; i++) { //O(n)
			set.add(vec[i]); // O(1)
			maxEle = Math.max(maxEle, vec[i]); // O(1)
		}

		if (maxEle != n -1)
			return false;

		if (set.size() == n)
			return true;

		return false;
	}

}
