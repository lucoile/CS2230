package iterators;

import java.util.*;

// Iterator that uses a Predicate to filter out elements from the input
public class Filter<T> extends FlatApply<T, T> {

    public Filter(Predicate<T> p, Iterator<T> input) {
        // you DO NOT need to modify the constructor
        super(new FilteringFlatApplyFunction<>(p), input);
    }

    // uses a Predicate to decide whether the input element is output or not
    private static class FilteringFlatApplyFunction<T> implements FlatApplyFunction<T, T> {

        private Predicate<T> p;

        public FilteringFlatApplyFunction(Predicate<T> p) {
            this.p = p;
        }

        @Override
        public List<T> apply(T x) {
            List<T> out = new ArrayList<T>();
            if (p.check(x)) {
                out.add(x);
            }
            return out;
        }
    }

}