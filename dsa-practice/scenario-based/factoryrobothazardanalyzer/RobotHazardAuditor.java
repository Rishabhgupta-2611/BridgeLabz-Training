package factoryrobothazardanalyzer;

public class RobotHazardAuditor {

	public double calculateHazardRisk(double armPrecision, int workDensity, String machineryState)
			throws RobotSafetyException {

		if (armPrecision < 0.0 || armPrecision > 1.1) {
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
		}

		if (workDensity < 1 || armPrecision > 20) {
			throw new RobotSafetyException("Error: Work Density must be 1-12");
		}

		double machineRiskFactor;

		if (machineryState.equalsIgnoreCase("Worn")) {
			machineRiskFactor = 1.3;
		}

		else if (machineryState.equalsIgnoreCase("Faulty")) {
			machineRiskFactor = 2.0;
		}

		else if (machineryState.equalsIgnoreCase("Critical")) {
			machineRiskFactor = 3.0;
		}

		else {
			throw new RobotSafetyException("Error: Unsupported machinery state");
		}

		double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workDensity * machineRiskFactor);

		return hazardRisk;
	}
}
