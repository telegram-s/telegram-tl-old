
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLPhoto extends TLAbsPhoto {
    public static final int CLASS_ID = 0x22b56751;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int userId;

    protected int date;

    protected String caption;

    protected org.telegram.api.TLAbsGeoPoint geo;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsPhotoSize> sizes;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }

    public org.telegram.api.TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(org.telegram.api.TLAbsGeoPoint value) {
        this.geo = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(org.telegram.tl.TLVector<org.telegram.api.TLAbsPhotoSize> value) {
        this.sizes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeTLString(this.caption, stream);
        writeTLObject(this.geo, stream);
        writeTLVector(this.sizes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.caption = readTLString(stream);
        this.geo = (org.telegram.api.TLAbsGeoPoint)readTLObject(stream, context);
        this.sizes = readTLVector(stream, context);
    }

}
