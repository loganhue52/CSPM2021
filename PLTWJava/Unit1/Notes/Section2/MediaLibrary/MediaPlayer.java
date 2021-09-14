public class MediaPlayer {
    public static void main(String[] args){
        Songs s1 = new Songs();

        System.out.println(s1.getTitle());
        System.out.println(s1.getArtist());

        Songs s2 = new Songs("creature","half alive",5,9.99,3);
        System.out.println(s2.getTitle());
        System.out.println(s2.getArtist());

        s2.setTitle("not a creature"); // correct
        System.out.println(s2.getTitle());

        //s2.title="creature again"; //incorrect (error)

        //System.out.println(s2.title); //incorrect way to print (error)

        System.out.println(s2.getTitle()); //correct way to print
    }
}
