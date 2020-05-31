import java.io.File;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;


public class Task4 {
    public Map<Integer, Map<String, Long>> solveTask4(List<MonitoredData> d) {
        try {
            System.setOut(new PrintStream(new File("Task_4.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<Integer, Map<String, Long>> counter = new HashMap<Integer, Map<String, Long>>();
        counter = d.stream().collect(Collectors.groupingBy(date -> date.getStartTime().getDayOfMonth(),
                Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting())));
        for (Integer i : counter.keySet()) {
            System.out.println("Day " + i + ":" + counter.get(i));
        }
        return counter;
    }

}
