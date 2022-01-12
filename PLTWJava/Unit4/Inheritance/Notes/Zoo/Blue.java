
public class Blue extends Bird implements Flying,Walking,Swimming{
    public Blue(){
        super("Blue","splits");
    }
    public Blue(String name,String desc){
        super(name,desc);
    }
    public String fly(){
        return "zooooooooommm";
    }
    public String walk(){
        return "plat, plat, plat";
    }
    public String swim(){
        return "bird takig a bath";
    }
}
