import java.util.*;

public class MainActivity{
    public static void main(String[] args){
        //list object = array as a list
        List<String> students = Arrays.asList("Kai","Tyler","Kevin","Scoot","Logan");

        //courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Trig","Gaege"));
        courses.add(new Course("Cooking","Gordon"));
        courses.add(new Course("Gym","The Rock"));
        courses.add(new Course("Econ","Jeff"));
    }
}