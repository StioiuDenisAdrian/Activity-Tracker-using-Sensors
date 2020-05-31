import javafx.concurrent.Task;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task1 t1=new Task1();
        List<MonitoredData> md= t1.solveTask1();
        Task2 t2=new Task2();
        t2.solveTask2(md);
        Task3 t3=new Task3();
        t3.solveTask3(md);
        Task4 t4=new Task4();
        t4.solveTask4(md);
        Task5 t5 =new Task5();
        t5.solveTask5(md);
        Task6 t6=new Task6();
        t6.solveTask6(md);

    }
}
