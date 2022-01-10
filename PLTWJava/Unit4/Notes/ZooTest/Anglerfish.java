
public class Anglerfish extends Fish implements Swimming{
    public Anglerfish(){
        super("angle man","he look mean");
    }
    public Anglerfish(String name,String desc){
        super(name,desc);
    }
    public String swim(){
        return "just keep swimming, just keep swimming";
    }
}
