package lesson1;
//Класс Кот
public class Cat implements Team {
    private String name;
    private int runTreadmill;
    private int jumpWall;

    public Cat(String name, int runTreadmill, int jumpWall) {
        this.name = name;
        this.runTreadmill = runTreadmill;
        this.jumpWall = jumpWall;
    }

    @Override
    //вывод информации сколько может пробежать
    public void run() {
        System.out.println("Кот " + this.name + " может пробежать: " + this.getRunTreadmill());
    }

    @Override
    //вывод информации сколько может прыгать
    public void jump() {
        System.out.println("Кот" + this.name + " может прыгать: " + this.getJumpWall());
    }

    @Override
    //сколько надо пробежать
    public int getRunTreadmill() {
        return this.runTreadmill;
    }

    @Override
    //сколько надо прыгнуть
    public int getJumpWall() {
        return this.jumpWall;
    }
}