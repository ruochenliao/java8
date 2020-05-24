package java8Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class SolveJava7ThreadSecurityProblem {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date convertDateFormat(String source) throws ParseException {
        return df.get().parse(source);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return SolveJava7ThreadSecurityProblem.convertDateFormat("20161218");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> result = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            result.add(pool.submit(task));
        }

        for(Future<Date> future:result){
            System.out.println(future.get());
        }

        pool.shutdown();
    }

}
