
public abstract class Bear extends Animal {
    public Bear(){
        super("Teddy","bear");
    }
    public Bear(String name, String desc){
        super(name,desc);
    }
    @Override
    public String makeNoise(){
        return "rawr";
    }
    public abstract String walk();
}
