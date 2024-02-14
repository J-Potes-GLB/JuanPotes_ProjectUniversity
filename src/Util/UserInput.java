package Util;

import Models.Persons.Student;
import Models.Persons.Teachers.Teacher;
import Models.UniClass;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    public static int inputIntFromRange(String requestMessage, int minValue, int maxValue){
        Scanner scan = new Scanner(System.in);

        int number = minValue - 1;

        do{
            System.out.print("\n" + requestMessage);

            if (scan.hasNextInt()){
                number = scan.nextInt();
            }

            if(number < minValue || number > maxValue){
                System.out.println("INVALID VALUE. (Type only a number between " + minValue +" and " + maxValue + ").");
            }
        }
        while(number < minValue || number > maxValue);

        return number;
    }

    public static String inputString(String requestMessage){
        Scanner scan = new Scanner(System.in);
        // Pattern for at least 1 letter
        Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
        String stringLine = "";
        Matcher matcher;
        boolean matches = false;

        while(!matches){
            System.out.print("\n" + requestMessage);
            stringLine = scan.nextLine();

            matcher = pattern.matcher(stringLine);

            matches = matcher.matches();

            if(!matches){
                System.out.println("\nINVALID VALUE. Try again (The input must contain at least one letter).");
            }
        }

        return stringLine;
    }

    public static Teacher inputTeacher(){
        return null;
    }

    public static Student inputStudent(){
        return null;
    }

    public static UniClass inputUniClass(){
        return null;
    }

    public static void showMainMenu(){
        System.out.println("\n-----------------------------------------------------");
        System.out.println("|                      MAIN MENU                    |");
        System.out.println("|  1. Show all classes.                             |");
        System.out.println("|  2. Show all teachers.                            |");
        System.out.println("|  3. Show all students.                            |");
        System.out.println("|  4. Show a class details.                         |");
        System.out.println("|  5. Create a new student.                         |");
        System.out.println("|  6. Add an existing student to an existing class. |");
        System.out.println("|  7. Create a new class.                           |");
        System.out.println("|  8. List all classes of a student.                |");
        System.out.println("|  9. Exit.                                         |");
        System.out.println("-----------------------------------------------------");
    }

    public static void showYesNoMenu(){
        System.out.println("\n---------------");
        System.out.println("|  1. Yes.    |");
        System.out.println("|  2. No.     |");
        System.out.println("---------------");
    }

    public static int optionMainMenu(){
        showMainMenu();
        return inputIntFromRange("Type the number of an option from the menu: ", 1, 9);
    }

    public static int optionYesNoMenu(String requestMessage){
        showYesNoMenu();
        return inputIntFromRange(requestMessage,1,2);
    }
}
