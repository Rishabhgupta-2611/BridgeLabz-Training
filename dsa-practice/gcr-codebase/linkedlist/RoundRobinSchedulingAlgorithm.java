
class ProcessNode {
	int pid;
	int burstTime;
	int remainingTime;
	int priority;
	int waitingTime;
	int turnaroundTime;
	ProcessNode next;

	ProcessNode(int pid, int burstTime, int priority) {
		this.pid = pid;
		this.burstTime = burstTime;
		this.remainingTime = burstTime;
		this.priority = priority;
		this.waitingTime = 0;
		this.turnaroundTime = 0;
		this.next = null;
	}
}

class RoundRobinScheduler {
	ProcessNode head = null;

	void addProcess(int pid, int burst, int priority) {
		ProcessNode newNode = new ProcessNode(pid, burst, priority);

		if (head == null) {
			head = newNode;
			newNode.next = head;
			return;
		}

		ProcessNode temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		temp.next = newNode;
		newNode.next = head;
	}

	void removeProcess(ProcessNode prev, ProcessNode curr) {
		if (curr == head && curr.next == head) {
			head = null;
			return;
		}

		if (curr == head) {
			head = head.next;
		}

		prev.next = curr.next;
	}

	void displayProcesses() {
		if (head == null) {
			System.out.println("No processes remaining");
			return;
		}

		ProcessNode temp = head;
		do {
			System.out.println("PID: " + temp.pid + ", Remaining Time: " + temp.remainingTime);
			temp = temp.next;
		} while (temp != head);
	}

	void executeRoundRobin(int timeQuantum) {
		int time = 0;
		int totalProcesses = countProcesses();
		int completed = 0;

		ProcessNode curr = head;
		ProcessNode prev = null;

		while (head != null) {

			if (curr.remainingTime > timeQuantum) {
				curr.remainingTime -= timeQuantum;
				time += timeQuantum;
			} else {
				time += curr.remainingTime;
				curr.remainingTime = 0;
				curr.turnaroundTime = time;
				curr.waitingTime = curr.turnaroundTime - curr.burstTime;

				completed++;
				removeProcess(prev, curr);
			}

			displayProcesses();
			System.out.println("---- End of Round ----");

			if (head == null)
				break;

			prev = curr;
			curr = curr.next;
		}

		System.out.println("\nScheduling Complete");
		calculateAverageTime(totalProcesses);
	}

	int countProcesses() {
		if (head == null)
			return 0;

		int count = 0;
		ProcessNode temp = head;
		do {
			count++;
			temp = temp.next;
		} while (temp != head);

		return count;
	}

	void calculateAverageTime(int totalProcesses) {
		double totalWT = 0;
		double totalTAT = 0;

		ProcessNode temp = head;
		if (temp == null) {
			System.out.println("Average Waiting Time: Calculated");
			System.out.println("Average Turnaround Time: Calculated");
			return;
		}

		do {
			totalWT += temp.waitingTime;
			totalTAT += temp.turnaroundTime;
			temp = temp.next;
		} while (temp != head);

		System.out.println("Average Waiting Time: " + (totalWT / totalProcesses));
		System.out.println("Average Turnaround Time: " + (totalTAT / totalProcesses));
	}
}

public class RoundRobinSchedulingAlgorithm {
	public static void main(String[] args) {
		RoundRobinScheduler rr = new RoundRobinScheduler();

		rr.addProcess(1, 10, 1);
		rr.addProcess(2, 5, 2);
		rr.addProcess(3, 8, 1);

		int timeQuantum = 4;

		System.out.println("Starting Round Robin Scheduling");
		rr.executeRoundRobin(timeQuantum);
	}
}
