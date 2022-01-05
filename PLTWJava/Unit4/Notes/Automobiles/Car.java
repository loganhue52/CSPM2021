package Unit4.Notes.Automobiles;
public class Car{
    String wheels,material,steering,doors,color,fuel,speed;

    public Car(String wheels, String material, String steering, String doors, String color, String fuel, String speed){
        this.wheels=wheels;
        this.material=material;
        this.steering=steering;
        this.doors=doors;
        this.color=color;
        this.fuel=fuel;
        this.speed=speed;
    }

    public void accelerate(String newSpeed){this.speed=newSpeed;}
    public void stop(String newSpeed){this.speed="stop";}
    public void decelerate(String newSpeed){this.speed=newSpeed;}
}