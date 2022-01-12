public class Wookie extends SpaceAnimal implements Walking{
    public Wookie(){
        super("BrownBare","Brown");
    }
    public Wookie(String name,String desc){
        super(name,desc);
    }
    public String walk(){
        return "he walk";
    }
}