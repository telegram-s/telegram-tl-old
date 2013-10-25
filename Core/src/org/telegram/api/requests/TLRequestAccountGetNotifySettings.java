
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestAccountGetNotifySettings extends TLMethod {

    public static final int CLASS_ID = 0x12b3ad31;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputNotifyPeer peer;


    public org.telegram.api.TLAbsInputNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsInputNotifyPeer value) {
        this.peer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsInputNotifyPeer)readTLObject(stream, context);
    }

}
