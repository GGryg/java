import javax.sound.midi.SysexMessage;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanExit = new Scanner(System.in);
        Scanner scanOption = new Scanner(System.in);
        System.out.println("Hello world!");
        System.out.println("Program do oblicznia 2^n lub n!");

        boolean run = true;

        while (run){
            System.out.println("============================");
            System.out.println("Silnia czy potega?");
            System.out.println("============================");
            String option = scanOption.next();

            System.out.println("Podaj n: ");
            int n = scan.nextInt();

            if (option.equals("silnia")){
                System.out.println("Silnia: " + n + "! = " + toString(factorial(n)));
            }
            else if (option.equals("potega")){
                System.out.println("Potega: 2^" + n + " = " + toString(power(n)));
            }
            else{
                System.out.println("Nie poprawna opcja");
            }
            System.out.println("Czy chcesz zakończyć program napisz tak/nie lub coś innego: ");
            String exit = scanExit.next();
            if (exit.equals("tak")){
                run = false;
            }
        }
        System.out.println("Koniec");
    }

    public static int power(int n){
        int ret = 1;
        for (int i = 1; i <= n; i++){
            ret *= 2;
        }

        return ret;
    }

    public static int factorial(int n){
        int ret = 1;

        for (int i = 1; i <= n; i++){
            ret *= i;
        }

        return ret;
    }

    public static String toString(int result){
        return "Wynik: " + result;
    }
}