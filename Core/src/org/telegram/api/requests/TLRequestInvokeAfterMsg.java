
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestInvokeAfterMsg extends TLMethod {

    public static final int CLASS_ID = 0xcb9f372d;

    public int getClassId() {
        return CLASS_ID;
    }




    protected long msgId;

    protected TLMethod query;


    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long value) {
        this.msgId = value;
    }

    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.msgId, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.msgId = readLong(stream);
        this.query = readTLMethod(stream, context);
    }

}
