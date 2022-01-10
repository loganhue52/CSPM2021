
public class TrashPanda extends Bear implements Swimming{
    public TrashPanda(){
        super("TrashPandie","He very very stank");
    }
    public TrashPanda(String name,String desc){
        super(name,desc);
    }
    public String swim(){
        return "the racoon kinda swims? looks like more of a flail";
    }
}
