
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageMediaUnsupported extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x29632a36;

    public int getClassId() {
        return CLASS_ID;
    }


    protected byte[] bytes;


    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.bytes = readTLBytes(stream);
    }

}
