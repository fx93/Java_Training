import java.io.*;

public class UpperApplication extends BufferedReader{

    public UpperApplication(Reader reader) {
        super(reader);
    }

    @Override
    public String readLine() throws IOException {
        String line;
        if(super.readLine()!=null){
            line = super.readLine().toUpperCase();
        }
        else{line = null;}
        return line;
    }

    @Override
    public int read() throws IOException {
        int x = super.read();

        while(x != -1){
            if(x >= 97 && x <= 122){
                x -= 32;
            }
        }
        return x;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/home/krishanth/Music/sample.txt");
        UpperApplication ua = new UpperApplication(fileReader);
        FileWriter fileWriter = new FileWriter("/home/krishanth/Music/upper.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while(ua.readLine()!= null){
            bufferedWriter.write(ua.readLine());
        }

        bufferedWriter.close();
        ua.close();
    }

}
