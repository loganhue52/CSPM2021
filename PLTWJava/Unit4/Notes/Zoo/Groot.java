public class Groot extends SpaceAnimal implements Walking{
    public Groot(){
        super("BrownBare","Brown");
    }
    public Groot(String name,String desc){
        super(name,desc);
    }
    public String walk(){
        return "he walk";
    }
}