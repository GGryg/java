import java.time.LocalTime;

public final class Task extends Block {
    private String status;

    public Task(String description, LocalTime startTime, LocalTime endTime, String status){
        super(description, startTime, endTime);
        this.status = status;
    }

    public String toString(){
        return super.toString() + ", status: " + status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
