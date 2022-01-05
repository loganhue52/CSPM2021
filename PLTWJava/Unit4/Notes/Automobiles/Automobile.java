package Unit4.Notes.Automobiles;

public abstract class Automobile {
    String material,color,fuel,speed;

    public Automobile(String material, String color, String fuel, String speed){
        this.material=material;
        this.color=color;
        this.fuel=fuel;
        this.speed=speed;
    }
    public void accelerate(String newSpeed){this.speed=newSpeed;}
    public void stop(String newSpeed){this.speed="stop";}
    public void decelerate(String newSpeed){this.speed=newSpeed;}
}
