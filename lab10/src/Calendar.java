import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {
    private ArrayList<ArrayList<Block>> meetingsList = new ArrayList<>();

    public Calendar(){
        this(7);
    }

    public Calendar(int days){
        for (int i = 1; i <= days; i++){
            meetingsList.add(new ArrayList<Block>());
        }
    }

    public void setBlockOnDay(int day, Block meeting){
        meetingsList.get(day).add(meeting);
    }

    /*
    public ArrayList<Block> getMeetingOnDay(int day){
        return meetingsList.get(day);
    }
    */

    public ArrayList<Block> getMeetingsOnDay(int day, Predicate<Block> pred){
        ArrayList<Block> meetingsOnDay = meetingsList.get(day);
        ArrayList<Block> ret = new ArrayList<>();
        for (Block meet : meetingsOnDay){
            if (pred.test(meet)){
                ret.add(meet);
            }
        }
        return ret;
    }
    public Block getMeetingFromList(int day, int numberOfMeeting){
        return meetingsList.get(day).get(numberOfMeeting);
    }

    public void removeBlock(int day, Predicate<Block> pred){
        ArrayList<Block> blocksOnDay = meetingsList.get(day);
        for (Block block : blocksOnDay){
            if(pred.test(block)){
                blocksOnDay.remove(block);
                break;
            }
        }
    }

    public void removeMeetingOnDay(int day, int meetingNumber){
        Block meeting = getMeetingFromList(day, meetingNumber);
        meetingsList.get(day).remove(meeting);
    }
    public int getNumberOfDays(){
        return meetingsList.size();
    }
}
