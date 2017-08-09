package main;

public class Gate {
	public Airport airport;
	public String name;
	public double lat, lon;
	public int dir;
	
	public Gate(Airport airport, String name, double lat, double lon, int dir) {
		this.airport = airport;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.dir = dir;
	}
}