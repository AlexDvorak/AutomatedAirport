package main;

import java.util.Map;

import enums.ComChannelName;

public class Airport {
	public String name, id;
	public double lat, lon;
	public Taxiway[] taxiways;
	public Gate[] gates;
	public Runway[] runways;
	public Map<ComChannelName, ComChannel> channels;
	
	public Airport(String name, String id, double lat, double lon, Taxiway[] taxiways, Gate[] gates, Runway[] runways, Map<ComChannelName, ComChannel> channels) {
		this.name = name;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.taxiways = taxiways;
		this.gates = gates;
		this.runways = runways;
		this.channels = channels;
	}
}