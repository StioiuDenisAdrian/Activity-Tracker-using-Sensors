import java.io.File;
import java.io.PrintStream;
import java.util.*;


public class Task2 {
    public int solveTask2(List<MonitoredData> monitoredData) {
        try {
            System.setOut(new PrintStream(new File("Task_2.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int differentDays = (int) monitoredData.stream().map(data -> data.getStartTime().getDayOfYear()).distinct().count();
        System.out.println("Distinct days: " + differentDays);
        return differentDays;
    }

}
