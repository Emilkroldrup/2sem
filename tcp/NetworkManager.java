package tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.*;

public class NetworkManager {
    // initializes the default values
    final int DEFAULT_PORT = 8080;
    final String DEFAULT_ADDRESS = "localhost";
    final String DEFAULT_FILE_PATH = "3semester/receivedFiles/receive_file.txt";

    // instantiates a logger object
    private static final Logger logger = Logger.getLogger(NetworkManager.class.getName());

    public static void main(String[] args) {
        // instatiates variables
        String address;
        String filePath;
    }

    public static Socket connectToServer(String address, int port) throws IOException {
        // the try with ressources closes the socket automatically
        try (Socket socket = new Socket(address, port)) {

            // logs the details about the server
            logger.info("Connected to the server: " + address + ": " + port);

            // returns the clients socket
            return socket;

        // logs if an error occures + displays which address and port used
        } catch (Exception e) {
            logger.severe("Error occured when connecting to server: "+ address + port + " -" + e.getMessage());
        }
        // returns nothing if it can't get the socket
        return null;
    }

    public static void startServer(int port) throws IOException {
        // try with ressources block to make sure everything closes correct after use
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server is listening on declared port" + port);
            Socket socket = serverSocket.accept();
            logger.info("Client Connected.");

            // creates readers and writers to read and write data
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        // logs if an error occures and which port is used
        } catch (Exception e) {
            logger.severe("Error occured whejn starting aerver on port: " + port +" -"+ e.getMessage());
        }
    }

    public static Socket connectToServerConst(String DEFAULT_ADDRESS, int DEFAULT_PORT) throws IOException {
        // the try with ressources closes the socket automatically
        try (Socket socket = new Socket(DEFAULT_ADDRESS, DEFAULT_PORT)) {

            // logs the details about the server
            logger.info("Connected to the server: " + DEFAULT_ADDRESS + ": " + DEFAULT_PORT);

            // returns the clients socket
            return socket;

        // logs if an error occures + displays which address and port used
        } catch (Exception e) {
            logger.severe("Error occured when connecting to server: "+ DEFAULT_ADDRESS + DEFAULT_PORT + " -" + e.getMessage());
        }
        // returns nothing if it can't get the socket
        return null;
    }


    public static void startServerConst(int DEFAULT_PORT) throws IOException {
        // try with ressources block to make sure everything closes correct after use
        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT)) {
            logger.info("Server is listening on declared port" + DEFAULT_PORT);
            Socket socket = serverSocket.accept();
            logger.info("Client Connected.");

            // creates readers and writers to read and write data
            BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

        // logs if an error occures and which port is used
        } catch (Exception e) {
            logger.severe("Error occured whejn starting aerver on port: " + DEFAULT_PORT +" -"+ e.getMessage());
        }
    }

}
