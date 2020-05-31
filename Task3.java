import java.io.File;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;


public class Task3 {
    public Map<String, Integer> solveTask3(List<MonitoredData> monitoredData) {
        try {
            System.setOut(new PrintStream(new File("Task_3.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        final Map<String, Integer> activityFrequency = monitoredData.stream().collect(Collectors.toMap(MonitoredData::getActivityLabel, m -> 1, Integer::sum));
        for (String activity : activityFrequency.keySet()) {
            System.out.println(activity + " has appeared " + activityFrequency.get(activity) + " times.");
        }
        return activityFrequency;
    }

}
