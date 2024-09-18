package drivhus.Handlers;

public class AlarmChecker {
    private static final double HIGH_TEMP_THRESHOLD = 30.0;
    private static final double LOW_TEMP_THRESHOLD = 10.0;
    private static final double HIGH_HUMIDITY_THRESHOLD = 70.0;
    private static final double LOW_HUMIDITY_THRESHOLD = 30.0;
    private static final double LOW_SOIL_MOISTURE_THRESHOLD = 20.0;

    public static void checkThreshold(String data) {
        String[] parts = data.split(": ");
        String sensorType = parts[0];
        double value = Double.parseDouble(parts[1]);

        switch (sensorType) {
            case "Temperature":
                if (value > HIGH_TEMP_THRESHOLD) {
                    System.out.println("ALARM: Temperature exceeds high threshold! (" + value + "°C)");
                } else if (value < LOW_TEMP_THRESHOLD) {
                    System.out.println("ALARM: Temperature below low threshold! (" + value + "°C)");
                }
                break;
            case "Humidity":
                if (value > HIGH_HUMIDITY_THRESHOLD) {
                    System.out.println("ALARM: Humidity exceeds high threshold! (" + value + "%)");
                } else if (value < LOW_HUMIDITY_THRESHOLD) {
                    System.out.println("ALARM: Humidity below low threshold! (" + value + "%)");
                }
                break;
            case "SoilMoisture":
                if (value < LOW_SOIL_MOISTURE_THRESHOLD) {
                    System.out.println("ALARM: Soil moisture below threshold! (" + value + "%)");
                }
                break;
            default:
                System.out.println("Unknown sensor type");
        }
    }
}
