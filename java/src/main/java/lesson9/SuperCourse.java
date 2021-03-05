package lesson9;

public class SuperCourse implements Course{
    private String courseName;

    public SuperCourse(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
