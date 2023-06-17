import java.time.LocalTime;

public abstract sealed class Block permits Meeting, Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public final static LocalTime EARLIEST_TIME = LocalTime.parse("08:00");

    protected Block(String description, LocalTime startTime, LocalTime endTime){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }

    public LocalTime getStartTime(){
        return startTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public LocalTime getEndTime(){
        return endTime;
    }

    public String toString(){
        return description + ", start: " + startTime + ", end: " + endTime;
    }
}
