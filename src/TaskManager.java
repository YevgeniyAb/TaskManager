import javax.lang.model.element.NestingKind;
import java.io.Console;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        TaskBase taskBase = new TaskBase();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите Ваше имя ");
        Manager manager = new Manager(scanner.nextLine());
        System.out.println("Добро пожаловать, " + manager.getManagerName() + "!");
        System.out.println("-------------------------");
        while(true){
            printMenu(manager.getManagerName());
            int userChoice = scanner.nextInt();
            if (userChoice == 0) {
                System.out.println("До свидания, " + manager.getManagerName());
                break;
            } else if (userChoice == 1) {
                System.out.println("Введите название задачи");
                String newTaskName1 = scanner.nextLine();
                String newTaskName = scanner.nextLine();
                System.out.println("Введите описание задачи");
                String newTaskDescription = scanner.nextLine();
                taskBase.addTask(new Task(newTaskName, newTaskDescription, manager.getNextId()));
                System.out.println("-------------------------");
            } else if (userChoice == 2) {
                System.out.println("=========================");
                taskBase.getAllTasks();
                System.out.println("=========================");
            } else if (userChoice == 3) {
                System.out.println("Введите идентификатор задачи");
                int taskId = scanner.nextInt();
                System.out.println("Введите новый статус задачи");
                System.out.println("1 - IN_PROGRESS");
                System.out.println("2 - DONE");
                System.out.println("3 - NEW");
                scanner.nextLine();
                int taskNewStatus = scanner.nextInt();
                TaskStatus taskStatus;
                switch (taskNewStatus) {
                    case 1:
                        taskStatus = TaskStatus.IN_PROGRESS;
                        break;
                    case 2:
                        taskStatus = TaskStatus.DONE;
                        break;
                    default:
                        taskStatus = TaskStatus.NEW;
                }
                taskBase.changeTaskStatus(taskId, taskStatus);
                System.out.println("-------------------------");
            } else {
                System.out.println("Неверная команда, попробуйте еще раз");
            }
        }


    }

    public static void printMenu(String managerName) {
        System.out.println(managerName + ", выберите что Вы хотите сделать");
        System.out.println("0 - Выйти");
        System.out.println("1 - Создать новую задачу");
        System.out.println("2 - Посмотреть список задач");
        System.out.println("3 - Изменить статус задачи");
        System.out.println("-------------------------");
    }
}

class Manager {
    private int currentId;
    private String managerName;

    public Manager(String managerName) {
        this.currentId = 0;
        this.managerName = managerName;
    }

    public int getNextId() {
        currentId += 1;
        return currentId;
    }

    public String getManagerName() {
        return managerName;
    }
}