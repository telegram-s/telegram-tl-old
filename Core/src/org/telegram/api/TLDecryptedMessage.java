
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLDecryptedMessage extends TLAbsDecryptedMessage {
    public static final int CLASS_ID = 0x1f814f1f;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String message;

    protected org.telegram.api.TLAbsDecryptedMessageMedia media;


    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public org.telegram.api.TLAbsDecryptedMessageMedia getMedia() {
        return media;
    }

    public void setMedia(org.telegram.api.TLAbsDecryptedMessageMedia value) {
        this.media = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.randomId, stream);
        writeTLBytes(this.randomBytes, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.randomId = readLong(stream);
        this.randomBytes = readTLBytes(stream);
        this.message = readTLString(stream);
        this.media = (org.telegram.api.TLAbsDecryptedMessageMedia)readTLObject(stream, context);
    }

}
