
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesDeleteChatUser extends TLMethod {

    public static final int CLASS_ID = 0xc3c5cd23;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int chatId;

    protected org.telegram.api.TLAbsInputUser userId;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public org.telegram.api.TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(org.telegram.api.TLAbsInputUser value) {
        this.userId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.userId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = (org.telegram.api.TLAbsInputUser)readTLObject(stream, context);
    }

}
