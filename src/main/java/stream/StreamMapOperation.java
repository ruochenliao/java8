package stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map: 接收 stream 将元素转成其他形式并提取
 * flapMap: 接收一个函数作为参数，将流的每个值都替换成另外一个流，然后把所有流连成一个流
 */
public class StreamMapOperation {

    /**
     * map 操作
     */
    @Test
    public void mapOperation(){
        //将六中的每个元素都映射成新的元素
        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc", "ddd");
        List<String> result2 = list.stream()
                .map(it->it.toUpperCase())
                .collect(Collectors.toList());
        //打印出 [AAA, BBB, CCC, DDD]
        System.out.println(result2);

        //把一个一个字符取出来打印
        Stream<Stream<Character>> characterStream= list.stream()
                .map(StreamMapOperation::filterCharacter);
        characterStream.forEach(it->it.forEach(System.out::println));
    }

    /**
     * flapMap
     */
    @Test
    public void flapMapOperation(){
        List<List<String>> lists = Lists.newArrayList(Lists.newArrayList("1","2","3"), Lists.newArrayList("a", "b", "c"));
        List<String> result1 = lists.stream().flatMap(list ->list.stream()).collect(Collectors.toList());
        //打印出 [1, 2, 3, a, b, c]
        System.out.println(result1);

        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc", "ddd");
        List<Character> characters = list.stream()
                .flatMap(StreamMapOperation::filterCharacter)
                .collect(Collectors.toList());
        //打印出 [a, a, a, b, b, b, c, c, c, d, d, d]
        System.out.println(characters);
    }

    /**
     * toMap 操作
     */
    @Test
    public void toMapOperation(){
        List<String> list = Lists.newArrayList("a", "b", "c");
        Map<String, String> result = list.stream().collect(Collectors.toMap(it -> it, it -> it.toUpperCase(), (a, b) -> a));
        // 打印出{a=A, b=B, c=C}
        System.out.println(result);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for(Character c: str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
}
