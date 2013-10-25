
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputMediaUploadedPhoto extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x2dc53a7d;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLInputFile file;


    public org.telegram.api.TLInputFile getFile() {
        return file;
    }

    public void setFile(org.telegram.api.TLInputFile value) {
        this.file = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (org.telegram.api.TLInputFile)readTLObject(stream, context);
    }

}
