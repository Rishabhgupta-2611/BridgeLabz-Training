package librarymanagementsystem;

import java.util.*;

public class NotificationService {

	private List<Observer> observers = new ArrayList<>();

	public void subscribe(Observer observer) {
		observers.add(observer);
	}

	public void notifyUsers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}
}
