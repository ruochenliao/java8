package stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
        list.stream()
                .map(it->it.toUpperCase())
                .forEach(System.out::println);

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
        List<String> list = Lists.newArrayList("aaa", "bbb", "ccc", "ddd");
        Stream<Character> stream = list.stream()
                //{a, a, a} U {b, b, b} U ...
                .flatMap(StreamMapOperation::filterCharacter);
        stream.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for(Character c: str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
}
