package Main.java.planner.service;

import Main.java.planner.model.Status;
import Main.java.planner.model.Task;
import Main.java.planner.util.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskSorter {

    public static List<Task> sortByPriority(List<Task> tasks){                     //Сортировка по приоритету
        return tasks.stream()
        .sorted(Comparator.comparing(Task::getPriority).reversed())
        .toList();
    }

    public static List<Task> sortByTimeRemaining(List<Task> tasks){                //Сортировка по оставшемуся времени
        return tasks.stream().filter(
                t -> t.getStatus() != Status.DONE && t.getStatus() != Status.FAIL)
                .sorted(Comparator.comparing(Task::getUnFormattedDeadLine))
                .toList();
    }

    public static List<Task> sortByStatusDone(List<Task> tasks){
        return tasks.stream().filter(
                t -> t.getStatus() == Status.DONE)
                .toList();
    }

    public static List<Task> sortByStatusFailed(List<Task> tasks){
        return tasks.stream().filter(
                        t -> t.getStatus() == Status.FAIL)
                .toList();
    }
    
    public static List<Task> sortByStatusInProgress(List<Task> tasks){
        return tasks.stream().filter(
                        t -> t.getStatus() == Status.IN_PROGRESS)
                .toList();
    }

    public static List<Task> sortedByToDo(List<Task> tasks) {
        return tasks.stream().filter(
                        t -> t.getStatus() == Status.TODO)
                .toList();
    }
}
