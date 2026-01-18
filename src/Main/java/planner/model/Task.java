package Main.java.planner.model;

import Main.java.planner.util.DateTimeUtils;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task {

    private int priority;                       //приоритет задачи, например от 1 до 10
    private String name;                        //имя поставленной задачи
    private String description;                 //описание задачи
    private LocalDateTime createdAt;            //дата создания задачи
    private LocalDateTime deadLine;             //срок исполнения задачи
    private Status status;                      //статус поставленной задачи



    public Task(int priority, String name,
                String description, LocalDateTime deadLine){
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();   //время создание указывается автоматически
        this.deadLine = deadLine;
        this.status = Status.TODO;              //значение по умолчанию
    }


    public int getPriority() {return priority;}
    public String getName() {return name;}
    public String getDescription(){return description;}
    public Status getStatus() {return status;}

    public LocalDateTime getUnFormattedCreatedAt() {return createdAt;}  //не форматированный вывод
    public LocalDateTime getUnFormattedDeadLine() {return deadLine;}    //не форматированный вывод
    public String getFormattedDeadLine() {return DateTimeUtils.format(deadLine);}   //форматированный вывод
    public String getFormattedCreatedAt() {return DateTimeUtils.format(createdAt);} //форматированный вывод

    public Duration getUnFormattedTimeLeft() {return DateTimeUtils.timeLeft(deadLine);} //не форматированный вывод оставшегося времени
    public String getFormattedTimeLeft() {return DateTimeUtils.formatDuration(DateTimeUtils.timeLeft(deadLine));}//форматированный вывод



    public void setDescription(String description){
        this.description = description;
    }
    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

@Override
    public String toString(){
        return "Task{name = %s, priority = %d, status = %s"
                .formatted(name, priority, status);
    }
}
