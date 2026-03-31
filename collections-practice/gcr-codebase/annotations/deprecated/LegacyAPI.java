package deprecated;

public class LegacyAPI {

	@Deprecated
	public void oldFeature() {
		System.out.println("Old feature (deprecated)");
	}

	public void newFeature() {
		System.out.println("New feature (recommended)");
	}
}
