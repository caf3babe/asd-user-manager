package at.ac.fhcampuswien.usermanager.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    private InputValidation(){}

    public static void stringValidation(String value){
        if(value.isEmpty()){
            throw new IllegalArgumentException("Invalid input data! Try again!");
        }
    }

    public static void passwordValidation(String password){
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,10}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        stringValidation(password);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Password must be secure!");
        }
    }

    public static boolean compareStrings (String password, String repeadPassword){
        stringValidation(password);
        stringValidation(repeadPassword);
        return password.equals(repeadPassword);
    }
}
