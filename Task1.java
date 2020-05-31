import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task1 {
    public List<MonitoredData> solveTask1() {
        List<String> rows = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("Activities.txt"))) {
            rows = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        final List<MonitoredData> monitoredData = rows.stream().
                map(s -> s.split("\\t+")).
                map(data -> new MonitoredData(LocalDateTime.parse(data[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                        LocalDateTime.parse(data[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), data[2]))
                .collect(Collectors.toList());
        try {
            System.setOut(new PrintStream(new File("Task_1.txt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (final MonitoredData monitoredDataEntity : monitoredData) {
            System.out.println(monitoredDataEntity.getActivityLabel() +
                    " : " + monitoredDataEntity.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    " -> " + monitoredDataEntity.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        return monitoredData;

    }
}
