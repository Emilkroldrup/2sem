package drivhus;

import drivhus.Handlers.ClientHandler;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GreenhouseServer {
    private static final int PORT = 12345;
    private static final int MAX_THREADS = 10;
    private ExecutorService threadPool;

    public GreenhouseServer() {
        threadPool = Executors.newFixedThreadPool(MAX_THREADS);
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Greenhouse Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GreenhouseServer server = new GreenhouseServer();
        server.startServer();
    }
}
