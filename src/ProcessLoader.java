import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessLoader {
    private static final Logger LOGGER = Logger.getLogger(ProcessLoader.class.getName());

    public static List<Process> readProcessesFromFile(String filename) {
        List<Process> processes = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            LOGGER.log(Level.SEVERE, "Error: File not found -> " + filename);
            return processes; // إرجاع قائمة فارغة بدلاً من التسبب في خطأ
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            LOGGER.log(Level.INFO, "Reading processes from file: " + filename);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("[:;]");
                if (parts.length != 4) {
                    LOGGER.log(Level.WARNING, "Skipping invalid line: " + line);
                    continue;
                }

                int id = Integer.parseInt(parts[0]);
                int burstTime = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);
                int memory = Integer.parseInt(parts[3]);

                processes.add(new Process(id, burstTime, priority, memory));
            }
            LOGGER.log(Level.INFO, "Successfully loaded " + processes.size() + " processes.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file: " + filename, e);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Invalid number format in file: " + filename, e);
        }
        return processes;
    }
}
