
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesAcceptEncryption extends TLMethod {

    public static final int CLASS_ID = 0x3dbc0415;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputEncryptedChat peer;

    protected byte[] gB;

    protected long keyFingerprint;


    public org.telegram.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public byte[] getGB() {
        return gB;
    }

    public void setGB(byte[] value) {
        this.gB = value;
    }

    public long getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(long value) {
        this.keyFingerprint = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLBytes(this.gB, stream);
        writeLong(this.keyFingerprint, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.gB = readTLBytes(stream);
        this.keyFingerprint = readLong(stream);
    }

}
