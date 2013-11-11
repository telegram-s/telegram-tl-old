package org.telegram.tl;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 06.11.13
 * Time: 0:46
 */
public class TLStringVector extends TLVector<String> {
    public TLStringVector() {
        setDestClass(String.class);
    }

    @Override
    public String toString() {
        return "vector<string>#1cb5c415";
    }
}
