package lesson9;
//Задание 9 Синеокая Марина
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

        public static void main(String[] args) {
            SuperStudent superStudent1 = new SuperStudent("Vasya", new ArrayList(Arrays.asList("Java", "Scala", "Groovy")));
            SuperStudent superStudent2 = new SuperStudent("Petya", new ArrayList(Arrays.asList("Java", "Scala")));
            SuperStudent superStudent3 = new SuperStudent("Sahsha", new ArrayList(Arrays.asList("Java", "Scala", "Math", "English")));
            SuperStudent superStudent4 = new SuperStudent("Vitya", new ArrayList(Arrays.asList("Physics", "Scala", "Math")));

            List<Student> students = new ArrayList(Arrays.asList(superStudent1, superStudent2, superStudent3, superStudent4));
            //печатаем список уникальных курсов, на которые подписаны студенты
            System.out.println("Cписок уникальных курсов, на которые подписаны студенты:");
            System.out.println(returnAllCourses(students));
            System.out.println();
            //печатаем наибольшее количество курсов у 3 студентов
            System.out.println("Наибольшее количество курсов у трех студентов:");
            System.out.println(getInterestingStudents(students));
            System.out.println();
            //печатаем 3 студентов с наибольшим количеством курсов
            System.out.println("Cписок из трех самых любознательных студентов:");
            System.out.println(getInterestingStudents2(students));
            //System.out.println(getMyCourses(students, "Java"));
            System.out.println();
            //Печать списка студентов, посещающих курс типа Course
            SuperCourse course2=new SuperCourse("Java");
            System.out.println("Выбранный курс:");
            System.out.println(course2.getCourseName());
            System.out.println("Cписок студентов, которые посещают этот курс:");
            System.out.println(getMyCourses2(students, course2));

        }
        //1 задание
        static List<Course> returnAllCourses(List<Student> students) {

            return students.stream().flatMap(s -> s.getAllCourses().stream()).distinct().collect(Collectors.toList());
        }


        //2 задание, печатаем наибольшее количество курсов у 3 студентов
        static List<Long> getInterestingStudents(List<Student> students) {

            return students.stream().map(s -> s.getAllCourses().stream().count()).sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());

        }

    //2 задание, список студентов с максимальным числом курсов
    static List<String> getInterestingStudents2(List<Student> students) {

        return students.stream().sorted((с1, с2) -> с2.getAllCourses().size() - с1.getAllCourses().size())
                .limit(3)
                .map((Function<Student, String>) s -> s.getName())
                .collect(Collectors.toList());
    }

        //3 задание, course подается как String
        static List<String> getMyCourses(List<Student> students, String course) {
           return students
                   .stream().filter(s->s.getAllCourses().contains(course))
                   .map(Student::getName).collect(Collectors.toList());
        }

        //3 задание, course подается как Course посредством нового класса SuperCourse
        static List<String> getMyCourses2(List<Student> students, SuperCourse course) {
            return students
                    .stream().filter(s->s.getAllCourses().contains(course.getCourseName()))
                    .map(Student::getName).collect(Collectors.toList());
    }

    }



