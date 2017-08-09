package main;

import enums.PlaneStatus;

public class Plane {
	public double lat, lon;
	public float airspeed;
	public float heading;
	public int fuel;
	
	public ComChannel com1, com2;
	public NavChannel nav1, nav2;
	
	public Flight flight;
	public PlaneStatus status;
	public Taxiway taxiway;
	public Gate gate;
	public Runway runway;
	public Airport airport;
	
	public int maxSpeed;
	public int maxFuel;
	public double nmpg;
	public int readyTime;
	
	public Plane(Gate gate) {
		this.airport = gate.airport;
		this.gate = gate;
		this.status = PlaneStatus.GATE;
		this.lat = gate.lat;
		this.lon = gate.lon;
		this.airspeed = 0;
		this.heading = gate.dir;
	}
}