package main;

public class ComChannel extends AirTrafficControlChannel {
	private boolean inUse = false;
	
	public ComChannel(float freq) {
		super(freq);
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
			RadioMessage returnMsg;
			switch(msg) {
				// more to come
				default:
					returnMsg = RadioMessage.REPEAT;
			}
			inUse = false;
			return returnMsg;
		}
	}
}