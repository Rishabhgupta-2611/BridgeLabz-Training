class Chef extends Thread {
	private String dish;
	private int cookTime; // in milliseconds

	public Chef(String name, String dish, int cookTime) {
		super(name);
		this.dish = dish;
		this.cookTime = cookTime;
	}

	@Override
	public void run() {

		System.out.println(getName() + " started preparing " + dish);

		int[] steps = { 50, 25, 75, 10 };
		for (int step : steps) {
			try {
				Thread.sleep(cookTime / 4);
			} catch (InterruptedException e) {
			}
			System.out.println(getName() + " preparing " + dish + ": " + step + "% complete");
		}
	}
}

public class RestaurantSystem {
	public static void main(String[] args) throws InterruptedException {

		Chef c1 = new Chef("Chef-1", "Chicken Biryani", 3000);
		Chef c2 = new Chef("Chef-2", "Butter Chicken", 2000);
		Chef c3 = new Chef("Chef-3", "Laal Maas", 25000);
		Chef c4 = new Chef("Chef-4", "Butter Naan", 1500);

		c1.start();
		c2.start();
		c3.start();
		c4.start();

		c1.join();
		c2.join();
		c3.join();
		c4.join();

		System.out.println("Kitchen closed - All orders completed");
	}
}