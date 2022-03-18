package define_function_self;

/**
 * 自定义函数编程
 * 参考
 * @FunctionalInterface
 * public interface Runnable {
 *     public abstract void run();
 * }
 *
 * @FunctionalInterface
 * public interface Comparator<T> {
 *      int compare(T o1, T o2);
 * }
 *
 * @FunctionalInterface
 * public interface Function<T, R> {
 *      R apply(T t);
 * }
 *
 * @param <T>
 */
@FunctionalInterface
public interface MyStrategy<T> {
    boolean test(T t);
}
