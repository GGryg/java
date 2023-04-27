import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("This program is for adding meetings for a week in calendar!");
        Scanner scanOption = new Scanner(System.in);
        boolean run = true;
        Calendar calendar = new Calendar();
        while(run){
            printOptions();
            String option = scanOption.next();
            switch (option){
                case "1" -> addMeetingOnDay(calendar);
                case "2" -> removeMeeting(calendar);
                case "3" -> getAllMeetingsOnDay(calendar);
                case "4" -> getAllMeetingsOnDayWithPriority(calendar);
                case "5" -> {
                    run = false;
                    System.out.println("Exiting the program");
                }
            }
        }
    }

    public static void printOptions(){
        System.out.println("========================================");
        System.out.println("1) add meeting on day");
        System.out.println("2) remove meeting on day");
        System.out.println("3) get all meetings on day");
        System.out.println("4) get all meetings on day with priority");
        System.out.println("5) exit");
        System.out.println("========================================");
    }

    public static int scanDays(Calendar calendar){
        Scanner scanDay = new Scanner(System.in);
        int days = calendar.getNumberOfDays();
        System.out.println("=================");
        System.out.println("Enter days(0-" + (days-1) + ")");
        System.out.println("=================");
        return scanDay.nextInt();
    }
    public static void addMeetingOnDay(Calendar calendar){
        Scanner scanDescription = new Scanner(System.in);
        Scanner scanStartTime = new Scanner(System.in);
        Scanner scanEndTime = new Scanner(System.in);
        Scanner scanPriority = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("Description: ");
        String description = scanDescription.next();
        System.out.print("Start time: ");
        String startTimeString = scanStartTime.next();
        LocalTime startTime = LocalTime.parse(startTimeString);
        if (startTime.isBefore(Meeting.EARLIEST_TIME)){
            System.out.println("Can't be earlier than " + Meeting.EARLIEST_TIME);
        }
        else{
            System.out.print("End time: ");
            String endTimeString = scanEndTime.next();
            LocalTime endTime = LocalTime.parse(endTimeString);
            System.out.print("Priority: ");
            int priority = scanPriority.nextInt();
            Meeting meeting = new Meeting(description, startTime, endTime, priority);
            calendar.setMeetingOnDay(day, meeting);
        }
    }

    public static void removeMeeting(Calendar calendar){
        Scanner scanMeetingNumber = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.println(calendar.getMeetingOnDay(day));
        int meetingNumber = scanMeetingNumber.nextInt() - 1;
        calendar.removeMeetingOnDay(day, meetingNumber);
    }

    public static void getAllMeetingsOnDay(Calendar calendar){
        int day = scanDays(calendar);
        ArrayList<Meeting> meetings = calendar.getMeetingOnDay(day);
        System.out.println(meetings);
    }

    public static void printPriorities(){
        System.out.println("==========");
        System.out.println("0) Low");
        System.out.println("1) Medium");
        System.out.println("2) High");
        System.out.println("==========");
    }
    public static void getAllMeetingsOnDayWithPriority(Calendar calendar){
        Scanner scanPriority = new Scanner(System.in);
        int day = scanDays(calendar);
        printPriorities();
        int priority = scanPriority.nextInt();

        System.out.println(calendar.getMeetingOnDay(day, priority));
    }
}