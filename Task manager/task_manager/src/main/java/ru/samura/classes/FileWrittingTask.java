package ru.samura.classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrittingTask extends BaseTask{

    private String fileName = "task.log";
    private String filePath = "task_manager/src/main/java/ru/samura/logs/" + fileName;
    private File file = new File(filePath);

    public FileWrittingTask(String description) {
            super(description);
            System.out.println(filePath);
        }
    
    @Override
    public void execute() {
        if(fileExists()){
            fileWrite();
        } else{
            createFile();
            fileWrite();
        }

        this.markAsCompleted();
    }


    private boolean fileExists(){
        return file.exists();
    }

    private void createFile(){
        try
        {
            boolean created = file.createNewFile();
            if(created)
                System.out.println("Файл создан");
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }  
    }

    private synchronized void fileWrite(){
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(this.getDescription() + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
