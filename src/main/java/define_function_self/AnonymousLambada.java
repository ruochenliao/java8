package define_function_self;

import java.util.Comparator;
import java.util.TreeSet;

public class AnonymousLambada {
    /**
     * 原始的 comparator
     * @return
     */
    TreeSet<Integer> originalComparator(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        return new TreeSet<>(comparator);
    }

    /**
     * 使用 lambda 的 comparator
     * @return
     */
    TreeSet<Integer> lambadaComparator(){
        Comparator<Integer> comparator = (x, y) -> y - x;
        return new TreeSet<>(comparator);
    }


}
