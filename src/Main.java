import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Process> processes = ProcessLoader.readProcessesFromFile("E:/Java Language/CPU_Scheduler_Simulation/src/job.txt");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Scheduling Algorithm: \n1. FCFS\n2. Round Robin\n3. Priority Scheduling");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                FCFS.execute(processes);
                break;
            case 2:
                RoundRobin.execute(processes, 7);
                break;
            case 3:
                PriorityScheduling.execute(processes);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
