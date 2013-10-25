
package org.telegram.api.upload;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLFile extends TLObject {

    public static final int CLASS_ID = 0x96a18d5;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.storage.TLAbsFileType type;

    protected int mtime;

    protected byte[] bytes;


    public org.telegram.api.storage.TLAbsFileType getType() {
        return type;
    }

    public void setType(org.telegram.api.storage.TLAbsFileType value) {
        this.type = value;
    }

    public int getMtime() {
        return mtime;
    }

    public void setMtime(int value) {
        this.mtime = value;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.type, stream);
        writeInt(this.mtime, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = (org.telegram.api.storage.TLAbsFileType)readTLObject(stream, context);
        this.mtime = readInt(stream);
        this.bytes = readTLBytes(stream);
    }

}
