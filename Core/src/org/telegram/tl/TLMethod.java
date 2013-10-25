package org.telegram.tl;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 16:50
 */
public abstract class TLMethod extends TLObject {
    public TLObject parseResponse(InputStream stream, TLContext context) {
        return null;
    }
}
