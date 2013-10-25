
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLChatParticipants extends TLAbsChatParticipants {
    public static final int CLASS_ID = 0x7841b415;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int adminId;

    protected org.telegram.tl.TLVector<org.telegram.api.TLChatParticipant> participants;

    protected int version;


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int value) {
        this.adminId = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLChatParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(org.telegram.tl.TLVector<org.telegram.api.TLChatParticipant> value) {
        this.participants = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.adminId, stream);
        writeTLVector(this.participants, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.adminId = readInt(stream);
        this.participants = readTLVector(stream, context);
        this.version = readInt(stream);
    }

}
