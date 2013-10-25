
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLEncryptedMessage extends TLAbsEncryptedMessage {
    public static final int CLASS_ID = 0xed18c118;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsEncryptedFile file;


    public org.telegram.api.TLAbsEncryptedFile getFile() {
        return file;
    }

    public void setFile(org.telegram.api.TLAbsEncryptedFile value) {
        this.file = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.randomId, stream);
        writeInt(this.chatId, stream);
        writeInt(this.date, stream);
        writeTLBytes(this.bytes, stream);
        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.randomId = readLong(stream);
        this.chatId = readInt(stream);
        this.date = readInt(stream);
        this.bytes = readTLBytes(stream);
        this.file = (org.telegram.api.TLAbsEncryptedFile)readTLObject(stream, context);
    }

}
