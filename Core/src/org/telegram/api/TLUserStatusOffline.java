
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUserStatusOffline extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x8c703f;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int wasOnline;


    public int getWasOnline() {
        return wasOnline;
    }

    public void setWasOnline(int value) {
        this.wasOnline = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.wasOnline, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.wasOnline = readInt(stream);
    }

}
