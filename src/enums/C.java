package enums;

public class C {
	public static final long timeBetweenFlights = 1000000;
	
	public static final int earthRadiusKM = 6371;
	
	
	public static double[] coordsPlusDistance(double lat, double lon, double dirDEG, double distFT) {
		double latRAD = Math.toRadians(lat);
		double lonRAD = Math.toRadians(lon);
		double distKM = FTtoKM(distFT);
		double dr = distKM/earthRadiusKM;
		double dirRAD = Math.toRadians(dirDEG);
		double newLat = Math.asin(Math.sin(latRAD)*Math.cos(dr) + Math.cos(latRAD)*Math.sin(dr)*Math.cos(dirRAD));
		double newLong = lonRAD + Math.atan2(Math.sin(dirRAD)*Math.sin(dr)*Math.cos(latRAD), Math.cos(dr)-Math.sin(latRAD)*Math.sin(newLat));
		return new double[] {Math.toDegrees(newLat), Math.toDegrees(newLong)};
	}
	
	public static double KMtoNM(double KM) {
		return KM * 0.539957;
	}
	public static double NMtoKM(double NM) {
		return NM / 0.539957;
	}
	public static double NMtoFT(double NM) {
		return NM * 6076.12;
	}
	public static double FTtoNM(double FT) {
		return FT / 6076.12;
	}
	public static double KMtoFT(double KM) {
		return KM * 3280.8399;
	}
	public static double FTtoKM(double FT) {
		return FT / 3280.8399;
	}
}