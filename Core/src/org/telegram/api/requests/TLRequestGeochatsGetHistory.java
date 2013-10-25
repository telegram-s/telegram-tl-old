
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsGetHistory extends TLMethod {

    public static final int CLASS_ID = 0xb53f7a68;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputGeoChat peer;

    protected int offset;

    protected int maxId;

    protected int limit;


    public org.telegram.api.TLInputGeoChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputGeoChat value) {
        this.peer = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.offset, stream);
        writeInt(this.maxId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputGeoChat)readTLObject(stream, context);
        this.offset = readInt(stream);
        this.maxId = readInt(stream);
        this.limit = readInt(stream);
    }

}
