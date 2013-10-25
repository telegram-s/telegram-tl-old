
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLChatFull extends TLObject {

    public static final int CLASS_ID = 0x630e61be;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected org.telegram.api.TLAbsChatParticipants participants;

    protected org.telegram.api.TLAbsPhoto chatPhoto;

    protected org.telegram.api.TLAbsPeerNotifySettings notifySettings;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public org.telegram.api.TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(org.telegram.api.TLAbsChatParticipants value) {
        this.participants = value;
    }

    public org.telegram.api.TLAbsPhoto getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(org.telegram.api.TLAbsPhoto value) {
        this.chatPhoto = value;
    }

    public org.telegram.api.TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(org.telegram.api.TLAbsPeerNotifySettings value) {
        this.notifySettings = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLObject(this.participants, stream);
        writeTLObject(this.chatPhoto, stream);
        writeTLObject(this.notifySettings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.participants = (org.telegram.api.TLAbsChatParticipants)readTLObject(stream, context);
        this.chatPhoto = (org.telegram.api.TLAbsPhoto)readTLObject(stream, context);
        this.notifySettings = (org.telegram.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
    }

}
