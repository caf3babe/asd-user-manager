package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {

    public static void stringValidation(String value){
        if(value.isEmpty()||value==null){
            throw new IllegalArgumentException("Invalid inputdata! Try again!");
        }
    }

    public static void passwordValidation(char[] password){
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{4,10}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password.toString());
        if(password==null||password.length==0){
            throw new IllegalArgumentException("Invalid password! Try again!");
        }else if(!matcher.matches()){
            throw new SecurityException("Password must be secure!");
        }
    }
}
