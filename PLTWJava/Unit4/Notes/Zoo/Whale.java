
public class Whale extends Fish implements Swimming{
    public Whale(){
        super("whale","he is BIG");
    }
    public Whale(String name,String desc){
        super(name,desc);
    }
    public String swim(){
        return "its so slow it looks like it isnt moving";
    }
}
