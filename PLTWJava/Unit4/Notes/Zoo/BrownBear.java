
public class BrownBear extends Bear implements Walking{
    public BrownBear(){
        super("BrownBare","Brown");
    }
    public BrownBear(String name,String desc){
        super(name,desc);
    }
    public String walk(){
        return "he walk";
    }
}
