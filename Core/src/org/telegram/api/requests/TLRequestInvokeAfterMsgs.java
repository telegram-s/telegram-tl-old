
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestInvokeAfterMsgs extends TLMethod {

    public static final int CLASS_ID = 0x3dc4b4f0;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.tl.TLLongVector msgIds;

    protected TLMethod query;


    public org.telegram.tl.TLLongVector getMsgIds() {
        return msgIds;
    }

    public void setMsgIds(org.telegram.tl.TLLongVector value) {
        this.msgIds = value;
    }

    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.msgIds, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.msgIds = readTLLongVector(stream);
        this.query = readTLMethod(stream, context);
    }

}
