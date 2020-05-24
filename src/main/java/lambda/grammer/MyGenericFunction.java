package lambda.grammer;

@FunctionalInterface
public interface MyGenericFunction<T, R> {
    R calculate(T t1, T t2);
}
