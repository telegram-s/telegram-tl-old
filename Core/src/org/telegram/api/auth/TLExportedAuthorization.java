
package org.telegram.api.auth;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLExportedAuthorization extends TLObject {

    public static final int CLASS_ID = 0xdf969c2d;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected byte[] bytes;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.bytes = readTLBytes(stream);
    }

}
