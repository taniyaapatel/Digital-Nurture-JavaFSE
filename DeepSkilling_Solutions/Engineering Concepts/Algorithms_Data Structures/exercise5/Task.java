package exercise5;
public class Task {
    private String taskId, taskName;
    public Task(String id, String name) { taskId = id; taskName = name; }
    public String getTaskId() { return taskId; }
    @Override
    public String toString() { return "Task " + taskId; }
}
