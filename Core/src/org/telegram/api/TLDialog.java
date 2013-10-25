
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLDialog extends TLObject {

    public static final int CLASS_ID = 0x214a8cdf;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsPeer peer;

    protected int topMessage;

    protected int unreadCount;


    public org.telegram.api.TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsPeer value) {
        this.peer = value;
    }

    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int value) {
        this.topMessage = value;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int value) {
        this.unreadCount = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.topMessage, stream);
        writeInt(this.unreadCount, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsPeer)readTLObject(stream, context);
        this.topMessage = readInt(stream);
        this.unreadCount = readInt(stream);
    }

}
