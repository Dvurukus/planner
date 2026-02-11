import Main.java.planner.model.Task;
import Main.java.planner.service.TaskManager;
import Main.java.planner.service.TaskSorter;
import Main.java.planner.ui.TaskPrinter;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task(10, "Создать проект", "Создать планер задач", LocalDateTime.now().plusWeeks(1));
        Task task2 = new Task(5, "Помыть посуду", "Вымыть всю поганую посуду", LocalDateTime.now().plusHours(3));
        Task task3 = new Task(7, "Сходить в магазин", "Купить продукты", LocalDateTime.now().plusHours(2));

        TaskManager manager = new TaskManager();

        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);

        manager.statusDone(task1);




    Task task4 = new Task(73, "создать писюн", "", LocalDateTime.now().plusWeeks(4));

    manager.addTask(task4);


    Task task5 = new Task(1,"играть в валорант","", LocalDateTime.now().plusWeeks(1));

    manager.addTask(task5);

    TaskPrinter.printSortedByPriority(manager.getTasks());
}
}
