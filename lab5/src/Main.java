import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This program is for adding grades to a list and count the average, get highest/lowest grade!");
        Scanner scanOption = new Scanner(System.in);
        boolean run = true;
        GradeList gradeList = new GradeList();
        while(run){
            printOption();
            String option = scanOption.next();
            switch(option){
                case "1" -> addGrate(gradeList);
                case "2" -> printAverage(gradeList);
                case "3" -> printHighestGrade(gradeList);
                case "4" -> printLowestGrade(gradeList);
                case "5" -> {
                    System.out.println("Exiting the program");
                    run = false;
                }
                default -> System.out.println("Incorrect option");
            }
        }
    }

    public static void printOption() {
        System.out.println("========================");
        System.out.println("1) add a grade");
        System.out.println("2) count average");
        System.out.println("3) get highest grade");
        System.out.println("4) get lowest grade");
        System.out.println("5) exit");
        System.out.println("========================");
    }

    public static void addGrate(GradeList gradeList) {
        Scanner scanGrade = new Scanner(System.in);
        System.out.print("Enter a grade: ");
        double grade = scanGrade.nextDouble();

        gradeList.addGrade(grade);
    }

    public static void printAverage(GradeList gradeList) {
        boolean isEmptyGradeList = gradeList.isEmpty();
        if(isEmptyGradeList){
            System.out.println("There are no grades");
        }
        else{
            System.out.println("Average grade: " + gradeList.getAverage());
        }
    }

    public static void printHighestGrade(GradeList gradeList){
        boolean isGradeListEmpty = gradeList.isEmpty();
        if(isGradeListEmpty){
            System.out.println("There are no grades");
        }
        else{
            System.out.println("The highest grade is: " + gradeList.getHighestGrade());
        }
    }

    public static void printLowestGrade(GradeList gradeList){
        boolean isGradeListEmpty = gradeList.isEmpty();
        if(isGradeListEmpty){
            System.out.println("There are no grades");
        }
        else{
            System.out.println("The lowest grade is: " + gradeList.getLowestGrade());
        }
    }
}