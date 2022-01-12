public class SpaceAnimal extends Animal{
    public SpaceAnimal(){
        super("SpaceAnimal","in space");
    }
    public SpaceAnimal(String name,String desc){
        super(name,desc);
    }
    @Override
    public String makeNoise(){
        return "there is no noise in space";
    }
}
