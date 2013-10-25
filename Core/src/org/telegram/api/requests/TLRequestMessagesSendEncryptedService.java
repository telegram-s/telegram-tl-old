
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesSendEncryptedService extends TLMethod {

    public static final int CLASS_ID = 0x32d439a4;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputEncryptedChat peer;

    protected long randomId;

    protected byte[] data;


    public org.telegram.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] value) {
        this.data = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeLong(this.randomId, stream);
        writeTLBytes(this.data, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.randomId = readLong(stream);
        this.data = readTLBytes(stream);
    }

}
