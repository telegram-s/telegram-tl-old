
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageMediaPhoto extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xc8c45a2a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsPhoto photo;


    public org.telegram.api.TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsPhoto value) {
        this.photo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.photo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photo = (org.telegram.api.TLAbsPhoto)readTLObject(stream, context);
    }

}
