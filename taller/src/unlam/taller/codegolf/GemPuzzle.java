package unlam.taller.codegolf;

public class GemPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {
				{3,2,0},
				{1,4,5},
				{6,7,8}
		};

		int[][] m1 = {
				{1,2,3},
				{6,5,4},
				{8,0,7}
		};

		int[][] m2 = {
				{1,8,2},
				{0,3,4},
				{7,6,5}
		};

		System.out.println(validPuzzle(m));
		System.out.println(validPuzzle(m1));
		System.out.println(validPuzzle(m2));
	}

	public static boolean validPuzzle(int[][] m) {
		int l = m.length, k = 0, f = 0, h = l * l, i = 0, j, u;

		for (; i < h; i++)
			for (j = 0; j <= i; j++) {
				u = m[i / l][i % l];
				if (u == 0)
					f = j / l + 1;
				else if (m[j / l][j % l] > u)
					k++;
			}

		j = k % 2;

		return l % 2 == 0 ? f % 2 != 0 ? j != 0 : j == 0 : j == 0;
	}

	/*if(q % 2 != 0) return n == 0;

	if(x % 2 != 0) return n != 0;
	else return n == 0;*/
}
