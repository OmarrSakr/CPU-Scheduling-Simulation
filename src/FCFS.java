import java.util.List;

public class FCFS {
    public static void execute(List<Process> processes) {
        int currentTime = 0;
        System.out.println("\nExecuting FCFS:");
        for (Process p : processes) {
            p.waitingTime = currentTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;
            System.out.println("Process " + p.id + " -> Waiting Time: " + p.waitingTime + ", Turnaround Time: " + p.turnaroundTime);
        }
    }
}
