
public class Black extends Bird {
    public Black(){
        super("Black","boom");
    }
    public Black(String name,String desc){
        super(name,desc);
    }
    @Override
    public String makeNoise(){
        return "boom";
    }
}
