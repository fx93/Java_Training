import java.io.*;

public class UpperCase {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/home/krishanth/Music/sample.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        UpperCase uc = new UpperCase();


        FileWriter fileWriter = new FileWriter("/home/krishanth/Music/upper.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(uc.read(bufferedReader));

        bufferedWriter.close();
        bufferedReader.close();
    }

    private String read(BufferedReader fr) throws IOException {
        int i;
        StringBuilder s = new StringBuilder();

        while((i = fr.read()) != -1){
            if(i >= 97 && i <= 122){
                i -= 32;
            }
            s.append((char)i);
        }

        return s.toString();
    }
}