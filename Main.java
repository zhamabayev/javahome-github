public class Main {
    public static void main(String[] args) {
        Member member1 = new Member ("Ivan", 20,50, 60);
        Member member2 = new Member ("Alexandr", 40, 30, 60);
        Member member3 = new Member ("Petr", 50,20, 30);
        Member member4 = new Member ("Alexey", 50,50,50);

        Member [] members = {member1, member2, member3, member4};
        Team team = new Team("Анализ благосостояния", members);

        Course runCourse = new Course("Забег", 50);
        Course swimCourse = new Course("Плаванье", 60);
        Course rideCourse = new Course("Велопробег", 30);

        Course[] courses = {runCourse, swimCourse, rideCourse};

        Barriers courses1 = new Barriers(courses);


        //просим команду пройти препятствия
        courses1.doIt(team);
        //показать результаты
        team.showResults(courses);
        // показываем участников
        System.out.println(team);
    }
}

/*
В итоге должно получиться похожее:
public static void main(String[] args) {
Course c = new Course(...); // Создаем полосу препятствий
Team team = new Team(...); // Создаем команду
c.doIt(team); // Просим команду пройти полосу
team.showResults(); // Показываем результаты
}
 */