package java8Time;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.util.Calendar.SUNDAY;

/**
 * 时间矫正器
 */
public class DateAdjuster {

    @Test
    public void testAdjuster(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date10 = now.withDayOfMonth(10);
        //打印出 2020-06-10T01:02:22.088
        System.out.println(date10);

        //月中最后一天
        LocalDateTime lastDateOfTheMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        //打印出 2020-06-30T01:04:14.338
        System.out.println("月末最后一天" + lastDateOfTheMonth);

        //下周时间
        LocalDateTime nextWeek = now.with(TemporalAdjusters.next(DayOfWeek.of(SUNDAY)));
        System.out.println("下周时间" + nextWeek);

        //自定义
        LocalDateTime nextWorkDate = now.with(d ->{
           return LocalDateTime.now();
        });
    }

}
