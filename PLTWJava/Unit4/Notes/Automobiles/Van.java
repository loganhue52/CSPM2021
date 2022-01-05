package Unit4.Notes.Automobiles;

public class Van {
    String wheels,material,steering,doors,color,fuel,speed;
    public Van(String wheels,String material,String steering,String doors,String color,String fuel,String speed){
         this.wheels=wheels;
         this.material=material;
         this.wheels=wheels;
         this.material=material;
         this.steering=steering;
         this.doors=doors;
         this.color=color;
         this.fuel=fuel;
         this.speed=speed;
    }
    public void accelerate(String newSpeed){
         this.speed=newSpeed;
    }
    public void decelerate(String newSpeed){
         this.speed=newSpeed;
    }
    public void stop(){
         this.speed="STOP";
    }
}
