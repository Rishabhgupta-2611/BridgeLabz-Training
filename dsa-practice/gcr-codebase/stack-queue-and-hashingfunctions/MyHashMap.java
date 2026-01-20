
public class MyHashMap {

	class Node {
		int key, value;
		Node next;

		Node(int k, int v) {
			key = k;
			value = v;
		}
	}

	int SIZE = 10;
	Node[] bucket = new Node[SIZE];

	int hash(int key) {
		return key % SIZE;
	}

	void put(int key, int value) {
		int index = hash(key);
		Node head = bucket[index];

		while (head != null) {
			if (head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		Node newNode = new Node(key, value);
		newNode.next = bucket[index];
		bucket[index] = newNode;
	}

	int get(int key) {
		int index = hash(key);
		Node head = bucket[index];

		while (head != null) {
			if (head.key == key)
				return head.value;
			head = head.next;
		}
		return -1;
	}

	void remove(int key) {
		int index = hash(key);
		Node head = bucket[index];
		Node prev = null;

		while (head != null) {
			if (head.key == key) {
				if (prev == null)
					bucket[index] = head.next;
				else
					prev.next = head.next;
				return;
			}
			prev = head;
			head = head.next;
		}
	}

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();

		map.put(1, 100);
		map.put(2, 200);

		System.out.println(map.get(1)); // 100

		map.remove(1);

		System.out.println(map.get(1)); // -1
	}
}
