
public class Ejercicio00 {

	public static void main(String[] args) {		
		/* This matrix meets the requirement */
		
		int[][] m1 = {
			{1,2,3},
			{4,1,6},
			{7,8,2}
		};
		
		System.out.println(Ejercicio00.matrixMeetRequirement(m1));
		
		/* This matrix doesn't meet the requirement */
		
		int[][] m2 = {
			{1,2,3},
			{4,2,6},
			{7,8,2}
		};
		
		System.out.println(Ejercicio00.matrixMeetRequirement(m2));
	}
	
	public static int getMainDiagonalSumUntilPosition(int[][] m, int positionTo) {
		int sum = 0;
		
		for(int i = 0; i < positionTo; i++) {
			sum += m[i][i];
		}
		
		return sum;
	}
	
	public static boolean matrixMeetRequirement(int[][] m) {
		
		for(int i = 1; i < m[0].length; i++) {
			System.out.println(Ejercicio00.getMainDiagonalSumUntilPosition(m, i - 1));
			if(m[i][i] != 1) {
				return false;
			}
		}
		
		return true;
	}

}
