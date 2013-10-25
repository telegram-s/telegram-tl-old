
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateReadMessages extends TLAbsUpdate {
    public static final int CLASS_ID = 0xc6649e31;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLIntVector messages;

    protected int pts;


    public org.telegram.tl.TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(org.telegram.tl.TLIntVector value) {
        this.messages = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.messages, stream);
        writeInt(this.pts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.messages = readTLIntVector(stream);
        this.pts = readInt(stream);
    }

}
