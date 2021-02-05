package lesson1;
//Класс беговая дорожка
public class Treadmill extends Course {
    private int length;

    public Treadmill(String name, int length) {
        super(name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    protected boolean doIt(Team team) {
        System.out.println("Препятствие беговая дорожка " + super.getName() + " длина: " + this.length);
        team.run();
        if (getLength() <= team.getRunTreadmill()) {
            System.out.println("Пробежала успешно");
            return true;
        } else {
            System.out.println("Не смогла пробежать");
            return false;
        }
    }
}