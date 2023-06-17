import java.time.LocalTime;

public final class Meeting extends Block {
    private int priority;
    public Meeting(String description, LocalTime startTime, LocalTime endTime, int priority){
        super(description, startTime, endTime);
        this.priority = priority;
    }

    public String toString(){
        return super.toString() + ", priority: " + priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }
    public int getPriority(){
        return priority;
    }
}
