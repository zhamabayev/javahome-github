import java.util.Arrays;

public class Team {
    private String teamName;
    private Member[] members;

    public Team(String teamName) {
        this.teamName = teamName;
    }
    public Team(String teamName, Member[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    // метод для вывода информации о членах команды, прошедших дистанцию
    public void showResults(Course [] courses) {
        for (Member member: members ) {
            System.out.println("Участник " + member.getMemberName() + ": ");
            for (Course course : courses) {
                if (course.getCourseName() != null && course.getCourseName().equals("Забег")) {
                    if (member.getRunPowerfull() >= course.getDifficulty()) {
                        System.out.println("Закончил пробег");
                    } else {
                        System.out.println("Не закончил пробег");
                    }
                }

                if (course.getCourseName() != null && course.getCourseName().equals("Плаванье")) {
                    if (member.getSwimPowerfull() >= course.getDifficulty()) {
                        System.out.println("Закончил заплыв");
                    } else {
                        System.out.println("Не закончил заплыв");
                    }
                }

                if (course.getCourseName() != null && course.getCourseName().equals("Велопробег")) {
                    if (member.getRidePowerfull() >= course.getDifficulty()) {
                        System.out.println("Закончил Велопробег");
                    } else {
                        System.out.println("Не закончил Велопробег");
                    }
                }
            }
        }


    }
    // метод вывода информации обо всех членах команды
    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", members=" + Arrays.toString(members) +
                '}';
    }

}


/* Добавить класс Team, который будет содержать:
название команды;
массив из четырех участников — в конструкторе можно сразу всех участников указывать);
метод для вывода информации о членах команды, прошедших дистанцию;
метод вывода информации обо всех членах команды.
*/