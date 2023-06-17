import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {
    private ArrayList<ArrayList<Meeting>> meetingsList = new ArrayList<>();

    public Calendar(){
        this(7);
    }

    public Calendar(int days){
        for (int i = 1; i <= days; i++){
            meetingsList.add(new ArrayList<Meeting>());
        }
    }

    public void setMeetingOnDay(int day, Meeting meeting){
        meetingsList.get(day).add(meeting);
    }

    public ArrayList<Meeting> getMeetingOnDay(int day){
        return meetingsList.get(day);
    }

    public ArrayList<Meeting> getMeetingOnDay(int day, int priority){
        ArrayList<Meeting> meetingsOnDay = meetingsList.get(day);
        for (Meeting meeting : meetingsOnDay){
            if (meeting.getPriority() != priority){
                meetingsOnDay.remove(meeting);
            }
        }
        return meetingsOnDay;
    }

    public ArrayList<Meeting> getMeetingOneDay(int day, Predicate<Meeting> pred){
        ArrayList<Meeting> meetingsOnDay = meetingsList.get(day);
        for (Meeting meet : meetingsOnDay){
            if (!pred.test(meet)){
                meetingsOnDay.remove(meet);
            }
        }
        return meetingsOnDay;
    }
    public Meeting getMeetingFromList(int day, int numberOfMeeting){
        return meetingsList.get(day).get(numberOfMeeting);
    }

    public void removeMeetingOnDay(int day, int meetingNumber){
        Meeting meeting = getMeetingFromList(day, meetingNumber);
        meetingsList.get(day).remove(meeting);
    }

    public int getNumberOfDays(){
        return meetingsList.size();
    }

}
