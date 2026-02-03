package streambuzz;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EngagementService service = new EngagementService();

		while (true) {
			System.out.println("1. Register Creator");
			System.out.println("2. Show Top Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");

			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				CreatorStats cs = new CreatorStats();

				System.out.println("Enter Creator Name:");
				cs.setCreatorName(sc.nextLine());

				double[] likes = new double[4];
				System.out.println("Enter weekly likes (Week 1 to 4):");
				for (int i = 0; i < 4; i++) {
					likes[i] = sc.nextDouble();
				}
				cs.setWeeklyLikes(likes);

				service.registerCreator(cs);
				System.out.println("Creator registered successfully");
			}

			else if (choice == 2) {
				System.out.println("Enter like threshold:");
				double threshold = sc.nextDouble();

				Map<String, Integer> result = service.getTopPostCounts(CreatorStats.EngagementBoard, threshold);

				if (result.isEmpty()) {
					System.out.println("No top-performing posts this week");
				} else {
					for (String name : result.keySet()) {
						System.out.println(name + " - " + result.get(name));
					}
				}
			}

			else if (choice == 3) {
				double avg = service.calculateAverageLikes();
				System.out.println("Overall average weekly likes: " + (int) avg);
			}

			else if (choice == 4) {
				System.out.println("Logging off - Keep Creating with StreamBuzz!");
				break;
			}
		}
		sc.close();
	}
}
