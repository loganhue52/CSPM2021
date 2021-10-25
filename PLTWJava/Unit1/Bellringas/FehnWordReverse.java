package Unit1.Bellringas;

public class FehnWordReverse {
    public static void main(String[] args){
        wordReverse("lasagna");
    }
    private static void wordReverse(String w){
        String r = "";
        for (int i=w.length()-1;i>=0;i--){
            r+=w.substring(i,i+1);
        }
        System.out.println(r);
    }
}