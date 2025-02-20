import java.util.*;

public class PriorityScheduling {
    public static void execute(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> -p.priority)); // ترتيب حسب الأولوية (الأعلى أولًا)
        int currentTime = 0;
        System.out.println("\nExecuting Priority Scheduling:");
        for (Process p : processes) {
            p.waitingTime = currentTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;
            System.out.println("Process " + p.id + " -> Priority: " + p.priority + ", Waiting Time: " + p.waitingTime + ", Turnaround Time: " + p.turnaroundTime);
        }
    }
}
