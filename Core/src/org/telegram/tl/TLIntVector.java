package org.telegram.tl;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 16:02
 */
public class TLIntVector extends TLVector<Integer> {
    public TLIntVector() {
        setDestClass(Integer.class);
    }

    @Override
    public String toString() {
        return "vector<int>#1cb5c415";
    }
}
