
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessagesSentEncryptedFile extends TLAbsSentEncryptedMessage {
    public static final int CLASS_ID = 0x9493ff32;

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

        writeInt(this.date, stream);
        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.file = (org.telegram.api.TLAbsEncryptedFile)readTLObject(stream, context);
    }

}
