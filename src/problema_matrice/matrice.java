package problema_matrice;

//import java.util.Collections;
import java.util.Scanner;

public class matrice {

	public static void main(String[] args) {
		int q = 0, w = 0, e = 0, r = 0;
		int[][] p;
		// TODO Auto-generated method stub
		System.out.println();
		p = citire(dimensiuni());

		q = maxim_diag(p, 3);
		// System.out.println(q);
		w = maxim_diag_s(p, 3);
		e = maxim_coloana(p, 3);
		r = maxim_linie(p, 3);
		maxim_maxim(q, w, e, r);
	}

	public static int dimensiuni() {
		int n;
		System.out.println("dati dimentiunea matricii: ");
		Scanner a = new Scanner(System.in);
		n = a.nextInt();
		// a.close();
		return n;
	}

	public static int[][] citire(int n) {
		Scanner x = new Scanner(System.in);
		int[][] patrat = new int[n][n];
		System.out.println("Dati valorile matricii: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				patrat[i][j] = x.nextInt();
			}
		}
		System.out.println("Matricea este:");
		for (int i = 0; i < n; i++) {
			// System.out.print(patrat[i][]);
			for (int j = 0; j < n; j++) {
				System.out.print(patrat[i][j] + " ");
			}
			System.out.println();
		}
		x.close();
		return patrat;

	}

	public static int maxim_diag(int[][] patrat, int n) {
		int max = 0, x = 0, y = 0, prod = 1, i = 0, j = 0, a = 0;
		while ((i < patrat.length) && (j < patrat.length) && (a < 2)) {

			for (i = 0; i <= patrat.length - n; i++) {
				for (j = 0; j <= patrat.length - n; j++) {
					x = i;
					y = j;
					if (x == 0 && y == 0) {
						a++;
					}
					prod = 1;
					while (x < i + n && y < j + n) {

						prod *= patrat[x][y];
						if (prod > max) {
							max = prod;
						}
						x++;
						y++;
					}
				}
			}

		}
		return max;
	}

	public static int maxim_diag_s(int[][] patrat, int n) {
		int max1 = 0, x = 0, y = 0, prod = 1, i = 0, j = 0, a = 0;
		while ((i < patrat.length) && (j < patrat.length) && (a < 2)) {

			for (i = 0; i <= patrat.length - n; i++) {
				for (j = patrat.length - 1; j >= patrat.length - n; j--) {
					x = i;
					y = j;
					if (x == 0 && y == patrat.length - 1) {
						a++;
					}
					prod = 1;
					while (x < i + n && y > j - n && (a < 2)) {

						prod *= patrat[x][y];
						if (prod > max1) {
							max1 = prod;
						}
						x++;
						y--;
					}
				}
			}

		}
		return max1;
	}

	public static int maxim_linie(int[][] patrat, int n) {
		int max2 = 0, x = 0, y = 0, prod = 1, i = 0, j = 0, a = 0;
		while ((i < patrat.length) && (j < patrat.length)) {

			for (i = 0; i < patrat.length; i++) {
				for (j = 0; j <= patrat.length - n; j++) {
					x = i;
					y = j;
					if (x == 0 && y == 0) {
						a++;
					}
					prod = 1;
					while (x < patrat.length && y < j + n && (a < 2)) {

						prod *= patrat[x][y];
						if (prod > max2) {
							max2 = prod;
						}
						y++;
					}

				}
			}

		}
		return max2;
	}

	public static int maxim_coloana(int[][] patrat, int n) {
		int max3 = 0, x = 0, y = 0, prod = 1, i = 0, j = 0, a = 0;
		while ((i < patrat.length) && (j < patrat.length)) {

			for (i = 0; i <= patrat.length - n; i++) {
				for (j = 0; j < patrat.length; j++) {
					x = i;
					y = j;
					if (x == 0 && y == 0) {
						a++;
					}
					prod = 1;
					while (x < i + n && y < patrat.length && (a < 2)) {

						prod *= patrat[x][y];
						if (prod > max3) {
							max3 = prod;
						}
						x++;
					}

				}
			}

		}
		
		return max3;
	}

	public static void maxim_maxim(int max, int max1, int max2, int max3) {
		System.out.println(max + " " + max1 + " " + max2 + " " + max3);

		if (max < max1) {
			max = max1;
			if (max1 > max2 && max1 > max3) {
				System.out
						.println("Produsul maxim se afla pe diagonala secundara si este = "
								+ max);
			}
		} else if (max < max2) {
			max = max2;
			if (max2 > max3) {
				System.out
						.println("Produsul maxim se afla pe coloana si este = "
								+ max);
			}
		} else if (max < max3) {
			max = max3;
			System.out.println("Produsul maxim se afla pe linie si este = "
					+ max);
		} else {
			System.out.println("Produsul maxim se afla pe diagonala principala si este = "
							+ max);
		}

	}
}
