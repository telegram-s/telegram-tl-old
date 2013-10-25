
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLEncryptedMessageService extends TLAbsEncryptedMessage {
    public static final int CLASS_ID = 0x23734b06;

    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.randomId, stream);
        writeInt(this.chatId, stream);
        writeInt(this.date, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.randomId = readLong(stream);
        this.chatId = readInt(stream);
        this.date = readInt(stream);
        this.bytes = readTLBytes(stream);
    }

}
