import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    public static int scanIntFromRange(String requestMessage, int minValue, int maxValue){
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

    public static String scanString(String requestMessage){
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
    }

    public static void showYesNoMenu(){
    }

    public static int optionMainMenu(){
        return 0;
    }

    public static int optionYesNoMenu(String requestMessage){
        return 0;
    }
}
