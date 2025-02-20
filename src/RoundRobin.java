import java.util.*;

public class RoundRobin {
    public static void execute(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>(processes);
        int currentTime = 0;

        System.out.println("\nExecuting Round Robin:");
        while (!queue.isEmpty()) {
            Process p = queue.poll();
            if (p.burstTime > quantum) {
                System.out.println("Process " + p.id + " executed for " + quantum + "ms");
                p.burstTime -= quantum;
                currentTime += quantum;
                queue.add(p);
            } else {
                System.out.println("Process " + p.id + " completed execution.");
                currentTime += p.burstTime;
                p.waitingTime = currentTime - p.burstTime;
                p.turnaroundTime = currentTime;
            }
        }
    }
}
