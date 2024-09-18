package drivhus;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class SensorClient implements Runnable {
    private String sensorType;
    private String serverHost;
    private int serverPort;
    
    public SensorClient(String sensorType, String serverHost, int serverPort) {
        this.sensorType = sensorType;
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    private double generateData() {
        Random rand = new Random();
        switch (sensorType) {
            case "Temperature":
                return 5 + (35 - 5) * rand.nextDouble(); // Random temp between 5 and 35
            case "Humidity":
                return 10 + (90 - 10) * rand.nextDouble(); // Random humidity between 10% and 90%
            case "SoilMoisture":
                return 10 + (50 - 10) * rand.nextDouble(); // Random soil moisture between 10% and 50%
            default:
                return 0;
        }
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(serverHost, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            while (true) {
                double data = generateData();
                out.println(sensorType + ": " + data);
                Thread.sleep(5000); // Send data every 5 seconds
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;

        // Start Temperature Sensor
        SensorClient temperatureSensor = new SensorClient("Temperature", serverHost, serverPort);
        new Thread(temperatureSensor).start();

        // Start Humidity Sensor
        SensorClient humiditySensor = new SensorClient("Humidity", serverHost, serverPort);
        new Thread(humiditySensor).start();

        // Start Soil Moisture Sensor
        SensorClient soilMoistureSensor = new SensorClient("SoilMoisture", serverHost, serverPort);
        new Thread(soilMoistureSensor).start();
    }
}
