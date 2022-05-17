public class Course {
    private String courseName;
    private int difficulty;

    public Course(String runCourseName, int runDifficulty) {
        this.courseName = runCourseName;
        this.difficulty = runDifficulty;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getDifficulty() {
        return difficulty;
    }
}

