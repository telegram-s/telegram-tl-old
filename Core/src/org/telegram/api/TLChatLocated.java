
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLChatLocated extends TLObject {

    public static final int CLASS_ID = 0x3631cf4c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected int distance;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int value) {
        this.distance = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.distance, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.distance = readInt(stream);
    }

}
