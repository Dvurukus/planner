package Main.java.planner.service;

import Main.java.planner.model.Status;
import Main.java.planner.model.Task;

import java.util.ArrayList;
import java.util.List;



public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getTasks(){
        return new ArrayList<>(tasks);                      //Передаем задачи
    }

    public void addTask (Task task){                        //Добавление задачи
        tasks.add(task);
    }

    public void statusDone(Task task) {
        if (!tasks.contains(task)) return ;
        task.markDone(task);      
    }

    public void statusFail(Task task) {
        if (!tasks.contains(task)) return;
        task.markFailed(task);
    }

    public void statusInProgress(Task task) {
        if(!tasks.contains(task)) return;
        task.markStart(task);
    }
}
