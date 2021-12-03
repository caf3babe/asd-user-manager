package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    public static void stringValidation(String value){
        if(value.isEmpty()||value==null){
            throw new IllegalArgumentException("Invalid inputdata! Try again!");
        }
    }

    public static void passwordValidation(String password){
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,10}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        stringValidation(password);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Password must be secure!");
        }
    }

    public static boolean compareStrings (String password_1, String password_2){
        stringValidation(password_1);
        stringValidation(password_2);
        return password_1.equals(password_2);
    }
}
