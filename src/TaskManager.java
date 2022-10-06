import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите Ваше имя ");
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager(scanner.nextLine());
        System.out.println("Добро пожаловать, " + manager.getManagerName() + "!");
        while(true){
            printMenu(manager.getManagerName());
            int userChoice = scanner.nextInt();
            if (userChoice == 0) {
                System.out.println("До свидания, " + manager.getManagerName());
                break;
            } else if (userChoice == 1) {
                Task task = new Task("Buy a book", "Go to shop buy book", manager.getNextId());
            } else if (userChoice == 2) {
                System.out.println("task.getTaskStatus()");
            } else {
                System.out.println("Неверная команда, попробуйте еще раз");
            }
        }


    }

    public static void printMenu(String managerName) {
        System.out.println(managerName + ", выберите что Вы хотите сделать");
        System.out.println("0 - Выйти");
        System.out.println("1 - Создать новую задачу");
        System.out.println("2 - Посмотреть статус задачи");
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