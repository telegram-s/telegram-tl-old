
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsSendMedia extends TLMethod {

    public static final int CLASS_ID = 0xb8f0deff;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputGeoChat peer;

    protected org.telegram.api.TLAbsInputMedia media;

    protected long randomId;


    public org.telegram.api.TLInputGeoChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputGeoChat value) {
        this.peer = value;
    }

    public org.telegram.api.TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(org.telegram.api.TLAbsInputMedia value) {
        this.media = value;
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
        writeTLObject(this.media, stream);
        writeLong(this.randomId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputGeoChat)readTLObject(stream, context);
        this.media = (org.telegram.api.TLAbsInputMedia)readTLObject(stream, context);
        this.randomId = readLong(stream);
    }

}
