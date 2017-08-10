package main;

public class Gate implements PlaneSurface {
	public Airport airport;
	public String name;
	public double lat, lon;
	public int dir;
	public Plane occupant;
	public Taxiway[] connectedTaxiways;
	
	public Gate(Airport airport, String name, double lat, double lon, int dir) {
		this.airport = airport;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
		this.dir = dir;
	}
	
	public int planeOn(Plane plane) {
		synchronized(this) {
			if(occupant == null) {
				return -1;
			} else {
				occupant = plane;
				return 0;
			}
		}
	}
	public void planeOff(int key) {
		occupant = null;
	}
}