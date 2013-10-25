
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesGetDhConfig extends TLMethod {

    public static final int CLASS_ID = 0x26cf8950;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int version;

    protected int randomLength;


    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }

    public int getRandomLength() {
        return randomLength;
    }

    public void setRandomLength(int value) {
        this.randomLength = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.version, stream);
        writeInt(this.randomLength, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.version = readInt(stream);
        this.randomLength = readInt(stream);
    }

}
