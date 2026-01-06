package ru.samura;

import java.io.IOException;

import ru.samura.classes.FileWrittingTask;
import ru.samura.classes.SleepingTask;
import ru.samura.classes.TaskManager;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TaskManager manager = new TaskManager();
        manager.addTask(new FileWrittingTask("Записать отчёт"));
        manager.addTask(new SleepingTask("Подождать немного"));
        manager.addTask(new FileWrittingTask("Сохранить результат"));

        manager.runAllTasksInParallel();

        // Сохраняем
        manager.saveToFile("manager.dat");

        // Загружаем заново
        TaskManager loaded = TaskManager.loadFromFile("manager.dat");
        System.out.println("Загружено задач: " + loaded.getTaskCount());
    }
}