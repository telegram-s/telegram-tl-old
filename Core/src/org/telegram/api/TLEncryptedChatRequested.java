
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLEncryptedChatRequested extends TLAbsEncryptedChat {
    public static final int CLASS_ID = 0xfda9a7b7;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int date;

    protected int adminId;

    protected int participantId;

    protected byte[] gA;

    protected byte[] nonce;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int value) {
        this.adminId = value;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int value) {
        this.participantId = value;
    }

    public byte[] getGA() {
        return gA;
    }

    public void setGA(byte[] value) {
        this.gA = value;
    }

    public byte[] getNonce() {
        return nonce;
    }

    public void setNonce(byte[] value) {
        this.nonce = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.date, stream);
        writeInt(this.adminId, stream);
        writeInt(this.participantId, stream);
        writeTLBytes(this.gA, stream);
        writeTLBytes(this.nonce, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.accessHash = readLong(stream);
        this.date = readInt(stream);
        this.adminId = readInt(stream);
        this.participantId = readInt(stream);
        this.gA = readTLBytes(stream);
        this.nonce = readTLBytes(stream);
    }

}
