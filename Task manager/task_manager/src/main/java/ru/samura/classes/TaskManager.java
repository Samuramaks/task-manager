package ru.samura.classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.samura.interfaces.Task;

public class TaskManager implements Serializable{
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void runAllTasksInParallel(){
        List<Thread> threads = new ArrayList<>();
        for(Task task : tasks){
            Thread thread = new Thread(()->{
                task.execute();
            });

            thread.start();
            threads.add(thread);



            for(Thread thr: threads){
                try {
                    thr.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            System.out.println("Все задачи завершены.");
            
        }
    } 



    public void saveToFile(String filename) throws IOException{
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

            oos.writeObject(this);

            oos.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        

        
    }

    public int getTaskCount(){
        return tasks.size();
    }


   public static TaskManager loadFromFile(String filename) throws IOException, ClassNotFoundException {
        TaskManager manager = null;    
        
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            manager = (TaskManager) ois.readObject();
            ois.close();
            fis.close();

        } catch (Exception e) {
        System.out.println(e.getMessage());
        }

        return manager;
    }
}
