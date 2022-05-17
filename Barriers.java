public class Barriers {
    private Course [] courseArrays;
    public Barriers(Course [] courseArrays){
        this.courseArrays = courseArrays;
    }

    public void doIt (Team team) {
        System.out.println("Команда " + team.getTeamName() + " проходит испытание ");
        for (Course course : courseArrays) {
            for (Member member : team.getMembers()) {
                System.out.println(member.getMemberName()  + " проходит испытние " + course.getCourseName());
            }
        }
        System.out.println("Команда " + team.getTeamName() + " прошла испытания ");
    }

    public String getCourseName(String courseName) {
        return courseName;
    }
}

/*Добавить класс Course (полоса препятствий), в котором будут находиться:
массив препятствий;
метод, который будет просить команду пройти всю полосу.
 */