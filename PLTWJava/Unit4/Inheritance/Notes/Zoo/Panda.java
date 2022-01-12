
public class Panda extends Bear implements Walking{
    public Panda(){
        super("Pandie","He stank");
    }
    public Panda(String name,String desc){
        super(name,desc);
    }
    @Override
    public String walk(){
        return "he walk";
    }
}
