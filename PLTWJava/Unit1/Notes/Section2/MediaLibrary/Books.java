public class Books {
    String title;
    String author;
    int rating;

    public Books(){
        title="unknown";
        author="unknown";
    }
    public Books(String a,String t,int r){
        title=t;
        author=a;
        rating=r;
    }

    //setters
    public void setTitle(String t){
        //self
        this.title=t;
    }
    public void setArtist(String a){
        this.author=a;
    }
    public void setRating(int r){
        this.rating=r;
    }

    //getters
    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return author;
    }

    public int getRating(){
        return rating;
    }
}
