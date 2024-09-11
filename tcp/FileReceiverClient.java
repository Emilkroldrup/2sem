package tcp;

import java.io.*;
import java.net.*;
import java.util.logging.Logger;

public class FileReceiverClient {
    private static final Logger logger = Logger.getLogger(FileReceiverClient.class.getName());
    public static void main(String[] args) {
        String address = "localhost";
        int port = 8080;

        // File location for the received file by the server
        String filePath = "3semester/receivedFiles/received_file.txt";
        // String filePath = "3semester/receivedFiles/Wong.png";

        try (Socket socket = new Socket(address, port)){
            System.out.println("Connected to the server: " + address + ":" + port);

            // Received the file from the server
            receiveFile(socket, filePath);

            // Close the connection
            socket.close();
            System.out.println("You recieved the file, connection to the server cloed.");
        } catch (IOException e){
            logger.severe("Didn't receive the file, connection to the server closed. " + e.getMessage());
        }
    }
    private static void receiveFile(Socket socket, String filePath){
        try{
            // Creating input stream to receive the file from the server via the socket
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

            // Creating output stream to write the file to the local system
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Receive file and write to local disk
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            // Close streams
            bos.close();
            bis.close();
            socket.close();

            System.out.println("File received and save successfully.");
        } catch (IOException e){
            logger.severe("Didn't receive the file, connection to the server closed. " + e.getMessage());
        }
    }
}
