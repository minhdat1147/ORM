package training.hibernate.utils;

import java.util.Scanner;

public class Validator {
    public static boolean isIntegerInput(String number){
        return number.matches("[0-9]{2}\\b");
    }
}
