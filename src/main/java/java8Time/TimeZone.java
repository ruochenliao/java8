package java8Time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * 时区处理
 *
 */
public class TimeZone {
    @Test
    public void testZone(){
        //获取所有时区
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        allZones.forEach(System.out::println);

        LocalDateTime shangHaiNow = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("上海时间: "+shangHaiNow);

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime losAngelesNow = now.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println("洛杉矶时间: " + losAngelesNow);
    }
}
