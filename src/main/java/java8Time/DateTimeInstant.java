package java8Time;

import org.junit.Test;

import java.time.*;

/**
 * java 8 采用
 *
 * 1 LocalDate, LocalTime 和 LocalDateTime 表示人可读时间
 * LocalDate 表示日期
 * LocalTime 表示时间
 * LocalDateTime 时间和日期
 *
 * 2 Instant 时间戳表示计算机时间
 * 以 unix 元年 1970 年 1 月 1 日 00:00:00 到某个时间的毫秒值
 *
 * 3 时间间隔
 * 时间间隔计算: Duration
 * 日期间隔计算: Period
 */
public class DateTimeInstant {
    @Test
    public void testLocalDateTime(){
        //输出 ISO 标准输出当前时间 2020-06-01T00:24:27.167
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前时间"+ldt);

        //年月日，时分秒
        LocalDateTime historyTime = LocalDateTime.of(2015, 10, 19,13,12,33);
        System.out.println(historyTime);

        //时间计算
        LocalDateTime twoYearsLater = ldt.plusYears(2);
        System.out.println("两年以后"+ twoYearsLater);
        LocalDateTime twoMonthAgo = ldt.minusMonths(2);
        System.out.println("两个月之前" + twoMonthAgo);

        //时间获取
        System.out.println("当前月" + ldt.getMonthValue());
        System.out.println("当前年" + ldt.getYear());
        System.out.println("当前日" + ldt.getDayOfMonth());
    }

    @Test
    public void testInstant(){
        //默认以 UTC 时区为基础 (格林威治时间, 和中国有 8 个小时时差)
        Instant now = Instant.now();
        //打印出 2020-05-31T16:37:10.655Z
        System.out.println("格林威治时间: "+ now);

        //时区计算
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        //打印出带时间偏移量的时间 2020-06-01T00:42:03.532+08:00
        System.out.println(offsetDateTime);

        //转成毫秒
        System.out.println(now.toEpochMilli());

        //在时间戳基础上增加 1000 s
        Instant instant = Instant.ofEpochSecond(60);
        //打印出 1970-01-01T00:01:00Z
        System.out.println(instant);
    }

    @Test
    public void testDurationAnd() throws InterruptedException {
        //计算机时间戳计算 Duration
        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println("间隔秒: "+ duration.getSeconds());
        System.out.println("间隔分: "+ duration.toMinutes());

        System.out.println("------------------");
        //可读时间计算 Duration
        LocalTime localTime1 = LocalTime.now();
        Thread.sleep(1000);
        LocalTime localTime2  = LocalTime.now();
        Duration duration1 = Duration.between(localTime1, localTime2);
        System.out.println(duration1.toMillis());
    }

    @Test
    public void testPeriod(){
        LocalDate ld1 = LocalDate.of(2015, 12, 13);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println("相差年: "+period.getYears());
        System.out.println("相差月: " + period.getMonths());
        System.out.println("相差日" + period.getDays());
    }
}
