
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLPhotoSize extends TLAbsPhotoSize {
    public static final int CLASS_ID = 0x77bfb61b;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsFileLocation location;

    protected int w;

    protected int h;

    protected int size;


    public org.telegram.api.TLAbsFileLocation getLocation() {
        return location;
    }

    public void setLocation(org.telegram.api.TLAbsFileLocation value) {
        this.location = value;
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

    public int getSize() {
        return size;
    }

    public void setSize(int value) {
        this.size = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.type, stream);
        writeTLObject(this.location, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
        writeInt(this.size, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = readTLString(stream);
        this.location = (org.telegram.api.TLAbsFileLocation)readTLObject(stream, context);
        this.w = readInt(stream);
        this.h = readInt(stream);
        this.size = readInt(stream);
    }

}
