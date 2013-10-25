
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputMediaUploadedVideo extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x4847d92a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLInputFile file;

    protected int duration;

    protected int w;

    protected int h;


    public org.telegram.api.TLInputFile getFile() {
        return file;
    }

    public void setFile(org.telegram.api.TLInputFile value) {
        this.file = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
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

        writeTLObject(this.file, stream);
        writeInt(this.duration, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (org.telegram.api.TLInputFile)readTLObject(stream, context);
        this.duration = readInt(stream);
        this.w = readInt(stream);
        this.h = readInt(stream);
    }

}
