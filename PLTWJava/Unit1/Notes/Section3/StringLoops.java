package PLTWJava.Unit1.Notes.Section3;

public class StringLoops {
    public static void main(String[] args){
        // howMany("GIGGLING","G");
        // spaceFinder("If I type.  How many  double spaces  are there?  ");
        // replaceStuff("If I type.  How many  double spaces  are there?  ","  "," ");
        removeVowels("Coding in Java is so fun");
    }
    //count how many "a" are in s
    private static void howMany(String s, String v){
        int n = 0;
        for(int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals(v)){
                n++;
            }
        }
        System.out.println(n);
    }
    
    private static void spaceFinder(String s){

        int n = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.substring(i,i+2).equals("  ")){
                n++;
            }
        }
        System.out.println(n);
    }

    private static void replaceStuff(String s, String f, String r){
        while(s.indexOf(f) != -1){
            s = s.substring(0,s.indexOf(r)) + s.substring(s.indexOf(r))+1;
        }
        System.out.println(s);
    }

    private static void removeVowels(String s){
        String output="";
        if(Math.random()>.5){
            for(int i=0;i<s.length()-1;i++){
                String x = s.substring(i,i+1);
                if (!(x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u"))){
                    output+=x;
                }
    
            }
        } else{
            for(int i=0;i<s.length()-1;i++){
                String x = s.substring(i,i+1);
                if (!(x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u") || x.equals("y"))){
                    output+=x;
                }
    
            }
        }
        System.out.println(output);
        
    }
}