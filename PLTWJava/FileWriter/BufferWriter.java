
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BufferWriter {
    //global vars
    private static final String DATA_FILE = "media.txt";
    private static Scanner in;
    private static BufferedWriter out;

    //readString
    public static String readString(){
        if(in==null){
            try{
                in = new Scanner(new File(DATA_FILE));
            } catch(Exception e){
                System.err.println("Cannot open file for input");
                e.printStackTrace();
            }
        }
        try{
            if(in.hasNext()){
                String s = in.nextLine();
                return s;
            } else{
                return null;
            }
        } catch(Exception e){
            System.err.println("Cannot read file");
            e.printStackTrace();
        }
        return null;
    }

    //writeString
    public static void writeString(String s){
        //check to see if out is already created or not
        if(out==null){
            try{
                out = new BufferedWriter(new FileWriter(DATA_FILE));
            } catch(Exception e){
                System.err.println("Cannot open file for output");
                e.printStackTrace();
            }
        }
        try{
            out.write(s);
            out.newLine();
        } catch(Exception e){
            System.err.println("Cannot write file");
            e.printStackTrace();
        }
    }

    //saveAndClose
    public static void saveAndClose(){
        //closes after the Scanner is done reading the file
        if(in!=null){
            try{
                in.close();
                in = null;
            } catch(Exception e){
                System.err.println("Cannot close input file");
                e.printStackTrace();
            }
        }
        //closes after the bufferwriter is done writing
        if(out!=null){
            try{
                out.close();
                out=null;
            } catch(Exception e){
                System.err.println("Cannot close output file");
                e.printStackTrace();
            }
        }
    }

}
