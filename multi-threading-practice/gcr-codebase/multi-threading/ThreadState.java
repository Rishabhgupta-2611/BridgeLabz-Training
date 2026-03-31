import java.time.LocalTime;

class TaskRunner extends Thread {
	public TaskRunner(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);// timed waiting
			for (int i = 0; i < 1_000_000; i++)
				; // runnable
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class StateMonitor extends Thread {
	private Thread[] threads;

	public StateMonitor(Thread[] threads) {
		this.threads = threads;
	}

	@Override
	public void run() {
		boolean running = true;
		while (running) {
			running = false;
			for (Thread t : threads) {
				System.out.println("[Monitor] " + t.getName() + " is in " + t.getState() + " at " + LocalTime.now());
				if (t.getState() != Thread.State.TERMINATED) {
					running = true;
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("All threads terminated");
	}
}

public class ThreadState {
	public static void main(String[] args) {

		TaskRunner t1 = new TaskRunner("Task-1");
		TaskRunner t2 = new TaskRunner("Task-2");

		StateMonitor monitor = new StateMonitor(new Thread[] { t1, t2 });

		t1.start();
		t2.start();

		monitor.start();
	}
}