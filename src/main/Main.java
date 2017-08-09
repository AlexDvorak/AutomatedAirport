package main;

import enums.C;

public class Main {
	public static void main(String[] args) {
		double[] ans = C.coordsPlusDistance(50, 60, 0, 50000);
		System.out.println("LAT: "+ans[0]+" - LONG: "+ans[1]);
	}
}