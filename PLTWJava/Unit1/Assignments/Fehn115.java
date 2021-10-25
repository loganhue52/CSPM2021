package Unit1.Assignments;

public class Fehn115 {
    public static void main(String[] args){
    // theplanets.org average distance from earth to the planets
    int mercury = 56974146;
    int venus = 25724767;
    int mars = 48678219;
    int jupiter = 390674710;
    int saturn = 792248270;

    // number of planets to visit
    int numPlanets = 5;

    // speed of light and our speed
    int lightSpeed =  670616629;
    lightSpeed /= 10;

    // total travel time
    double total = 0;

    /* your code here */
    double timeToMercury = mercury;
    timeToMercury/=lightSpeed;

    double timeToVenus = venus;
    timeToVenus/=lightSpeed;
    
    double timeToMars = mars;
    timeToMars/=lightSpeed;

    double timeToJupiter = jupiter;
    timeToJupiter/=lightSpeed;

    double timetoSaturn = saturn;
    timetoSaturn/=lightSpeed;

    total = total + timeToMercury + timeToVenus + timeToMars + timeToJupiter + timetoSaturn;

    System.out.println("Time to Murcury: "+timeToMercury);
    System.out.println("Time to Venus: "+timeToVenus);
    System.out.println("Time to Mars: "+timeToMars);
    System.out.println("Time to Jupiter: "+timeToJupiter);
    System.out.println("Time to Saturn: "+timetoSaturn);
    System.out.println("Total Time: "+total);
    
  }
}
