package at.ac.fhcampuswien.usermanager.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHandling {
    private static final int WORKLOAD = 12;

    private PasswordHandling(){}

    public static String hashPassword(String passwordPlainText) {
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(passwordPlainText, salt);
    }

    public static boolean checkPassword(String passwordPlainText, String storedHash) {
        if (null == storedHash || !storedHash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(passwordPlainText, storedHash);
    }

}

