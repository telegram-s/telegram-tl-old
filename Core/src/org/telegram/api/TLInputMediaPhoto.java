
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputMediaPhoto extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x8f2ab2ec;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsInputPhoto id;


    public org.telegram.api.TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(org.telegram.api.TLAbsInputPhoto value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (org.telegram.api.TLAbsInputPhoto)readTLObject(stream, context);
    }

}
