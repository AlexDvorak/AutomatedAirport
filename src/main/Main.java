package main;

import java.util.HashMap;
import java.util.Map;

import enums.C;
import enums.ComChannelName;

public class Main {
	private Plane[] planes;
	private Airport[] airports;
	
	public static void main(String[] args) {
		(new Main()).start();
	}
	
	public void start() {
		// ADD AIRPORTS
		Map<ComChannelName, ComChannel> channelMap = new HashMap<>();
		addAirport("George Bush Intercontinental Airport", "KIAH", 29.9902, 95.3368, null, null, null, channelMap);
		
		// ADD PLANES
		for(int i=0; i<10; i++) {
			addPlane("N000"+i, airports[0].gates[i]);
		}
		
		// ADD FLIGHTS
		C.runAsync(new Runnable() {
			public void run() {
				FlightScheduler.schedule(planes);
			}
		});
	}
	
	private void addPlane(String tailSign, Gate gate) {
		planes[planes.length] = new Plane(tailSign, gate);
	}
	private void addAirport(String name, String id, double lat, double lon, Taxiway[] taxiways, Gate[] gates, Runway[] runways, Map<ComChannelName, ComChannel> channelMap) {
		airports[airports.length] = new Airport(name, id, lat, lon, taxiways, gates, runways, channelMap);
	}
}