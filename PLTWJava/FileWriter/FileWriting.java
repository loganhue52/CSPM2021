//use FileOutputStream
import java.io.*;

public class FileWriting{
    public static void main(String[] args) throws IOException{
        //try to do this
        try(FileOutputStream output = new FileOutputStream("temp.txt");){
            //if it works do this
            for(int i=0;i<=100;i++){
                int r = (int) (Math.random()*10);
                output.write(r);
                byte comma = 44;
                output.write(comma);
            }
        }
        //if it fail, throw IOException

        try(FileInputStream input = new FileInputStream("temp.txt");){
            //loop to render ints and bytes
            int value;
            while((value=input.read())!=-1){
                if(value!=44){
                    System.out.println(value);
                }
            }
        }
    }
}