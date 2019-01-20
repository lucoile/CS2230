package iterators;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Iterator that returns a single element that is the result of
// combining all the input elements
public class Reduce<InT, OutT> implements Iterator<OutT> {

    private final ReduceFunction<InT, OutT> f;
    private final Iterator<InT> input;
    private OutT soFar;
    private int iters;

    public Reduce(ReduceFunction<InT, OutT> f, Iterator<InT> input) {
        this.f = f;
        this.input = input;
        soFar = f.initialValue();
        iters = 0;
    }

    @Override
    public boolean hasNext() {
        if (iters == 0) return true;
        return false;
    }

    @Override
    public OutT next() {
        while (input.hasNext()) {
            soFar = f.combine(soFar, input.next());
        }
        iters += 1;
        return soFar;
    }
}
