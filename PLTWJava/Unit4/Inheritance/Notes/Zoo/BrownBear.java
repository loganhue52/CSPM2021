
public class BrownBear extends Bear implements Walking{
    public BrownBear(){
        super("BrownBare","Brown");
    }
    public BrownBear(String name,String desc){
        super(name,desc);
    }
    @Override
    public String walk(){
        return "smokey is inspecting for forest fires";
    }

}
