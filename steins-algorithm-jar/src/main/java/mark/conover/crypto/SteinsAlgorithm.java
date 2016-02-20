package mark.conover.crypto;

import java.util.Scanner;

/**
 * Determines greatest common divisor (gcd) for two integers using Stein's
 * algorithm.
 * 
 * @author http://www.sanfoundry.com/java-program-stein-gcd-algorithm/
 */
public class SteinsAlgorithm {

	/** Main function **/
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Stein GCD Algorithm Test\n");

		/** Make an object of SteingGcd class **/
		SteinsAlgorithm steinsAlgorithm = new SteinsAlgorithm();

		/** Accept two integers **/
		System.out.println("Enter two integer numbers\n");
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();

		/** Call function gcd of class SteinGcd **/
		int gcd = steinsAlgorithm.gcd(n1, n2);
		System.out.println("GCD of " + n1 + " and " + n2 + " = " + gcd);
	}

	/** Function to calculate gcd **/
	public int gcd(int u, int v) {

		int shift;

		if (u == 0) {
			return v;
		}

		if (v == 0) {
			return u;
		}

		for (shift = 0; ((u | v) & 1) == 0; ++shift) {
			u >>= 1;
			v >>= 1;
		}

		while ((u & 1) == 0) {
			u >>= 1;
		}

		do {

			while ((v & 1) == 0) {
				v >>= 1;
			}

			if (u > v) {
				int t = v;
				v = u;
				u = t;
			}

			v = v - u;

		} while (v != 0);

		return u << shift;
	}
}