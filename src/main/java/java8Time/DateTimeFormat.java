package java8Time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间格式化
 *
 * DateTimeFormatter
 */
public class DateTimeFormat {
    @Test
    public void testDateTimeFormater(){
        //使用自带的格式标准
        DateTimeFormatter formatDateTime = DateTimeFormatter.ISO_DATE_TIME ;
        DateTimeFormatter formatDate = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        String dateTimeNow = now.format(formatDateTime);
        String dateNow = now.format(formatDate);
        //2020-06-01T01:16:15.947
        System.out.println("当前日期时间:" + dateTimeNow);
        //2020-06-01
        System.out.println("当前日期:" + dateNow);

        //使用自定义的格式标准
        DateTimeFormatter selfDefinedFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String selfDefinedDate = now.format(selfDefinedFormatter);
        //打印 2020年06月01日 01:18:59
        System.out.println(selfDefinedDate);

        //从员工可读转换回系统时间
        LocalDateTime localDateTime = LocalDateTime.parse(selfDefinedDate, selfDefinedFormatter);
        //打印出 2020-06-01T01:22:24
        System.out.println("回转: "+ localDateTime);

    }
}
