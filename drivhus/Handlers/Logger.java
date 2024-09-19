package drivhus.Handlers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String LOG_FILE = "greenhouse_data.log";

    public static synchronized void logData(String data) { // logs det data gathered when running the program
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
