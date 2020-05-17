package anonymous;

@FunctionalInterface
public interface MyStrategy<T> {
    boolean test(T t);
}
