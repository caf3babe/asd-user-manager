package at.ac.fhcampuswien.usermanager.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHandling {
    private static final int WORKLOAD = 12;

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(password_plaintext, salt);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        if (null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(password_plaintext, stored_hash);
    }

}

