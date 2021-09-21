package PLTWJava.Unit1.Notes.Section2.MediaLibrary;

public class Songs {
    //title, artist, rating, price, duration
    String title;
    String artist;
    int rating;
    double price;
    double duration;

    public Songs(){
        title="random title";
        artist="unknown artist";
        System.out.println("Object created");
    }

    public Songs(String t, String a,int r,double p, double d){
        title=t;
        artist=a;
        rating=r;
        price=p;
        duration=d;
    }

    //methods
    //getters and setters or accessors and mutators

    //setters
    public void setTitle(String t){
        //self
        this.title=t;
    }
    public void setArtist(String a){
        this.artist=a;
    }
    public void setRating(int r){
        this.rating=r;
    }

    //getters
    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public int getRating(){
        return rating;
    }
}
