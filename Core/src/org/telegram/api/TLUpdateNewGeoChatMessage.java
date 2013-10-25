
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateNewGeoChatMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x5a68e3f7;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsGeoChatMessage message;


    public org.telegram.api.TLAbsGeoChatMessage getMessage() {
        return message;
    }

    public void setMessage(org.telegram.api.TLAbsGeoChatMessage value) {
        this.message = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.message, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (org.telegram.api.TLAbsGeoChatMessage)readTLObject(stream, context);
    }

}
