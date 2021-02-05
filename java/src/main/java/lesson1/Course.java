package lesson1;
//полоса препятствий
public abstract class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    abstract boolean doIt(Team team);

    public String getName() {
        return name;
    }
}
