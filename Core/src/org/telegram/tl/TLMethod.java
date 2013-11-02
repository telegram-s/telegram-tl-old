package org.telegram.tl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 16:50
 */
public abstract class TLMethod<T extends TLObject> extends TLObject {
    public T deserializeResponse(byte[] data, TLContext context) throws IOException {
        return deserializeResponse(new ByteArrayInputStream(data),context);
    }

    public abstract T deserializeResponse(InputStream stream, TLContext context) throws IOException;
}
