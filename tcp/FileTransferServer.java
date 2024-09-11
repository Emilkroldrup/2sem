package tcp;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class FileTransferServer {
    private static final Logger logger = Logger.getLogger(FileTransferServer.class.getName());

    public static void main(String[] args) {
        // Define the port number the server will listen on
        int port = 8080;

        // File to be sent to the client
        String filePath = "3semester/files/file.txt";
        // String filePath = "3semester/files/Wong.png";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server listening on port " + port);

            // Wait for a client connection
            Socket clientSocket = serverSocket.accept();
            logger.info("Client connected");

            // Send the file to the client
            sendFile(clientSocket, filePath);

            // Close the connection
            clientSocket.close();
            logger.info("File transfer completed, connection closed.");

        } catch (IOException e) {
            logger.severe("Error occurred: " + e.getMessage());
        }
    }

    private static void sendFile(Socket clientSocket, String filePath) {
        try {
            // Create file input stream to read the file
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            // Create output stream to send the file over the network
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            // Create a buffer to hold file bytes
            byte[] buffer = new byte[1024]; // 1 KB buffer size
            int bytesRead;

            // Read the file and send it to the client
            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

            // Close the streams
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();

            logger.info("File sent successfully.");

        } catch (IOException e) {
            logger.severe("Error while sending file: " + e.getMessage());
        }
    }
}
