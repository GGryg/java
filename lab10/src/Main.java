import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;

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
                case "1" -> addMeetingOnDay(calendar, "meeting");
                case "2" -> addMeetingOnDay(calendar, "task");
                case "3" -> removeMeeting(calendar);
                case "4" -> removeTask(calendar);
                case "5" -> getAllMeetingsOnDay(calendar);
                case "6" -> getAllTasksOnDay(calendar);
                case "7" -> getAllMeetingsOnDayWithPriority(calendar);
                case "8" -> getAllTasksOnDayWithStatus(calendar);
                case "9" -> getAllMeetingWithPriorityAndAfterHour(calendar);
                case "10" -> getAllTasksOnDayWithStatusEndsBefore(calendar);
                case "11" -> {
                    run = false;
                    System.out.println("Exiting the program");
                }
            }
        }
    }

    public static void printOptions(){
        System.out.println("========================================");
        System.out.println("1) add meeting on day");
        System.out.println("2) add task on day");
        System.out.println("3) remove meeting on day");
        System.out.println("4) remove task on day");
        System.out.println("5) get all meetings on day");
        System.out.println("6) get all tasks on day");
        System.out.println("7) get all meetings on day with priority");
        System.out.println("8) get all tasks on day with status");
        System.out.println("9) get all meetings on day with priority and from hour");
        System.out.println("10) get all tasks on day with status and ending before hour");
        System.out.println("11) exit");
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
    public static void addMeetingOnDay(Calendar calendar, String type){
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
        if (startTime.isBefore(Block.EARLIEST_TIME)){
            System.out.println("Can't be earlier than " + Block.EARLIEST_TIME);
        }
        else{
            System.out.print("End time: ");
            String endTimeString = scanEndTime.next();
            LocalTime endTime = LocalTime.parse(endTimeString);
            if(type.equals("meeting")){
                System.out.print("Priority: ");
                int priority = scanPriority.nextInt();
                Meeting meeting = new Meeting(description, startTime, endTime, priority);
                calendar.setBlockOnDay(day, meeting);
            }
            else if(type.equals("task")){
                System.out.print("Status: ");
                String status = scanPriority.next();
                Task task = new Task(description, startTime, endTime, status);
                calendar.setBlockOnDay(day, task);
            }
        }
    }
    public static void removeMeeting(Calendar calendar){
        Scanner scan = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("Description: ");
        String description = scan.next();
        System.out.print("Start time: ");
        String startTimeString = scan.next();
        LocalTime startTime = LocalTime.parse(startTimeString);
        Predicate<Block> meetingPred = meeting -> meeting instanceof Meeting && meeting.getDescription().equals(description) && meeting.getStartTime().equals(startTime);
        calendar.removeBlock(day, meetingPred);
    }

    public static void removeTask(Calendar calendar){
        Scanner scan = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("Description: ");
        String description = scan.next();
        System.out.print("Start time: ");
        String startTimeString = scan.next();
        LocalTime startTime = LocalTime.parse(startTimeString);
        Predicate<Block> taskPred = task -> task instanceof Task && task.getDescription().equals(description) && task.getStartTime().equals(startTime);
        calendar.removeBlock(day, taskPred);
    }

    public static void getAllMeetingsOnDay(Calendar calendar){
        int day = scanDays(calendar);
        Predicate<Block> all = meeting -> meeting instanceof Meeting;
        ArrayList<Block> meetings = calendar.getMeetingsOnDay(day, all);
        System.out.println(getString(meetings));
    }

    public static void getAllTasksOnDay(Calendar calendar){
        int day = scanDays(calendar);
        Predicate<Block> allTasks = block -> block instanceof Task;
        System.out.println(getString(calendar.getMeetingsOnDay(day, allTasks)));
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
        Predicate<Block> withPriority = meeting -> meeting instanceof Meeting && ((Meeting)meeting).getPriority() == priority;
        //System.out.println(calendar.getMeetingOnDay(day, priority));
        System.out.println(getString(calendar.getMeetingsOnDay(day, withPriority)));
    }

    public static void printStatus(){
        System.out.println("=========");
        System.out.println("completed");
        System.out.println("ongoing");
        System.out.println("=========");
    }

    public static void getAllTasksOnDayWithStatus(Calendar calendar){
        Scanner scanStatus = new Scanner(System.in);
        int day = scanDays(calendar);
        printStatus();
        String status = scanStatus.next();
        if(!status.equals("completed") && !status.equals("ongoing")){
            System.out.println("Incorrect status");
        }
        else{
            Predicate<Block> withStatus = block -> block instanceof Task && ((Task)block).getStatus().equals(status);
            System.out.println(getString(calendar.getMeetingsOnDay(day, withStatus)));
        }
    }
/*
    public static void getAllMeetingsOnDayFromHour(Calendar calendar){
        Scanner scanHour = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("Start time: ");
        String startTimeString = scanHour.next();
        LocalTime startTime = LocalTime.parse(startTimeString);
        Predicate<Block> atHour = meeting -> meeting.getStartTime().isAfter(startTime);
        System.out.println(calendar.getMeetingsOnDay(day, atHour));
    }

    public static void getAllMeetingsBetweenHours(Calendar calendar){
        Scanner scanHour = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("Start time: ");
        String startTimeString = scanHour.next();
        LocalTime startTime = LocalTime.parse(startTimeString);
        System.out.print("End time: ");
        String endTimeString = scanHour.next();
        LocalTime endTime = LocalTime.parse(endTimeString);
        Predicate<Block> betweenHours = meeting -> meeting.getStartTime().isAfter(startTime) && meeting.getEndTime().isBefore(endTime);
        System.out.println(calendar.getMeetingsOnDay(day, betweenHours));
    }
*/
    public static void getAllMeetingWithPriorityAndAfterHour(Calendar calendar){
        Scanner scanHour = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("Start time: ");
        String startTimeString = scanHour.next();
        LocalTime startTime = LocalTime.parse(startTimeString);
        System.out.print("Priority: ");
        int priority = scanHour.nextInt();
        Predicate<Block> afterTimeAndPriority = meeting -> meeting instanceof Meeting && ((Meeting)meeting).getPriority() == priority && (meeting.getStartTime().isAfter(startTime) || meeting.getStartTime().equals(startTime));
        System.out.println(getString(calendar.getMeetingsOnDay(day, afterTimeAndPriority)));
    }

    public static void getAllTasksOnDayWithStatusEndsBefore(Calendar calendar){
        Scanner scan = new Scanner(System.in);
        int day = scanDays(calendar);
        System.out.print("End time: ");
        String endTimeString = scan.next();
        LocalTime endTime = LocalTime.parse(endTimeString);
        System.out.print("Status: ");
        String status = scan.next();
        Predicate<Block> afterTimeAndPriority = block -> block instanceof Task && ((Task)block).getStatus().equals(status) && (block.getEndTime().isBefore(endTime) || block.getEndTime().equals(endTime));
        System.out.println(getString(calendar.getMeetingsOnDay(day, afterTimeAndPriority)));
    }

    public static String getString(ArrayList<Block> list){
        StringBuilder str = new StringBuilder();
        for(Block block : list){
            str.append(block.toString());
            str.append("\n");
        }

        return str.toString();
    }
}