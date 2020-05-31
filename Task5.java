import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class Task5 {
    public Map<Object, List<Long>> solveTask5(List<MonitoredData> d) {
        try {
            System.setOut(new PrintStream(new File("Task_5.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        final Map<Object, List<Long>> duration = d.stream().
                collect((Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.mapping(MonitoredData::seconds, Collectors.toList()))));
        duration.forEach((m, t) -> {
            long time = t.stream().mapToLong(Long::longValue).sum();
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println("Activity: " + m + " duration: " + simpleDateFormat.format(new Date(time * 1000L)));
        });
        return duration;

    }
}
