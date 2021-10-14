/*
 * Activity 3.6.4
 */
public class Player{
    private String name;
    private int age;
    private int school;
    
    /* constructors */
    public Player(){
        this.name = "";
        this.age = 0;
        this.school = "";
    }
      
    public Player(String name){
        this.name = name;
        this.age = 0;
        this.school = "";
    }
    
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.school = "";
    }

    public Player(String name, int age, String school){
        this.name = name;
        this.age = age;
        this.school = school;
    }
    
    /* accessors */
    public int getAge(){
        return age;
    }
      
    public String getName(){
        return name;
    }
    public String getSchool(){
        return school;
    }
  
    /* mutators */
    public void setName(String name){
        this.name = name;
    }
    
    public void setPoints(int age){
        this.age = age;
    }
  
}  