package d360;

import org.mindrot.jbcrypt.BCrypt;

public class Bcrypt {
    // Define a method to hash a password
    public static String hashPassword(String plainTextPassword) {
        // Generate a salt (cost factor of 12, you can adjust this)
        String salt = BCrypt.gensalt(12);
        
        // Hash the password with the generated salt
        String hashedPassword = BCrypt.hashpw(plainTextPassword, salt);
        
        return hashedPassword;
    }

    // Define a method to verify a password
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        // Check if the provided password matches the stored hash
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }

    public static void main(String[] args) {
        // Example usage
        String userPassword = "user_password";
        
        // Hash the password and store it in the database
        String hashedPassword = hashPassword(userPassword);
        
        // Later, when verifying the login:
        String inputPassword = "user_password";
        
        if (verifyPassword(inputPassword, hashedPassword)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }
}
