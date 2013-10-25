
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLGeoChatMessage extends TLAbsGeoChatMessage {
    public static final int CLASS_ID = 0x4505f8e1;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int fromId;

    protected int date;

    protected String message;

    protected org.telegram.api.TLAbsMessageMedia media;


    public int getFromId() {
        return fromId;
    }

    public void setFromId(int value) {
        this.fromId = value;
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

        writeInt(this.chatId, stream);
        writeInt(this.id, stream);
        writeInt(this.fromId, stream);
        writeInt(this.date, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.id = readInt(stream);
        this.fromId = readInt(stream);
        this.date = readInt(stream);
        this.message = readTLString(stream);
        this.media = (org.telegram.api.TLAbsMessageMedia)readTLObject(stream, context);
    }

}
