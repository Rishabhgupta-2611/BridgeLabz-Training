
public class EarthVolume {
	public static void main(String[] args) {
		
		double r = 6378;
		double pi = 3.14;
		double vol = (4.0 / 3.0) * pi * r * r * r;
		double radMiles = r / 1.6;
        double volMiles = (4.0 / 3.0) * pi * radMiles * radMiles * radMiles;

        System.out.println("The volume of earth in cubic kilometers is " + vol + " and cubic miles is " + volMiles);
        

	}

}
