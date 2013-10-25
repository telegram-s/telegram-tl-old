
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesForwardMessages extends TLMethod {

    public static final int CLASS_ID = 0x514cd10f;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputPeer peer;

    protected org.telegram.tl.TLIntVector id;


    public org.telegram.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public org.telegram.tl.TLIntVector getId() {
        return id;
    }

    public void setId(org.telegram.tl.TLIntVector value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsInputPeer)readTLObject(stream, context);
        this.id = readTLIntVector(stream);
    }

}
