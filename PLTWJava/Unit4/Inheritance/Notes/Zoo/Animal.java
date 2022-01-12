
public abstract class Animal{
    private String name;
    private String desc;
    
    public Animal(String name,String desc){
        this.name=name;
        this.desc=desc;
    }
    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
    public abstract String makeNoise();
}
