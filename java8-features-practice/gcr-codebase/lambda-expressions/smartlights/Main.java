package smartlights;

public class Main {
	public static void main(String[] args) {

		SmartLight light = new SmartLight();

		// Motion detected
		LightAction motionTrigger = () -> System.out.println("Motion detected -> Lights ON at full brightness");

		// Night time
		LightAction nightTrigger = () -> System.out.println("Night time -> Dim lights at 30% brightness");

		// Voice command
		LightAction voiceTrigger = () -> System.out.println("Voice command -> Lights set to party mode ");

		// Activate lights
		light.activate(motionTrigger);
		light.activate(nightTrigger);
		light.activate(voiceTrigger);
	}
}
