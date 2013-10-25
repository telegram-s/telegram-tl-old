
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsSendMessage extends TLMethod {

    public static final int CLASS_ID = 0x61b0044;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputGeoChat peer;

    protected String message;

    protected long randomId;


    public org.telegram.api.TLInputGeoChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputGeoChat value) {
        this.peer = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLString(this.message, stream);
        writeLong(this.randomId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputGeoChat)readTLObject(stream, context);
        this.message = readTLString(stream);
        this.randomId = readLong(stream);
    }

}
