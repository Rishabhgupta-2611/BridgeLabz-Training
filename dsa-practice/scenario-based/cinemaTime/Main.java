package cinemaTime;

public class Main {
	public static void main(String[] args) {
		CinemaTimeCRUD crud = new CinemaTimeCRUD();

		try {
			crud.addMovie("Avengers", "18:30");
			crud.addMovie("Inception", "21:00");
			crud.addMovie("Avatar", "25:99"); // Invalid
		} catch (InvalidTimeFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("\nAll Movies:");
		crud.displayAllMovies();

		System.out.println("\nSearch Result:");
		crud.searchMovie("ave");

		crud.generateReport();
	}
}
