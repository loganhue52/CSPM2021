public class StarWhale extends SpaceAnimal implements Flying{
    public StarWhale(){
        super("BrownBare","Brown");
    }
    public StarWhale(String name,String desc){
        super(name,desc);
    }
    public String fly(){
        return "he fly";
    }
}
