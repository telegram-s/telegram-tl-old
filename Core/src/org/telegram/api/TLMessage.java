
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessage extends TLAbsMessage {
    public static final int CLASS_ID = 0x22eb6aba;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int fromId;

    protected org.telegram.api.TLAbsPeer toId;

    protected boolean out;

    protected boolean unread;

    protected int date;

    protected String message;

    protected org.telegram.api.TLAbsMessageMedia media;


    public int getFromId() {
        return fromId;
    }

    public void setFromId(int value) {
        this.fromId = value;
    }

    public org.telegram.api.TLAbsPeer getToId() {
        return toId;
    }

    public void setToId(org.telegram.api.TLAbsPeer value) {
        this.toId = value;
    }

    public boolean getOut() {
        return out;
    }

    public void setOut(boolean value) {
        this.out = value;
    }

    public boolean getUnread() {
        return unread;
    }

    public void setUnread(boolean value) {
        this.unread = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public org.telegram.api.TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(org.telegram.api.TLAbsMessageMedia value) {
        this.media = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeInt(this.fromId, stream);
        writeTLObject(this.toId, stream);
        writeTLBool(this.out, stream);
        writeTLBool(this.unread, stream);
        writeInt(this.date, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.fromId = readInt(stream);
        this.toId = (org.telegram.api.TLAbsPeer)readTLObject(stream, context);
        this.out = readTLBool(stream);
        this.unread = readTLBool(stream);
        this.date = readInt(stream);
        this.message = readTLString(stream);
        this.media = (org.telegram.api.TLAbsMessageMedia)readTLObject(stream, context);
    }

}
