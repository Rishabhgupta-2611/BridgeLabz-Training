//2: Factory Pattern – User Creation
package librarymanagementsystem;

public abstract class User {
	protected String name;

	public User(String name) {
		this.name = name;
	}

	public abstract void getRole();
}
