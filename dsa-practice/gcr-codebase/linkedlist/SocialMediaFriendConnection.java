
class FriendNode {
	int friendId;
	FriendNode next;

	FriendNode(int friendId) {
		this.friendId = friendId;
		this.next = null;
	}
}

class UserNode {
	int userId;
	String name;
	int age;
	FriendNode friends;
	UserNode next;

	UserNode(int userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.friends = null;
		this.next = null;
	}
}

class SocialMediaList {
	UserNode head;

	void addUser(int id, String name, int age) {
		UserNode newUser = new UserNode(id, name, age);
		newUser.next = head;
		head = newUser;
	}

	UserNode findUserById(int id) {
		UserNode temp = head;
		while (temp != null) {
			if (temp.userId == id)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	void addFriend(int id1, int id2) {
		UserNode u1 = findUserById(id1);
		UserNode u2 = findUserById(id2);

		if (u1 == null || u2 == null) {
			System.out.println("User not found");
			return;
		}

		u1.friends = addFriendNode(u1.friends, id2);
		u2.friends = addFriendNode(u2.friends, id1);

		System.out.println("Friend connection added");
	}

	FriendNode addFriendNode(FriendNode head, int id) {
		FriendNode newNode = new FriendNode(id);
		newNode.next = head;
		return newNode;
	}

	void removeFriend(int id1, int id2) {
		UserNode u1 = findUserById(id1);
		UserNode u2 = findUserById(id2);

		if (u1 == null || u2 == null) {
			System.out.println("User not found");
			return;
		}

		u1.friends = removeFriendNode(u1.friends, id2);
		u2.friends = removeFriendNode(u2.friends, id1);

		System.out.println("Friend connection removed");
	}

	FriendNode removeFriendNode(FriendNode head, int id) {
		if (head == null)
			return null;

		if (head.friendId == id)
			return head.next;

		FriendNode temp = head;
		while (temp.next != null && temp.next.friendId != id) {
			temp = temp.next;
		}

		if (temp.next != null)
			temp.next = temp.next.next;

		return head;
	}

	void displayFriends(int id) {
		UserNode user = findUserById(id);
		if (user == null) {
			System.out.println("User not found");
			return;
		}

		System.out.print("Friends of " + user.name + ": ");
		FriendNode temp = user.friends;

		if (temp == null) {
			System.out.println("No friends");
			return;
		}

		while (temp != null) {
			System.out.print(temp.friendId + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	void findMutualFriends(int id1, int id2) {
		UserNode u1 = findUserById(id1);
		UserNode u2 = findUserById(id2);

		if (u1 == null || u2 == null) {
			System.out.println("User not found");
			return;
		}

		System.out.print("Mutual Friends: ");
		FriendNode f1 = u1.friends;
		boolean found = false;

		while (f1 != null) {
			FriendNode f2 = u2.friends;
			while (f2 != null) {
				if (f1.friendId == f2.friendId) {
					System.out.print(f1.friendId + " ");
					found = true;
				}
				f2 = f2.next;
			}
			f1 = f1.next;
		}

		if (!found)
			System.out.print("None");

		System.out.println();
	}

	void searchByName(String name) {
		UserNode temp = head;
		while (temp != null) {
			if (temp.name.equalsIgnoreCase(name)) {
				displayUser(temp);
				return;
			}
			temp = temp.next;
		}
		System.out.println("User not found");
	}

	void countFriends() {
		UserNode temp = head;
		while (temp != null) {
			int count = 0;
			FriendNode f = temp.friends;
			while (f != null) {
				count++;
				f = f.next;
			}
			System.out.println(temp.name + " has " + count + " friends");
			temp = temp.next;
		}
	}

	void displayUser(UserNode u) {
		System.out.println("ID: " + u.userId + ", Name: " + u.name + ", Age: " + u.age);
	}
}

public class SocialMediaFriendConnection {
	public static void main(String[] args) {

		SocialMediaList sm = new SocialMediaList();

		sm.addUser(1, "Aman", 21);
		sm.addUser(2, "Riya", 20);
		sm.addUser(3, "Kunal", 22);

		sm.addFriend(1, 2);
		sm.addFriend(1, 3);
		sm.addFriend(2, 3);

		sm.displayFriends(1);

		sm.findMutualFriends(1, 2);

		sm.removeFriend(1, 2);

		sm.displayFriends(1);

		sm.countFriends();
	}
}
