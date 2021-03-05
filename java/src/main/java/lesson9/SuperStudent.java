package lesson9;
import java.util.ArrayList;
import java.util.List;

public class SuperStudent implements Student  {
    //public class SuperStudent implements Student, Course {
        private String name;
    private List<Course> allCourses;

    public SuperStudent(String name, List<Course> allCourses) {
        this.name = name;
        this.allCourses = allCourses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return allCourses;
    }
}
