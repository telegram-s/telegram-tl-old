
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputPhotoCrop extends TLAbsInputPhotoCrop {
    public static final int CLASS_ID = 0xd9915325;

    public int getClassId() {
        return CLASS_ID;
    }


    protected double cropLeft;

    protected double cropTop;

    protected double cropWidth;


    public double getCropLeft() {
        return cropLeft;
    }

    public void setCropLeft(double value) {
        this.cropLeft = value;
    }

    public double getCropTop() {
        return cropTop;
    }

    public void setCropTop(double value) {
        this.cropTop = value;
    }

    public double getCropWidth() {
        return cropWidth;
    }

    public void setCropWidth(double value) {
        this.cropWidth = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.cropLeft, stream);
        writeDouble(this.cropTop, stream);
        writeDouble(this.cropWidth, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.cropLeft = readDouble(stream);
        this.cropTop = readDouble(stream);
        this.cropWidth = readDouble(stream);
    }

}
