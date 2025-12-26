public class UnitConvertorTempature {

	public static double convertFarhenheitToCelsius(double farhenheit) {
		double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
		return farhenheit2celsius;
	}

	public static double convertCelsiusToFarhenheit(double celsius) {
		double celsius2farhenheit = (celsius * 9 / 5) + 32;
		return celsius2farhenheit;
	}

	public static double convertPoundsToKilograms(double pounds) {
		double pounds2kilograms = 0.453592;
		return pounds * pounds2kilograms;
	}

	public static double convertKilogramsToPounds(double kilograms) {
		double kilograms2pounds = 2.20462;
		return kilograms * kilograms2pounds;
	}

	public static double convertGallonsToLiters(double gallons) {
		double gallons2liters = 3.78541;
		return gallons * gallons2liters;
	}

	public static double convertLitersToGallons(double liters) {
		double liters2gallons = 0.264172;
		return liters * liters2gallons;
	}

	public static void main(String[] args) {
		System.out.println(convertFarhenheitToCelsius(98.6));
		System.out.println(convertCelsiusToFarhenheit(37));
		System.out.println(convertPoundsToKilograms(150));
		System.out.println(convertKilogramsToPounds(68));
		System.out.println(convertGallonsToLiters(5));
		System.out.println(convertLitersToGallons(10));
	}
}
