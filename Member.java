public class Member {
    private String memberName;
    private Integer runPowerfull;
    private Integer swimPowerfull;
    private Integer ridePowerfull;

    public Member (String memberName, int runPowerfull, int swimPowerfull, int ridePowerfull){
        this.memberName = memberName;
        this.runPowerfull = runPowerfull;
        this.swimPowerfull = swimPowerfull;
        this.ridePowerfull = ridePowerfull;
    }


//геттеры
    public String getMemberName() {
        return memberName;
    }
    public Integer getRunPowerfull() {

        return runPowerfull;
    }
    public Integer getSwimPowerfull() {

        return swimPowerfull;
    }
    public Integer getRidePowerfull() {

        return ridePowerfull;
    }
    public String toString () {
        return getMemberName();
    }

}
