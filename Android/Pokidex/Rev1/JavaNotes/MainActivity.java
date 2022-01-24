import java.util.*;

public class MainActivity{
     public static void main(String[] args) {
          //students
          //List object = Array as a List
          List<String> students = Arrays.asList("Kai","Tyler","Kevin","Scott","Logan");

          //courses
          //a List Object with the methods of an ArrayList object
          List<Course> courses = new ArrayList<>();
          courses.add(new Course("Trig","Gaege"));
          courses.add(new Course("Cooking","Gordon Ramsey"));
          courses.add(new Course("Gym","Dwyane The Rock Johnson"));
          courses.add(new Course("Econ","Jeff Bezos"));
          courses.add(new Course("Acting","Nick Cage"));

          /*
               courses = [course1,course2,course3,course4,course5]
               students = [kai,tyler,kevin,scott,logan]
               studentID = [1,2,3,4,5]

               // Hash Map
               var = {
                    student:course{
                         name,
                         instructor
                    },
                    student:course{
                         name,
                         instructor
                    },
                    student:course{
                         name,
                         instructor
                    }
               }               
          */
          //Map<keyDataType,valueDataType> objName = new HashMap<>();
          Map<String,Course> assignments = new HashMap<>();
          
          //add some courses to each students in the HashMap
          Random rand = new Random();
          for (String stu:students){
               int index = rand.nextInt(courses.size());
               assignments.put(stu,courses.get(index));
          }
          //System.out.println(assignments);   // print the hash...  including the objects

          //print out each students including the class
          //for(DataType localObject:List)   for each object in a list
          //for(int i=0;i<list.size();i++)   for i in the range of a number
          /*
          for(Map.Entry<String,Course> entry:assignments.entrySet()){
               //                  student is attending courseName that is taught by courseInstructor
               System.out.println(
                    entry.getKey() + " is attending " + entry.getValue().getName() + " that is taught by " + 
                                                        entry.getValue().getInstructor()
               );
          }
          */

          //find students registered to a certain course
          for(Map.Entry<String,Course> entry:assignments.entrySet()){
               //if nameOfTheCourse == "cooking"
               if(entry.getValue().getName().equals("Cooking")){
                    System.out.println(
                         entry.getKey() + " is attending " + entry.getValue().getName() + " that is taught by " + 
                                                             entry.getValue().getInstructor()
                    );
               }
          }



     }

}