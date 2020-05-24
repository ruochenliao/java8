package java8Time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class SolveJava8ThreadSecurityProblem {

    /**
     * 使用 java 8 DateTimeFormatter
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //java 8 使用 DateTimeFormmatter 来做时间格式转换
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        //java 8 使用 LocalDate 代理原来的 Date
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20161218", dtf);
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> result = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            result.add(pool.submit(task));
        }

        for(Future<LocalDate> future:result){
            System.out.println(future.get());
        }
    }
}
