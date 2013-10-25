
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUserProfilePhoto extends TLAbsUserProfilePhoto {
    public static final int CLASS_ID = 0xd559d8c8;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long photoId;

    protected org.telegram.api.TLAbsFileLocation photoSmall;

    protected org.telegram.api.TLAbsFileLocation photoBig;


    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long value) {
        this.photoId = value;
    }

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

        writeLong(this.photoId, stream);
        writeTLObject(this.photoSmall, stream);
        writeTLObject(this.photoBig, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photoId = readLong(stream);
        this.photoSmall = (org.telegram.api.TLAbsFileLocation)readTLObject(stream, context);
        this.photoBig = (org.telegram.api.TLAbsFileLocation)readTLObject(stream, context);
    }

}
