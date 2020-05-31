import java.io.File;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class Task6 {
    public List<String> solveTask6( List<MonitoredData> monitoredData) {
        try {
            System.setOut(new PrintStream(new File("Task_6.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        final Map<String, Long> activityMap = monitoredData.stream().collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
        final Map<String, Long> timeMap = monitoredData.stream().filter(m -> m.seconds() / 60 < 5).collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
        final List<String> activities = monitoredData.stream()
                .filter(m -> timeMap.get(m.getActivityLabel()) != null && timeMap.get(m.getActivityLabel()) >= 0.9 * activityMap.get(m.getActivityLabel()))
                .map(MonitoredData::getActivityLabel).distinct().collect(Collectors.toList());
        System.out.println("The number of activities  that have more than 90% of the monitoring records with duration  less than 5 minutes is "+activities.size());
        activities.forEach((m) -> System.out.println("Activity: " + m));
        return activities;
    }

}
