
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdates extends TLAbsUpdates {
    public static final int CLASS_ID = 0x74ae4240;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUpdate> updates;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> chats;

    protected int date;

    protected int seq;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(org.telegram.tl.TLVector<org.telegram.api.TLAbsUpdate> value) {
        this.updates = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(org.telegram.tl.TLVector<org.telegram.api.TLAbsChat> value) {
        this.chats = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.updates, stream);
        writeTLVector(this.users, stream);
        writeTLVector(this.chats, stream);
        writeInt(this.date, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.updates = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.date = readInt(stream);
        this.seq = readInt(stream);
    }

}
