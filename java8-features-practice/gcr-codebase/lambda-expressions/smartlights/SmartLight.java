package smartlights;

public class SmartLight {

	public void activate(LightAction action) {
		action.execute();
	}

}
