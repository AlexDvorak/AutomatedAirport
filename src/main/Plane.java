package main;

import enums.PlaneStatus;
import enums.RadioMessage;

public class Plane {
	public double lat, lon;
	public int altitude;
	public float airspeed;
	public float heading;
	public float roll;
	public float pitch;
	public int fuel;
	
	private float throttle;
	private float elevators;
	private float ailerons;
	private float flaps;
	
	public ComChannel com1, com2;
	
	public Flight flight;
	public Flight[] nextFlights;
	public PlaneStatus status;
	public Airport airport;
	public PlaneSurface location;
	
	public int maxSpeed;
	public int maxFuel;
	public double nmpg;
	public float acceleration;
	public int readyTime;

	public int baseWeight;
	public int maxWeight;
	public int loadWeight;
	public int weight;
	
	private int planeSurfaceKey;
	
	public Plane(Gate gate) {
		this.airport = gate.airport;
		this.location = gate;
		this.status = PlaneStatus.GATE;
		this.lat = gate.lat;
		this.lon = gate.lon;
		this.airspeed = 0;
		this.heading = gate.dir;
	}
	
	public RadioMessage receiveMessage(ComChannel channel, RadioMessage msg, double[] args) {
		switch(msg) {
			default:
				return RadioMessage.REPEAT;
		}
	}
	public RadioMessage sendMessage(ComChannel channel, RadioMessage msg, double[] args) {
		return channel.receiveMessage(this, msg, args);
	}
	
	private void getOn(PlaneSurface place) {
		this.location = place;
		planeSurfaceKey = place.planeOn(this);
	}
	private void getOff(PlaneSurface place) {
		this.location.planeOff(planeSurfaceKey);
		this.location = null;
	}
	
	public void addFlight(Flight flight) {
		synchronized(nextFlights) {
			nextFlights[nextFlights.length] = flight;
		}
	}
	
	public void start() {
		while(true) {
			while(nextFlights[0] == null) {
				Thread.sleep(1000);
			}
		}
	}
}