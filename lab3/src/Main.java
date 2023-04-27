import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanOption = new Scanner(System.in);
        System.out.println("Program for cylinders, counting field");
        boolean run = true;
        Cylinder cylinder = new Cylinder();
        while(run){
            printOptions();
            String option = scanOption.next();
            switch(option){
                case "1":
                    printValues(cylinder);2
                    break;
                case "2":
                    setValues(cylinder);
                    break;
                case "3":
                    printAreaAndVolume(cylinder);
                    break;
                case "4":
                    System.out.println("Exiting");
                    run = false;
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }
    }

    public static void printOptions(){
        System.out.println("========================================");
        System.out.println("1) print values");
        System.out.println("2) change values");
        System.out.println("3) count and print area and volume");
        System.out.println("4) exit");
        System.out.println("========================================");
    }

    public static void printValues(Cylinder cylinder){
        System.out.println("radius: " + cylinder.getRadius());
        System.out.println("height: " + cylinder.getHeight());
    }

    public static void setValues(Cylinder cylinder){
        Scanner scanValues = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = scanValues.nextDouble();
        System.out.print("Enter height: ");
        double height = scanValues.nextDouble();

        cylinder.setRadius(radius);
        cylinder.setHeight(height);
    }

    public static void printAreaAndVolume(Cylinder cylinder){
        System.out.println("Base area: " + cylinder.getBaseField());
        System.out.println("Side area: " + cylinder.getSideField());
        System.out.println("Field: " + cylinder.getField());
        System.out.println("Volume: " + cylinder.getVolume());
    }
}