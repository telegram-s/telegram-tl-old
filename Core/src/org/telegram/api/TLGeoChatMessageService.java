
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLGeoChatMessageService extends TLAbsGeoChatMessage {
    public static final int CLASS_ID = 0xd34fa24e;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int fromId;

    protected int date;

    protected org.telegram.api.TLAbsMessageAction action;


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

    public org.telegram.api.TLAbsMessageAction getAction() {
        return action;
    }

    public void setAction(org.telegram.api.TLAbsMessageAction value) {
        this.action = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.id, stream);
        writeInt(this.fromId, stream);
        writeInt(this.date, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.id = readInt(stream);
        this.fromId = readInt(stream);
        this.date = readInt(stream);
        this.action = (org.telegram.api.TLAbsMessageAction)readTLObject(stream, context);
    }

}
