package ru.samura.classes;

import java.io.Serializable;

import ru.samura.interfaces.Task;

public abstract class BaseTask implements Task, Serializable{
    private String description;
    private volatile boolean completed;

    public BaseTask(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean isCompleted(){
        return this.completed;
    }

    protected void markAsCompleted() {
        this.completed = true;
    }

}
