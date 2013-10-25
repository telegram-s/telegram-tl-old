
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLVideo extends TLAbsVideo {
    public static final int CLASS_ID = 0x5a04a49f;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int userId;

    protected int date;

    protected String caption;

    protected int duration;

    protected int size;

    protected org.telegram.api.TLAbsPhotoSize thumb;

    protected int dcId;

    protected int w;

    protected int h;


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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int value) {
        this.size = value;
    }

    public org.telegram.api.TLAbsPhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(org.telegram.api.TLAbsPhotoSize value) {
        this.thumb = value;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int value) {
        this.dcId = value;
    }

    public int getW() {
        return w;
    }

    public void setW(int value) {
        this.w = value;
    }

    public int getH() {
        return h;
    }

    public void setH(int value) {
        this.h = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeTLString(this.caption, stream);
        writeInt(this.duration, stream);
        writeInt(this.size, stream);
        writeTLObject(this.thumb, stream);
        writeInt(this.dcId, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.caption = readTLString(stream);
        this.duration = readInt(stream);
        this.size = readInt(stream);
        this.thumb = (org.telegram.api.TLAbsPhotoSize)readTLObject(stream, context);
        this.dcId = readInt(stream);
        this.w = readInt(stream);
        this.h = readInt(stream);
    }

}
