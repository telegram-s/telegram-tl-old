
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUserStatusOnline extends TLAbsUserStatus {
    public static final int CLASS_ID = 0xedb93949;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int expires;


    public int getExpires() {
        return expires;
    }

    public void setExpires(int value) {
        this.expires = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.expires, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.expires = readInt(stream);
    }

}
