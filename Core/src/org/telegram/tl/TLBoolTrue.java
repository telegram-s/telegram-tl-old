package org.telegram.tl;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 06.11.13
 * Time: 0:39
 */
public class TLBoolTrue extends TLBool {

    public static final int CLASS_ID = 0x997275b5;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "boolTrue#997275b5";
    }
}
