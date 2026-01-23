package Main.java.planner.ui;

import Main.java.planner.model.Status;
import Main.java.planner.model.Task;
import Main.java.planner.service.TaskSorter;

import java.util.List;

public class TaskPrinter {

    private static String statusToText(Status status){
        return switch (status){
            case TODO -> "Задача ещё не начата";
            case IN_PROGRESS -> "В процессе";
            case DONE -> "Задача завершена";
            case FAIL -> "Задача провалена";
        };
    }

    private static String format(Task task){
         if (task.getStatus() == Status.TODO
        || task.getStatus() == Status.IN_PROGRESS) {
        return """
                %s
                %s
                Приоритет: %s
                Статус: %s
                Создана: %s
                Дедлайн: %s
                Осталось: %s
                """.formatted(task.getName(),
                task.getDescription(),
                task.getPriority(),
                statusToText(task.getStatus()),
                task.getFormattedCreatedAt(),
                task.getFormattedDeadLine(),
                task.getFormattedTimeLeft());
         } if (task.getStatus() == Status.DONE){
            return """
                    %s
                    %s
                    Приоритет: %s
                    Статус: %s
                    Завершена: %s
                    """.formatted(task.getName(),
                    task.getDescription(),
                    task.getPriority(),
                    statusToText(task.getStatus()),
                    task.getFormattedComplitedAt());
         } if (task.getStatus() == Status.FAIL){
            return """
                    %s
                    %s
                    Приоритет: %s
                    Статус: %s
                    """.formatted(task.getName(),
                    task.getDescription(),
                    task.getPriority(),
                    statusToText(task.getStatus()));
         }
         return " ";
    }

    private static void print(Task task){                    //Печать одной задачи
            System.out.println(format(task));
    }

    public static void printList(List<Task> tasks){          //Печать списка
        if (tasks.isEmpty() || tasks == null) {
            System.out.println("Список пуст!");
            return;
        }
        for (Task task : tasks){
            print(task);
        }
    }

    public static void printSortedByPriority(List<Task> tasks){
            printList(TaskSorter.sortByPriority(tasks));
    }

    public static void printSortedByTimeRemaining(List<Task> tasks){
        printList(TaskSorter.sortByTimeRemaining(tasks));
    }

    public static void printTaskFailed(List<Task> tasks){
        printList(TaskSorter.sortByStatusFailed(tasks));
    }

    public static void printTaskDone(List<Task> tasks) {
        printList(TaskSorter.sortByStatusDone(tasks));
    }

    public static void printTaskInProgress(List<Task> tasks){
        printList(TaskSorter.sortByStatusInProgress(tasks));
    }

    public static void printTaskToDo(List<Task> tasks){
        printList(TaskSorter.sortedByToDo(tasks));
    }
}
