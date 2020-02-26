
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ExampleServer {

    public static void main(String[] args){
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8292), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpContext context = server.createContext("/example");
        context.setHandler(ExampleServer::exampleRequest);
        server.createContext("/info", new InfoHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    private static void exampleRequest(HttpExchange httpExchange) throws IOException {
        String response = "Hi there!";
        httpExchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }

    static class InfoHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String response = "This is Info Method";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
