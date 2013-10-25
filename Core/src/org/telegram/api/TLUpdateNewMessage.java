
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateNewMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x13abdb3;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsMessage message;

    protected int pts;


    public org.telegram.api.TLAbsMessage getMessage() {
        return message;
    }

    public void setMessage(org.telegram.api.TLAbsMessage value) {
        this.message = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.message, stream);
        writeInt(this.pts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (org.telegram.api.TLAbsMessage)readTLObject(stream, context);
        this.pts = readInt(stream);
    }

}
