
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesReadHistory extends TLMethod {

    public static final int CLASS_ID = 0xb04f2510;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputPeer peer;

    protected int maxId;

    protected int offset;


    public org.telegram.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.maxId, stream);
        writeInt(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsInputPeer)readTLObject(stream, context);
        this.maxId = readInt(stream);
        this.offset = readInt(stream);
    }

}
