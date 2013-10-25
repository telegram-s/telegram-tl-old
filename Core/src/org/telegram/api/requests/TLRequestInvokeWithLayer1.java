
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestInvokeWithLayer1 extends TLMethod {

    public static final int CLASS_ID = 0x53835315;

    public int getClassId() {
        return CLASS_ID;
    }




    protected TLMethod query;


    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.query = readTLMethod(stream, context);
    }

}
