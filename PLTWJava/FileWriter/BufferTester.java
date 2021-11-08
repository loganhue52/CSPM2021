
public class BufferTester {
    public static void main(String[] args) {
        //class we built. fuction we build
        BufferWriter.writeString("Hello World!");
        BufferWriter.saveAndClose();
        System.out.println(BufferWriter.readString());
    }
}
