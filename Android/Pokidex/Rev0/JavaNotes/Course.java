public class Course {
     public String name;
     public String instructor;

     public Course(){}

     public Course(String name, String instructor){
          this.name = name;
          this.instructor = instructor;
     }

     //getters and setters
     public String getName(){
          return name;
     }
     public String getInstructor(){
          return instructor;
     }
     public void setName(String newName){
          this.name = newName;
     }
     public void setInstructor(String newInstructor){
          this.instructor = newInstructor;
     }

}
