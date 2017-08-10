package main;

import enums.C;
import enums.RunwaySide;
import enums.RunwayUsage;

public class Runway implements PlaneSurface {
	public int width, length;
	public double dir;
	public double lat, lon;
	public String name;
	public Runway opposite;
	public RunwayUsage usage;
	public RunwaySide side;
	public int nameDir;
	public Airport airport;
	public Taxiway[] connectedTaxiways;
	public Plane occupant;
	
	public Runway(Airport airport, int nameDir, RunwaySide side, double lat, double lon, int width, int length, double dir, RunwayUsage usage, RunwayUsage usage2) {
		this.airport = airport;
		this.nameDir = nameDir;
		this.side = side;
		this.name = runwayName(nameDir, side);
		this.lat = lat;
		this.lon = lon;
		this.width = width;
		this.length = length;
		this.dir = dir;
		this.usage = usage;
		this.opposite = new Runway(this, usage2);
	}
	public Runway(Runway opposite, RunwayUsage usage) {
		this.name = runwayName(opposite.nameDir+18, opposite.side.opposite());
		double[] newCoords = C.coordsPlusDistance(opposite.lat, opposite.lon, opposite.dir, opposite.length);
		this.lat = newCoords[0];
		this.lon = newCoords[1];
		this.width = opposite.width;
		this.length = opposite.length;
		this.dir = (opposite.dir + 180) % 360;
		this.usage = usage;
		this.opposite = opposite;
	}
	
	private String runwayName(int dir, RunwaySide side) {
		int newDir = dir;
		newDir %= 36;
		if(newDir == 0) {
			newDir = 36;
		}
		String dirString = String.valueOf(newDir);
		return dirString + side.toString();
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