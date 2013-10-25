
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLDecryptedMessageActionSetMessageTTL extends TLDecryptedMessageAction {
    public static final int CLASS_ID = 0xa1733aec;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int ttlSeconds;


    public int getTtlSeconds() {
        return ttlSeconds;
    }

    public void setTtlSeconds(int value) {
        this.ttlSeconds = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.ttlSeconds, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.ttlSeconds = readInt(stream);
    }

}
