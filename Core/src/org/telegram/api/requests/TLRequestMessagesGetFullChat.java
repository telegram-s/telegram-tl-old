
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesGetFullChat extends TLMethod {

    public static final int CLASS_ID = 0x3b831c66;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int chatId;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
    }

}
