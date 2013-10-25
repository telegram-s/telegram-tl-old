
package org.telegram.api.messages;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLChat extends TLObject {

    public static final int CLASS_ID = 0x40e9002a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsChat chat;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;


    public org.telegram.api.TLAbsChat getChat() {
        return chat;
    }

    public void setChat(org.telegram.api.TLAbsChat value) {
        this.chat = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.chat, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chat = (org.telegram.api.TLAbsChat)readTLObject(stream, context);
        this.users = readTLVector(stream, context);
    }

}
