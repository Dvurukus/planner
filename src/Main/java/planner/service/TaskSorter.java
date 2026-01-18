package Main.java.planner.service;

import Main.java.planner.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskSorter {

    public static List<Task> sortByPriority(List<Task> tasks){                     //Сортировка по приоритету
        List<Task> sorted = new ArrayList<>();
        List<Task> copy = new ArrayList<>(tasks);

        while (!copy.isEmpty()) {
            Task maxPriority = copy.get(0);
            for (Task task : copy) {
                if (task.getPriority() > maxPriority.getPriority()) {
                    maxPriority = task;
                }
            }
            sorted.add(maxPriority);
            copy.remove(maxPriority);
        }
        return sorted;
    }

    public static List<Task> sortByTimeRemaining(List<Task> tasks){                //Сортировка по оставшемуся времени
        List<Task> sorted = new ArrayList<>();
        List<Task> copy = new ArrayList<>(tasks);

        while (!copy.isEmpty()) {
            Task expires = copy.get(0);

            for (Task task : copy) {
                if (task.getUnFormattedDeadLine().isBefore(expires.getUnFormattedDeadLine())){
                    expires = task;
                }
            }
            sorted.add(expires);
            copy.remove(expires);
        }
        return sorted;
    }
}
