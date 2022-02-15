package JavaCore.HomeWork1;

class Member {
    public String memberName;
    public int health;

    public Member(String memberName, int health) {
        this.memberName = memberName;
        this.health = health;
    }
    void competition(Course course) {
        if (health < (course.runDistance + course.swimDistance)) {
            System.out.println("Участник " + memberName + " не прошел дистанцию");
        } else {
            System.out.println("Участник " + memberName + " успешно прошел дистанцию");
        }
    }

    public String toString() {
        return  memberName;
    }
}