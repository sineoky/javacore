package lesson1;
//Класс Робот
public class Robot implements Team {
    private String name;
    private int runTreadmill;
    private int jumpWall;

    public Robot(String name, int runTreadmill, int jumpWall) {
        this.name = name;
        this.runTreadmill = runTreadmill;
        this.jumpWall = jumpWall;
    }

    @Override
    public void run() {
        System.out.println("Робот " + this.name + " может пробежать: " + this.getRunTreadmill());
    }

    @Override
    public void jump() {
        System.out.println("Робот " + this.name + " может прыгать: " + this.getJumpWall());
    }

    @Override
    public int getRunTreadmill() {
        return this.runTreadmill;
    }

    @Override
    public int getJumpWall() {
        return this.jumpWall;
    }
}