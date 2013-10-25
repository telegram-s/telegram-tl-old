
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesForwardMessage extends TLMethod {

    public static final int CLASS_ID = 0x3f3f4f2;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputPeer peer;

    protected int id;

    protected long randomId;


    public org.telegram.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.id, stream);
        writeLong(this.randomId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsInputPeer)readTLObject(stream, context);
        this.id = readInt(stream);
        this.randomId = readLong(stream);
    }

}
