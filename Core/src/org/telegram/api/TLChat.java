
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLChat extends TLAbsChat {
    public static final int CLASS_ID = 0x6e9c9bc7;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected org.telegram.api.TLAbsChatPhoto photo;

    protected int participantsCount;

    protected int date;

    protected boolean left;

    protected int version;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public org.telegram.api.TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsChatPhoto value) {
        this.photo = value;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int value) {
        this.participantsCount = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean value) {
        this.left = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.participantsCount, stream);
        writeInt(this.date, stream);
        writeTLBool(this.left, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.photo = (org.telegram.api.TLAbsChatPhoto)readTLObject(stream, context);
        this.participantsCount = readInt(stream);
        this.date = readInt(stream);
        this.left = readTLBool(stream);
        this.version = readInt(stream);
    }

}
