import java.util.*;

public class TrendingMovies {
	String name;
	int year;
	double rating;

	TrendingMovies(String name, int year, double rating) {
		this.name = name;
		this.year = year;
		this.rating = rating;
	}

	public static void main(String[] args) {

		List<TrendingMovies> movies = Arrays.asList(new TrendingMovies("Movie A", 2024, 9.2),
				new TrendingMovies("Movie B", 2023, 8.9), new TrendingMovies("Movie C", 2022, 9.0),
				new TrendingMovies("Movie D", 2024, 8.5), new TrendingMovies("Movie E", 2023, 9.1),
				new TrendingMovies("Movie F", 2024, 9.3));

		movies.stream().filter(m -> m.rating >= 8.5).sorted((m1, m2) -> {
			if (m1.rating == m2.rating)
				return m2.year - m1.year;
			return Double.compare(m2.rating, m1.rating);
		}).limit(5).forEach(m -> System.out.println(m.name + " | " + m.year + " | " + m.rating));
	}
}
