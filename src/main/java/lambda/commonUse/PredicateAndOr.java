package lambda.commonUse;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;


/**
 * 谓语词汇中包含三个方法：negate(非), and, or
 * 可以用用 Predicate 来创建更多复杂的谓语词
 *
 *
 */
public class PredicateAndOr {

    @Test
    public void testPredicate() {
        Predicate<Apple> redApple = (apple)-> "red".equals(apple.getColor());
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redOrGreenAndHeavyApple = redApple
                .and(a->a.getWight() > 150)
                .or(a->"green".equals(a.getColor()));

        Apple apple = Apple.builder().wight(160).color("green").build();
        boolean isRedOrGreenAndHeavyApple = redOrGreenAndHeavyApple.test(apple);
        Assert.assertTrue(isRedOrGreenAndHeavyApple);
        Assert.assertTrue(notRedApple.test(apple));
    }

    @Data
    @Builder
    public static class Apple{
        private int wight ;
        private String color;
    }

}

