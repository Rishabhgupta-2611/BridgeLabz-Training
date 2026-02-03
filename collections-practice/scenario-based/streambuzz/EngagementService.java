package streambuzz;

import java.util.*;

public class EngagementService {

	public void registerCreator(CreatorStats record) {
		CreatorStats.EngagementBoard.add(record);
	}

	public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
		Map<String, Integer> result = new HashMap<>();

		for (CreatorStats cs : records) {
			int count = 0;
			for (double likes : cs.getWeeklyLikes()) {
				if (likes >= likeThreshold) {
					count++;
				}
			}
			if (count > 0) {
				result.put(cs.getCreatorName(), count);
			}
		}
		return result;
	}

	public double calculateAverageLikes() {
		double sum = 0;
		int total = 0;

		for (CreatorStats cs : CreatorStats.EngagementBoard) {
			for (double likes : cs.getWeeklyLikes()) {
				sum += likes;
				total++;
			}
		}

		return total == 0 ? 0 : sum / total;
	}
}
