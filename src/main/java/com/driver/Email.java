package com.driver;
import java.util.*;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public boolean isvalidPassword(String password) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean specialChar = false;
        boolean digit = false;
//        if (password.length() < 8)
//            return false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch))
                upperCase = true;
            if (Character.isLowerCase(ch))
                lowerCase = true;
            if (Character.isDigit(ch))
                digit = true;
            if (!Character.isLetter(ch) && !Character.isDigit(ch) && !Character.isWhitespace(ch))
                specialChar = true;
        }
        if (upperCase && lowerCase && digit && specialChar)
            return true;

        return false;
    }

    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if (oldPassword == this.password) {
            if (newPassword.length() >= 8 && isvalidPassword(newPassword)) {
                this.password = newPassword;
            } else {
                System.out.println("Recent Password does not match with old password ");
            }
        }
    }
}
