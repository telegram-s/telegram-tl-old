
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLChatPhoto extends TLAbsChatPhoto {
    public static final int CLASS_ID = 0x6153276a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsFileLocation photoSmall;

    protected org.telegram.api.TLAbsFileLocation photoBig;


    public org.telegram.api.TLAbsFileLocation getPhotoSmall() {
        return photoSmall;
    }

    public void setPhotoSmall(org.telegram.api.TLAbsFileLocation value) {
        this.photoSmall = value;
    }

    public org.telegram.api.TLAbsFileLocation getPhotoBig() {
        return photoBig;
    }

    public void setPhotoBig(org.telegram.api.TLAbsFileLocation value) {
        this.photoBig = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.photoSmall, stream);
        writeTLObject(this.photoBig, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photoSmall = (org.telegram.api.TLAbsFileLocation)readTLObject(stream, context);
        this.photoBig = (org.telegram.api.TLAbsFileLocation)readTLObject(stream, context);
    }

}
