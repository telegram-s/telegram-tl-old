package org.telegram.tl;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 16:02
 */
public class TLLongVector extends TLVector<Long> {
    public TLLongVector() {
        setDestClass(Long.class);
    }

    @Override
    public String toString() {
        return "vector<long>#1cb5c415";
    }
}
