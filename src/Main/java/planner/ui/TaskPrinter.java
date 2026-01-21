package Main.java.planner.ui;

import Main.java.planner.model.Status;
import Main.java.planner.model.Task;

import java.util.List;

public class TaskPrinter {

    public static String statusToText(Status status){
        return switch (status){
            case TODO -> "Задача ещё не начата";
            case IN_PROGRESS -> "В процессе";
            case DONE -> "Задача завершена";
            case FAIL -> "Задача провалена";
        };
    }

    public static String format(Task task){
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

    public static void print(Task task){                    //Печать одной задачи
            System.out.println(format(task));
    }

    public static void printList(List<Task> task){          //Печать списка
        if (task.isEmpty() || task == null) {
            System.out.println("Список пуст!");
            return;
        }
        for (Task tasks : task){
            print(tasks);
        }
    }
}
