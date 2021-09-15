package stream;

import anonymous.Employee;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static anonymous.Employee.Status.BUSY;
import static anonymous.Employee.Status.FREE;
import static anonymous.Employee.Status.VACATION;

/**
 * stream 的终止操作
 */
public class StreamFinalOperation {

    List<Employee> employeeList = Lists.newArrayList(
                Employee.builder().name("王五").age(30).salary(100.0).status(FREE).build(),
                Employee.builder().name("张三").age(20).salary(1000.0).status(FREE).build(),
                Employee.builder().name("李四").age(30).salary(10000.0).status(BUSY).build(),
                Employee.builder().name("晨哥").age(40).salary(1000000.0).status(BUSY).build(),
                Employee.builder().name("晨哥").age(40).salary(1000000.0).status(VACATION).build()
    );

    /**
     * 查找与匹配
     * allMatch 检查是否匹配所有元素
     * anyMatch 检查是否至少有一个元素匹配
     * noneMatch 检查是否没有匹配所有元素
     * findFirst 返回第一个元素
     * findAny 返回当前流中任意元素
     */
    @Test
    public void searchOperation(){
        //allMatch 检查是否匹配所有元素
        Boolean isMatchAll = employeeList.stream()
                .allMatch((e) -> e.getStatus().equals(BUSY));

        //anyMatch 检查是否至少有一个元素匹配
        Boolean isMatchAny = employeeList.stream()
                .anyMatch((e) -> e.getStatus().equals(BUSY));

        //noneMatch 检查是不存在某元素
        Boolean isMatchNone = employeeList.stream()
                .anyMatch((e) -> e.getStatus().equals(BUSY));

        //findFirst 返回第一个元素 optional
        Optional<Employee> fistOptional = employeeList.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .findFirst();
        //如果 optional 中的值是空的，就可以有一个替代的对象
        Employee highestSalaryEmployee = fistOptional.orElse(null);

        Optional<Employee> anyOptional = employeeList.stream()
                .filter((e) -> e.getStatus().equals(FREE))
                .findAny();
        Employee freeEmployee = anyOptional.orElse(null);


        System.out.println("isMatchAll: " + isMatchAll);
        System.out.println("isMatchAny: " + isMatchAny);
        System.out.println("isMatchNone: " + isMatchNone);
        System.out.println("findFirst: " + highestSalaryEmployee);
        System.out.println("findAny: " + freeEmployee);
    }

    /**
     * 统计操作
     *
     * count 返回流中元素的个数
     * max 返回流中的最大值
     * min 返回六中最小值
     */
    @Test
    public void staticOperation(){
        //count
        long count = employeeList.stream()
                .count();
        //max
        Optional<Employee> highestSalaryEmployee = employeeList.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        //min
        Optional<Double> minSalary = employeeList.stream()
                .map(Employee::getSalary)
                .min(Double::compare);

        System.out.println("count: " + count);
        System.out.println("max: " + highestSalaryEmployee.orElse(null));
        System.out.println("min: " + minSalary);
    }

    /**
     * 归并操作 reduce
     */
    @Test
    public void reduceOperation(){
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        Integer sum = list.stream()
                //0 是个起始值
                .reduce(0, (x, y) -> x + y);

        //map reduce 大数据搜索
        Optional<Double> optionalSum = employeeList.stream()
                .map(Employee::getSalary)
                .reduce((x, y)->x + y);
        Double sumSalary= optionalSum.orElse(null);

        System.out.println("sum " + sum);
        System.out.println("sumSalary " + sumSalary);
    }

    /**
     * 判断是否为空
     */
    @Test
    public void testEmpty(){
        List<String> list = Lists.newArrayList("a", null, "b");
        List<String> result = new ArrayList<>();
        list.forEach(it->{
            Optional.ofNullable(it).ifPresent(result::add);
        });
        //打印出 [a, b]
        System.out.println(result);

        //打印出 [a, b]
        List<String> emptyList = Lists.newArrayList();
        Optional.of(emptyList).ifPresent(result::addAll);
        System.out.println(result);

        String nullVal = null;
        //会抛 NPE 异常
        Optional.of(nullVal);
        System.out.println(result);
    }

    /**
     * 收集操作 Collectors
     */
    @Test
    public void collect(){
        //list
        List<String> list = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        //set
        Set<String> set = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        //收集总数 Collectors.counting
        long count = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.counting());
        System.out.println("count " + count);

        //平均值 Collectors.averagingDouble
        double averageSalary = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("average " + averageSalary);

        //总和 Collectors.summingDouble
        double sumSalary = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("sum " + sumSalary);

        //最大值
        Optional<Employee> maxOptional = employeeList.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())));
        System.out.println("max" + maxOptional.get());

        //最小值
        Optional<Employee> minOptional = employeeList.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary())));
        System.out.println("min" + minOptional.get());
    }

    /**
     * 分组 Collectors.groupingBy()
     */
    @Test
    public void divideGroup(){
        //单级分组
        Map<Employee.Status, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("单级分组: " + map);

        //多级分组
        Map<Employee.Status, Map<String,List<Employee>>> map1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) ->{
                    if(((Employee)e).getAge()<=35){
                        return "青年";
                    }else if(((Employee)e).getAge()<=50){
                        return "中年";
                    }else{
                        return "老年";
                    }
                })));
        /*
        {
            VACATION = {
                中年 = [Employee(name = 晨哥, age = 40, salary = 1000000.0, status = VACATION)]
            }, BUSY = {
                青年 = [Employee(name = 李四, age = 30, salary = 10000.0, status = BUSY)],
                中年 = [Employee(name = 晨哥, age = 40, salary = 1000000.0, status = BUSY)]
            }, FREE = {
                青年 = [Employee(name = 王五, age = 30, salary = 100.0, status = FREE), Employee(name = 张三, age = 20, salary = 1000.0, status = FREE)]
            }
        }
        */
        System.out.println("多级分组: " + map1);
    }

    /**
     * 分区 Collectors.partitioningBy()
     * 之分两个区
     * 满足条件的一个区，不满足条件的一个区
     */
    @Test
    public void partition(){
        Map<Boolean, List<Employee>> map = employeeList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getStatus().equals(BUSY)));
        System.out.println(map);
    }

    /**
     * 统计 Collectors.summarizingDouble
     */
    public void statisticSummary(){
        DoubleSummaryStatistics dds = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dds.getMax());
        System.out.println(dds.getAverage());
        System.out.println(dds.getCount());
    }

    /**
     * join Collectors.joining()
     *
     */
    public void join(){
        //对结果连接字符串
        String allName = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(allName);
    }
}
