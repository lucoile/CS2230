package queries;

import iterators.Apply;
import iterators.ApplyFunction;
import iterators.Filter;
import iterators.FlatApply;
import iterators.FlatApplyFunction;
import iterators.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import readers.TextFileReader;

// return all filenames that contain the word "Mars" 
public class TextQuery3 {

    public static void main(String[] args) {
        Iterator<Pair<String, String>> filenameAndContents = new TextFileReader("../sci.space");
        Iterator<String> contents = new Apply(new TakeRight<>(), filenameAndContents);
        Iterator<String> words = new FlatApply<>(new SplitBy("[ .!,:<>@=*_()/\\t~#\"|-]"), contents);
        Iterator<String> marsFilter = new NewFilter<>(new Pred("Mars"), filenameAndContents);

        /* finish the query using a combination of Applys and Filters */
        while (marsFilter.hasNext()) {
            System.out.println(marsFilter.next());
        }
    }

    // put your classes that implement ApplyFunction and Predicate here
    public static class Pred implements Predicate<String> {

        private String checkFor;
        SplitBy split = new SplitBy("[ .!,:<>@=*_()/\\t~#\"|-]");

        private Pred(String checkFor) {
            this.checkFor = checkFor;
        }

        public boolean check(String s) {
            List<String> words = split.apply(s);
            for (String w : words) {
                if (s.equals(checkFor)) {
                    return true;
                }
            }
            return false;
        }
    }

    //Iterator that uses a Predicate to filter out elements from the input
    public class NewFilter<L, R> implements Iterator<L> {

        private final FilterFunction<L, R> f;
        private final Iterator<Pair<L, R>> input;
        private LinkedList<L> q;

        public NewFilter(FilterFunction<L, R> f, Iterator<Pair<L, R>> input) {
            this.f = f;
            this.input = input;
            q = new LinkedList<L>();
        }

        public boolean hasNext() {
            if (!q.isEmpty() && input.hasNext()) {
                return true;
            } else {
                while (q.isEmpty() && input.hasNext()) {
                    List<L> temp = f.apply(input.next());
                    if (temp != null) {
                        for (L ele : temp) {
                            q.add(ele);
                        }
                    }
                }
            }
            return !q.isEmpty();
        }

        public L next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            return q.remove(0);
        }

        // uses a Predicate to decide whether the input element is output or not
        private abstract class FilterFunction<L, R> implements FlatApplyFunction<L, R> {

            private Predicate<R> p;

            public FilterFunction(Predicate<R> p) {
                this.p = p;
            }

            public List<L> apply(Pair<L, R> x) {
                List<L> out = new ArrayList<>();
                if (p.check(x.right)) {
                    out.add(x.left);
                }
                return out;
            }
        }

    }

    public static class SplitBy implements FlatApplyFunction<String, String> {

        private String ch;

        public SplitBy(String c) {
            this.ch = c;
        }

        @Override
        public List<String> apply(String x) {
            return Arrays.asList(x.split(ch));
        }
    }

    public static class TakeRight<L, R> implements ApplyFunction<Pair<L, R>, R> {

        @Override
        public R apply(Pair<L, R> x) {
            return x.right;
        }
    }
}
