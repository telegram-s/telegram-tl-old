
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputMediaVideo extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x7f023ae6;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsInputVideo id;


    public org.telegram.api.TLAbsInputVideo getId() {
        return id;
    }

    public void setId(org.telegram.api.TLAbsInputVideo value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (org.telegram.api.TLAbsInputVideo)readTLObject(stream, context);
    }

}
