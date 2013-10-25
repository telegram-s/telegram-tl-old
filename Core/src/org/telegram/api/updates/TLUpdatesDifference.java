
package org.telegram.api.updates;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdatesDifference extends TLAbsDifference {
    public static final int CLASS_ID = 0xf49ca0;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsMessage> newMessages;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsEncryptedMessage> newEncryptedMessages;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUpdate> otherUpdates;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> chats;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;

    protected org.telegram.api.updates.TLState state;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsMessage> getNewMessages() {
        return newMessages;
    }

    public void setNewMessages(org.telegram.tl.TLVector<org.telegram.api.TLAbsMessage> value) {
        this.newMessages = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsEncryptedMessage> getNewEncryptedMessages() {
        return newEncryptedMessages;
    }

    public void setNewEncryptedMessages(org.telegram.tl.TLVector<org.telegram.api.TLAbsEncryptedMessage> value) {
        this.newEncryptedMessages = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUpdate> getOtherUpdates() {
        return otherUpdates;
    }

    public void setOtherUpdates(org.telegram.tl.TLVector<org.telegram.api.TLAbsUpdate> value) {
        this.otherUpdates = value;
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

    public org.telegram.api.updates.TLState getState() {
        return state;
    }

    public void setState(org.telegram.api.updates.TLState value) {
        this.state = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.newMessages, stream);
        writeTLVector(this.newEncryptedMessages, stream);
        writeTLVector(this.otherUpdates, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLObject(this.state, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.newMessages = readTLVector(stream, context);
        this.newEncryptedMessages = readTLVector(stream, context);
        this.otherUpdates = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.state = (org.telegram.api.updates.TLState)readTLObject(stream, context);
    }

}
