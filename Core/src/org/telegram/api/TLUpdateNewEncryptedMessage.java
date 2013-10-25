
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateNewEncryptedMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x12bcbd9a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsEncryptedMessage message;

    protected int qts;


    public org.telegram.api.TLAbsEncryptedMessage getMessage() {
        return message;
    }

    public void setMessage(org.telegram.api.TLAbsEncryptedMessage value) {
        this.message = value;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int value) {
        this.qts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.message, stream);
        writeInt(this.qts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (org.telegram.api.TLAbsEncryptedMessage)readTLObject(stream, context);
        this.qts = readInt(stream);
    }

}
