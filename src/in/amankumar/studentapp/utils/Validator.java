package in.amankumar.studentapp.utils;

import java.util.regex.Pattern;

public class Validator {

    public static boolean isName(String name) {

        String regex = "^[A-Za-z]+(?: [A-Za-z]+)*$";
        return Pattern.matches(regex,name);
    }

    public static boolean isGrade(String grade) {

        String regex = "^(KG|Kindergarten|[1-9]|10)$";
        return Pattern.matches(regex,grade);
    }

    public static boolean isAge(String age) {

        String regex = "^(1\\d|[1-9])|([2-9]\\d)$";
        return Pattern.matches(regex,age);
    }

    public static boolean isDOB(String DOB) {

        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-\\d{4}$";
        return Pattern.matches(regex,DOB);
    }
}
