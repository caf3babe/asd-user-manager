package at.ac.fhcampuswien.usermanager.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    private InputValidation(){}

    public static void isEmpty(String value){
        if(value.isEmpty()){
            throw new IllegalArgumentException("Invalid input data! Try again!");
        }
    }

    public static void passwordValidation(String password){
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,10}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        isEmpty(password);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Password must be secure!");
        }
    }

    public static boolean compareStrings (String password, String repeatedPassword){
        isEmpty(password);
        isEmpty(repeatedPassword);
        return password.equals(repeatedPassword);
    }
}
