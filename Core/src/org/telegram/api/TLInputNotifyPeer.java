
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputNotifyPeer extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0xb8bc5b0c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsInputPeer peer;


    public org.telegram.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsInputPeer value) {
        this.peer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsInputPeer)readTLObject(stream, context);
    }

}
