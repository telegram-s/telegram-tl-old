
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessagesStatedMessagesLinks extends TLAbsStatedMessages {
    public static final int CLASS_ID = 0x3e74f5c6;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsMessage> messages;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> chats;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;

    protected org.telegram.tl.TLVector<org.telegram.api.contacts.TLLink> links;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(org.telegram.tl.TLVector<org.telegram.api.TLAbsMessage> value) {
        this.messages = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> value) {
        this.chats = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.contacts.TLLink> getLinks() {
        return links;
    }

    public void setLinks(org.telegram.tl.TLVector<org.telegram.api.contacts.TLLink> value) {
        this.links = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.messages, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLVector(this.links, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.messages = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.links = readTLVector(stream, context);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
    }

}
