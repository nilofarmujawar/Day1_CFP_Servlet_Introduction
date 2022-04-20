
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static int DEFAULT_PORT = 8080;
    public static int port;
    private HttpsServer httpsServer;

    private void start(int port) {
        this.port = port;
        try {
            httpsServer = HttpsServer.create(new InetSocketAddress(port), 0);
            System.out. println("server started at " + port);
            httpsServer.createContext("/", new Handlers.RootHandler() {
                @Override
                public void handle(HttpExchange httpExchange) throws IOException {

                }
            });
//            httpsServer.createContext("/echoHeader", new Handlers.EchoHeaderHandler());
//            httpsServer.createContext("/echoGet", new Handlers.EchoGetHandler());
//            httpsServer.createContext("/echoPost", new Handlers.EchoPostHandler()); 
            httpsServer.setExecutor(null);
            httpsServer.start();
        }
        catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        SimpleHttpServer httpServer = new SimpleHttpServer();
        httpServer.start(DEFAULT_PORT);
    }

}