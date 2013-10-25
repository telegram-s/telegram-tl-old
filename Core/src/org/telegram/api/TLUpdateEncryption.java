
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateEncryption extends TLAbsUpdate {
    public static final int CLASS_ID = 0xb4a2e88d;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsEncryptedChat chat;

    protected int date;


    public org.telegram.api.TLAbsEncryptedChat getChat() {
        return chat;
    }

    public void setChat(org.telegram.api.TLAbsEncryptedChat value) {
        this.chat = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.chat, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chat = (org.telegram.api.TLAbsEncryptedChat)readTLObject(stream, context);
        this.date = readInt(stream);
    }

}
