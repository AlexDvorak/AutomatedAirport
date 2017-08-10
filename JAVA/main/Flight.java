package main;

import enums.FlightStatus;

public class Flight {
	public String airline;
	public int num;
	public String flightNum;
	public Airport from, to;
	public Gate fromG, toG;
	public Plane plane;
	public long sStart, sEnd, eStart, eEnd;
	public int delay = 0;
	public FlightStatus status;
	
	public Flight(Plane plane, String airline, int num, Airport from, Airport to, Gate fromG, Gate toG, long startTime, long flightTime) {
		this.plane = plane;
		this.airline = airline;
		this.num = num;
		this.flightNum = airline + num;
		this.from = from;
		this.to = to;
		this.fromG = fromG;
		this.toG = toG;
		this.sStart = startTime;
		this.sEnd = this.sStart + flightTime;
		this.eStart = this.sStart;
		this.eEnd = this.sEnd;
		this.status = FlightStatus.ONTIME;
	}
	
	public void update(FlightStatus status) {
		this.status = status;
	}
	
}