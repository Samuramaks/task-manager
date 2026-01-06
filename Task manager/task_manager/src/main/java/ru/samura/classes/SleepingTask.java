package ru.samura.classes;

public class SleepingTask extends BaseTask{

    private int minMillis = 500;
    private int maxMillis = 3000; 

    public SleepingTask(String description) {
            super(description);
        }
    
    @Override
    public void execute() {
        int sleepMillis = (int) (Math.random() * (maxMillis - minMillis + 1) + minMillis);
        System.out.println("Сон на " + sleepMillis + " миллисекунд");

        try {
            Thread.sleep(sleepMillis);
            this.markAsCompleted(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
