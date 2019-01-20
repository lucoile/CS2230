package iterators;

import java.util.*;

// Iterator that may produce 0 or more output elements for every input element
public class FlatApply<InT, OutT> implements Iterator<OutT> {

    private final FlatApplyFunction<InT, OutT> f;
    private final Iterator<InT> input;
    private LinkedList<OutT> q;

    public FlatApply(FlatApplyFunction<InT, OutT> f, Iterator<InT> input) {
        this.f = f;
        this.input = input;
        q = new LinkedList<OutT>();
    }

    @Override
    public boolean hasNext() {
        if (!q.isEmpty() && input.hasNext()) {
            return true;
        } else {
            while (q.isEmpty() && input.hasNext()) {
                List<OutT> temp = f.apply(input.next());
                if (temp != null) {
                    for (OutT ele : temp) {
                        q.add(ele);
                    }
                }
            }
        }
        return !q.isEmpty();
    }

    @Override
    public OutT next() {
        if (!hasNext()) {
            throw new IllegalStateException();
        }
        return q.remove(0);
    }

    // feel free to create private methods if helpful
}
