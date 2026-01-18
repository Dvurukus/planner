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
        task.setStatus(Status.DONE);
    }

    public void statusFail(Task task) {
        task.setStatus(Status.FAIL);
    }

    public void statusInProgress(Task task) {
        task.setStatus(Status.IN_PROGRESS);
    }
}
