import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> gradeList = new ArrayList<>();
    public GradeList(){

    }

    public void addGrade(double grade){
        gradeList.add(grade);
    }

    public boolean isEmpty(){
        return gradeList.isEmpty();
    }

    public double getAverage(){
        double average = 0;

        for (double grade : gradeList) {
            average += grade;
        }

        average /= gradeList.size();
        return average;
    }

    public double getHighestGrade(){
        double highestGrade = gradeList.get(0);

        for (double grade : gradeList){
            if (highestGrade < grade){
                highestGrade = grade;
            }
        }

        return highestGrade;
    }

    public double getLowestGrade(){
        double lowestGrade = gradeList.get(0);

        for (double grade : gradeList) {
            if (lowestGrade > grade){
                lowestGrade = grade;
            }
        }

        return lowestGrade;
    }
}
