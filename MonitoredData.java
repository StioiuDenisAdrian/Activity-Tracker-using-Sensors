import java.time.Duration;
import java.time.LocalDateTime;

public class MonitoredData {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String activityLabel;

    public MonitoredData(LocalDateTime startTime, LocalDateTime endTime, String activityLabel) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityLabel = activityLabel;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel;
    }

    public long  seconds(){
        return Duration.between(getStartTime(),getEndTime()).getSeconds();
    }

    public Duration timePassed() {

        Duration timeOfActivity=Duration.between(startTime, endTime);
        return timeOfActivity;

    }

}
