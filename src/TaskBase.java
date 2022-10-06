import java.util.ArrayList;

public class TaskBase {
    ArrayList<Task> allTasks;

    public TaskBase() {
        allTasks = new ArrayList<Task>();
    }

    public void getAllTasks() {
        if (allTasks.isEmpty()) {
            System.out.println("В списке отсутствуют задачи");
        }
        for (Task task : allTasks) {
            System.out.println(task.getTaskName());
        }
    }

    public void addTask (Task task) {
        allTasks.add(task);
    }

    public void changeTaskStatus (int taskId, TaskStatus taskStatus) {
        for (Task task : allTasks) {
            if (task.getTaskId() == taskId) {
                task.setTaskStatus(taskStatus);
            }
        }
    }
}
