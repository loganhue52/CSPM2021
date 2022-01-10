public class MichaelPhelps extends SpaceAnimal implements Swimming{
    public MichaelPhelps(){
        super("BrownBare","Brown");
    }
    public MichaelPhelps(String name,String desc){
        super(name,desc);
    }
    public String swim(){
        return "he swim... fast";
    }
}
