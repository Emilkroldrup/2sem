package drivhus.Handlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                processSensorData(inputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processSensorData(String data) {
        Logger.logData(data);
        AlarmChecker.checkThreshold(data);
    }
}
