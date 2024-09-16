package tcp;
import java.net.Socket;
import java.io.*;
import java.util.logging.*;

public class FileTransfer {
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

    public static void receiveFileConst(Socket socket, String DEFAULT_FILE_PATH) throws IOException {
        // Creates buffered input/output streams and closes the socket after use
        try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(DEFAULT_FILE_PATH))) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;

                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            
            logger.info("File received and saved succesfully at: " + DEFAULT_FILE_PATH);

            } catch (Exception e) {
            logger.severe("Error occured: " + e.getMessage());
        }
    }

    public static void sendFile(Socket socket, String filePath) throws IOException {
        // Creates file input/output streams and closes the socket after the code has run
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(outputStream)) {

            // Creates a buffer to hold bytes
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Reads the file and sends it to the client
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            logger.info("File sent succesfully at:" + filePath);

            // Logs if an error occures
            } catch (Exception e) {
            logger.severe("Error occured: " + e.getMessage());
        }
    }

    public static void receiveFile(Socket socket, String filePath) throws IOException {
        // Creates buffered input/output streams and closes the socket after use
        try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;

                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            
            logger.info("File received and saved succesfully at: " + filePath);

            } catch (Exception e) {
            logger.severe("Error occured: " + e.getMessage());
        }
    }

    public static void sendFileConst(Socket socket, String DEFAULT_FILE_PATH) throws IOException {
        // Creates file input/output streams and closes the socket after the code has run
        try (FileInputStream fileInputStream = new FileInputStream(DEFAULT_FILE_PATH);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream);
            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(outputStream)) {

            // Creates a buffer to hold bytes
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Reads the file and sends it to the client
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            logger.info("File sent succesfully at:" + DEFAULT_FILE_PATH);

            // Logs if an error occures
            } catch (Exception e) {
            logger.severe("Error occured: " + e.getMessage());
        }
    }
    
}

