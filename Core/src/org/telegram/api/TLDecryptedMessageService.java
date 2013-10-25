
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLDecryptedMessageService extends TLAbsDecryptedMessage {
    public static final int CLASS_ID = 0xaa48327d;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLDecryptedMessageAction action;


    public org.telegram.api.TLDecryptedMessageAction getAction() {
        return action;
    }

    public void setAction(org.telegram.api.TLDecryptedMessageAction value) {
        this.action = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.randomId, stream);
        writeTLBytes(this.randomBytes, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.randomId = readLong(stream);
        this.randomBytes = readTLBytes(stream);
        this.action = (org.telegram.api.TLDecryptedMessageAction)readTLObject(stream, context);
    }

}
