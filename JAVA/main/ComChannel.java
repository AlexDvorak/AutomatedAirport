package main;

import enums.RadioMessage;

public class ComChannel {
	private boolean inUse = false;
	public float freq;
	public double lat, lon;
	public int rangeNM;
	
	public ComChannel(double lat, double lon, int rangeNM, float freq) {
		this.freq = freq;
		this.lat = lat;
		this.lon = lon;
		this.rangeNM = rangeNM;
	}
	
	public RadioMessage sendMessage(Plane plane, RadioMessage msg, double[] args) {
		while(inUse) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized(this) {
			inUse = true;
			RadioMessage returnMsg = plane.receiveMessage(this, msg, args);
			inUse = false;
			return returnMsg;
		}
	}
	public RadioMessage receiveMessage(Plane plane, RadioMessage msg, double[] args) {
		while(inUse) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		synchronized(this) {
			inUse = true;
			RadioMessage returnMsg;
			switch(msg) {
				default:
					returnMsg = RadioMessage.REPEAT;
			}
			inUse = false;
			return returnMsg;
		}
	}
}