package org.telegram.tl;

import org.telegram.api.TLUserContact;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 20:23
 */
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000*10; i++) {
            new TLUserContact().getClassId();
        }
        // int classId = new TLUserContact().getClassId();
        // System.out.println("User class id: " + Integer.toHexString(classId));
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
