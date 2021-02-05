package lesson1;
// задание к уроку №1 Синеокая Марина

public class Main {
    public static void main(String[] args) {
        boolean myResult;
        //создаю массив из 4 участников и его заполняю
        Team[] team = new Team[4];
        team[0] = new Human("Marina", 5, 4);
        team[1] = new Human("Grisha", 6, 5);
        team[2] = new Robot("Verter", 8, 6);
        team[3] = new Cat("Barsik", 2, 1);
        //создаю массив из 2 препятствий и его заполняю
        Course[] c = new Course[2];
        c[0] = new Treadmill("Treadmill1", 6);
        c[1] = new Wall("Wall1", 4);

        //просим всех членов команды пройти все препятствия полосы
        for (int i = 0; i < team.length; i++) {
            myResult = true;
            for (int j = 0; j < c.length; j++) {
                myResult = c[j].doIt(team[i]);
                if (!myResult) break;
            }
            if (myResult) {
                System.out.println("Соревнование пройдено");
            } else {
                System.out.println("Соревнование провалено");
            }
        }
    }
}