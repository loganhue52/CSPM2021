
public class Fish extends Animal {
    public Fish(){
        super("Fishie","just keep swimming");
    }
    public Fish(String name, String desc){
        super(name,desc);
    }
    @Override
    public String makeNoise(){
        return "blop blop";
    }
}
