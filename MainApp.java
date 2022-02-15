package JavaCore.HomeWork1;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        Member[] members = new Member[4];
        members[0] = new Member("Ivan", 200);
        members[1] = new Member("Alexandr", 250);
        members[2] = new Member("Petr", 150);
        members[3] = new Member("Grygory", 100);

        Team team = new Team("DreamTeam", members);

        Course course = new Course(100, 100);

        for (Member member : members) {
            member.competition(course);
        }
        System.out.println("Участники: ");
        System.out.println(Team.teamName + " " + Arrays.toString(members));
    }
}
