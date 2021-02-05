package lesson1;
//Класс стена
public class Wall extends Course {
    private int heigth;

    public Wall(String name, int heigth) {
        super(name);

        this.heigth = heigth;
    }

    public int getHeigth() {
        return heigth;
    }

    @Override
    protected boolean doIt(Team team) {
        System.out.println("Препятствие стена " + super.getName() + " высота: " + this.heigth);
        team.jump();
        if (getHeigth() <= team.getJumpWall()) {
            System.out.println("Прыгнул удачно");
            return true;
        } else {
            System.out.println("Не смог прыгнуть");
            return false;
        }
    }
}

