
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputNotifyGeoChatPeer extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0x4d8ddec8;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLInputGeoChat peer;


    public org.telegram.api.TLInputGeoChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputGeoChat value) {
        this.peer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputGeoChat)readTLObject(stream, context);
    }

}
