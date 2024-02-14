package Util;

import Models.Persons.Student;
import Models.Persons.Teachers.Teacher;
import Models.UniClass;

import java.util.List;
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
            else{
                scan.next();
            }

            if(number < minValue || number > maxValue){
                System.out.println("INVALID VALUE. (Type only a number between " + minValue +" and " + maxValue + ").");
            }
        }
        while(number < minValue || number > maxValue);

        return number;
    }

    public static int inputPositiveInt(String requestMessage){
        return inputIntFromRange(requestMessage,1, Integer.MAX_VALUE);
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
                System.out.println("INVALID VALUE. Try again (The input must contain at least one letter).");
            }
        }

        return stringLine;
    }

    public static Teacher inputTeacher(){
        return null;
    }

    public static int indexOfTeacher(List<Teacher> teachers, int id){
        int index = -1;
        for(int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).idEquals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int inputExistingTeacherId(List<Teacher> teachers, String requestMessage){
        int indexTeacher = -1;
        int idTeacher;
        do{
            idTeacher = UserInput.inputPositiveInt(requestMessage);
            indexTeacher = UserInput.indexOfTeacher(teachers, idTeacher);

            if(indexTeacher == -1){
                System.out.println("Teacher not found!. Check the ID number and try again.");
            }
        }while(indexTeacher == -1);
        return idTeacher;
    }

    public static Student inputStudent(List<Student> students){
        int id;
        int index;
        do{
            id = inputPositiveInt("Please type the ID number of the new student: ");
            index = indexOfStudent(students, id);
            if(index != -1){
                System.out.println("The student with the ID:" + id + " already exist. Try another one");
            }
        }while(index != -1);
        String name = inputString("Please type the first and last NAME of the new student: ");
        int age = inputIntFromRange("Please type the AGE of the new student: ", 10, 99);

        return new Student(name, id, age);
    }

    public static int indexOfStudent(List<Student> students, int id){
        int index = -1;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).idEquals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int inputExistingStudentId(List<Student> students, String requestMessage){
        int indexStudent = -1;
        int idStudent;
        do{
            idStudent = UserInput.inputPositiveInt(requestMessage);
            indexStudent = UserInput.indexOfStudent(students, idStudent);

            if(indexStudent == -1){
                System.out.println("Student not found!. Check the ID number and try again.");
            }
        }while(indexStudent == -1);
        return idStudent;
    }

    public static UniClass inputUniClass(){

        String name = inputString("Please type the name of the new class: ");
        int weeklyHours = inputIntFromRange("Please type the weekly hours of the class: ", 1, 6);
        return new UniClass(name, weeklyHours);
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
