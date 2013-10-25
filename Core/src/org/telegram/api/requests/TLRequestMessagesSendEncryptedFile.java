
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesSendEncryptedFile extends TLMethod {

    public static final int CLASS_ID = 0x9a901b66;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputEncryptedChat peer;

    protected long randomId;

    protected byte[] data;

    protected org.telegram.api.TLAbsInputEncryptedFile file;


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

    public org.telegram.api.TLAbsInputEncryptedFile getFile() {
        return file;
    }

    public void setFile(org.telegram.api.TLAbsInputEncryptedFile value) {
        this.file = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeLong(this.randomId, stream);
        writeTLBytes(this.data, stream);
        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.randomId = readLong(stream);
        this.data = readTLBytes(stream);
        this.file = (org.telegram.api.TLAbsInputEncryptedFile)readTLObject(stream, context);
    }

}
