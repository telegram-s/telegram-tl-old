
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesAddChatUser extends TLMethod {

    public static final int CLASS_ID = 0x2ee9ee9e;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int chatId;

    protected org.telegram.api.TLAbsInputUser userId;

    protected int fwdLimit;


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

    public int getFwdLimit() {
        return fwdLimit;
    }

    public void setFwdLimit(int value) {
        this.fwdLimit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.userId, stream);
        writeInt(this.fwdLimit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = (org.telegram.api.TLAbsInputUser)readTLObject(stream, context);
        this.fwdLimit = readInt(stream);
    }

}
