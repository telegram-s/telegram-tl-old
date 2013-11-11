package org.telegram.tl;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 06.11.13
 * Time: 0:40
 */
public class TLBoolFalse extends TLBool {

    public static final int CLASS_ID = 0xbc799737;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "boolFalse#bc799737";
    }
}
