public class Account {
    String username;
    String password;
    String title;
    String catagory;

    public Account(String t, String u, String p, String c){
        username = u;
        password = p;
        title = t;
        catagory = c;
    }
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
