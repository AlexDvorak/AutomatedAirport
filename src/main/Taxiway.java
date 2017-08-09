package main;

import enums.C;

public class Taxiway {
	public double lat, lon;
	public double endLat, endLon;
	public int width, length;
	public int dir;
	public String name;
	public Airport airport;
	public Taxiway[] otherWays;
	public Gate[] gates;
	public Plane[] planes;
	
	public Taxiway(Airport airport, String name, double lat, double lon, int dir, int width, int length) {
		this.airport = airport;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.dir = dir;
		double[] endCoords = C.coordsPlusDistance(lat, lon, dir, length);
		this.endLat = endCoords[0];
		this.endLon = endCoords[1];
		this.width = width;
		this.length = length;
	}
	
	public int planeOn(Plane plane) {
		synchronized(this) {
			int key = planes.length;
			planes[key] = plane;
			return key;
		}
	}
	public void planeOff(int key) {
		synchronized(this) {
			planes[key] = null;
		}
	}
}