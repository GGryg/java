import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private int priority;

    public final static LocalTime EARLIEST_TIME = LocalTime.parse("08:00");

    public Meeting(){

    }

    public Meeting(String description, LocalTime startTime, LocalTime endTime, int priority){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public void setMeeting(String description, LocalTime startTime, LocalTime endTime, int priority){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String toString(){
        return description + ", start: " + startTime + ", end: " + endTime + ", priority: " + priority;
    }

    public int getPriority(){
        return priority;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

}
