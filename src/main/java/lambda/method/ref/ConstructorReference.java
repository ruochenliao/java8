package lambda.method.ref;

import lambda.Form;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 * ClassName::new
 *
 * 注意
 * 需要调用的构造器的参数列表要和函数式接口中抽象方法的列表保持一致
 */
public class ConstructorReference {
    /**
     *
     */
    @Test
    public void constructObj(){
        Supplier<Object> supplier0 = () -> new Form();
        Supplier<Object> supplier1 = Form::new;

        supplier0.get();
        supplier1.get();

        System.out.println(supplier0);
        System.out.println(supplier1);
    }

    @Test
    public void constructFunctionObj(){
        Function<String, Form> function0 = (x) -> new Form(x);
        Function<String, Form> function1 = Form::new;

        Form form = function0.apply("RECEIVE");
        Form form1 = function1.apply("RECEIVE");
        System.out.println(form);
        System.out.println(form1);

        BiFunction<Long, String, Form> biFunction0 = (x,y) -> new Form(1L, "RECEIVE");
        BiFunction<Long, String, Form> biFunction1= Form::new;
        System.out.println(biFunction0);
        System.out.println(biFunction1);
    }
}
