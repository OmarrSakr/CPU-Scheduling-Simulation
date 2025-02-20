public class Process {
    int id;
    int burstTime;
    int priority;
    int memory;
    int waitingTime = 0;
    int turnaroundTime = 0;

    public Process(int id, int burstTime, int priority, int memory) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.memory = memory;
    }
}
