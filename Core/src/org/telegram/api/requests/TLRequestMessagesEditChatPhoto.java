
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesEditChatPhoto extends TLMethod {

    public static final int CLASS_ID = 0xd881821d;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int chatId;

    protected org.telegram.api.TLAbsInputChatPhoto photo;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public org.telegram.api.TLAbsInputChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsInputChatPhoto value) {
        this.photo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.photo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.photo = (org.telegram.api.TLAbsInputChatPhoto)readTLObject(stream, context);
    }

}
