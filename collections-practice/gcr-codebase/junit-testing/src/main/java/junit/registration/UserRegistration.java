package junit.registration;
public class UserRegistration {
	
	public boolean registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be empty");
            return false;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("Invalid email");
            return false;
        }
        if (password == null || password.length() < 6) {
            System.out.println("Password must be at least 6 characters");
            return false;
        }

        System.out.println("User registered successfully: " + username);
        return true;
    }
}
