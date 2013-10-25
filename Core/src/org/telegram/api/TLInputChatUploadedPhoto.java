
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputChatUploadedPhoto extends TLAbsInputChatPhoto {
    public static final int CLASS_ID = 0x94254732;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLInputFile file;

    protected org.telegram.api.TLAbsInputPhotoCrop crop;


    public org.telegram.api.TLInputFile getFile() {
        return file;
    }

    public void setFile(org.telegram.api.TLInputFile value) {
        this.file = value;
    }

    public org.telegram.api.TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(org.telegram.api.TLAbsInputPhotoCrop value) {
        this.crop = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeTLObject(this.crop, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (org.telegram.api.TLInputFile)readTLObject(stream, context);
        this.crop = (org.telegram.api.TLAbsInputPhotoCrop)readTLObject(stream, context);
    }

}
