import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ExampleClient {

    private String ip, port;

    public static void main(String[] args) {

        ExampleClient client = new ExampleClient();
        client.createConnection("localhost","8292");

    }

    public void createConnection(String host, String port) {
        String adrslink = "https:"+ ip + ":" + port + "/info";

        URL myUrl = null;
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            myUrl = new URL(adrslink);
            connection = (HttpURLConnection) myUrl.openConnection();
            inputStream = connection.getInputStream();

            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null) {
                System.out.println(inputLine);
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}