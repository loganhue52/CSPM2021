public class Account {
    //initializing the variables
    String username;
    String password;
    String title;
    String catagory;

    //this is for creating an empty account, makes the values null
    public Account(){
        title=null;
        username=null;
        password=null;
        catagory=null;
    }
    //this is for making the actual accounts
    public Account(String t, String u, String p, String c){
        title = t;
        username = u;
        password = p;
        catagory = c;
    }
    //getters and setters
    public void setUsername(String u){
        this.username=u;
    }
    public void setTitle(String t){
        this.title=t;
    }
    public void setPassword(String u){
        this.password=u;
    }
    public void setCatagory(String c){
        this.catagory=c;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getTitle(){
        return title;
    }
    public String getCatagory(){
        return catagory;
    }
}
