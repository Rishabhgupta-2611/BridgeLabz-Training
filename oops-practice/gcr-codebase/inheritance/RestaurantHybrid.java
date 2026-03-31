interface Worker {
	void performDuties();
}

class RestaurantPerson {
	String name;
	int id;

	RestaurantPerson(String name, int id) {
		this.name = name;
		this.id = id;
	}
}

class Chef extends RestaurantPerson implements Worker {
	Chef(String name, int id) {
		super(name, id);
	}

	@Override
	public void performDuties() {
		System.out.println("Chef " + name + " is cooking dishes.");
	}
}

class Waiter extends RestaurantPerson implements Worker {
	Waiter(String name, int id) {
		super(name, id);
	}

	@Override
	public void performDuties() {
		System.out.println("Waiter " + name + " is serving customers.");
	}
}

public class RestaurantHybrid {
	public static void main(String[] args) {
		Chef chef = new Chef("Gordon", 101);
		Waiter waiter = new Waiter("Emma", 201);

		chef.performDuties();
		waiter.performDuties();
	}
}