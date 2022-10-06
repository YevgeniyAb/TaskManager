enum TaskStatus {NEW, IN_PROGRESS, DONE};

public class Task {
    private String taskName;
    private String taskDescription;
    private int taskId;
    private TaskStatus taskStatus;

    public Task(String taskName, String taskDescription, int taskId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskId = taskId;
        this.taskStatus = TaskStatus.NEW;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}

