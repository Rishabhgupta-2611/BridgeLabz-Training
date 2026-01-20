package cinemaTime;

public class CinemaTimeCRUD {

	CinemaTimeDAO manager = new CinemaTimeDAO();

	// ADD
	public void addMovie(String title, String time) throws InvalidTimeFormatException {
		if (!isValidTime(time)) {
			throw new InvalidTimeFormatException("Invalid time format: " + time);
		}
		manager.movieTitles.add(title);
		manager.showTimes.add(time);
	}

	public void searchMovie(String keyword) {
		try {
			boolean found = false;
			for (int i = 0; i < manager.movieTitles.size(); i++) {
				if (manager.movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
					System.out.println(manager.movieTitles.get(i) + " at " + manager.showTimes.get(i));
					found = true;
				}
			}
			if (!found) {
				throw new IndexOutOfBoundsException("Movie not found");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Search Error: " + e.getMessage());
		}
	}

	public void displayAllMovies() {
		for (int i = 0; i < manager.movieTitles.size(); i++) {
			String output = String.format("Movie: %s | Time: %s", manager.movieTitles.get(i), manager.showTimes.get(i));
			System.out.println(output);
		}
	}

	// Generating Report (List → Array)
	public void generateReport() {
		String[] moviesArray = manager.movieTitles.toArray(new String[0]);
		String[] timesArray = manager.showTimes.toArray(new String[0]);

		System.out.println("\n--- Printable Movie Report ---");
		for (int i = 0; i < moviesArray.length; i++) {
			System.out.println(moviesArray[i] + " - " + timesArray[i]);
		}
	}

	// TIME VALIDATION
	private boolean isValidTime(String time) {
		if (!time.matches("\\d{2}:\\d{2}"))
			return false;

		String[] parts = time.split(":");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
	}
}
