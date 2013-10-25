
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLInputAppEvent extends TLObject {

    public static final int CLASS_ID = 0x770656a8;

    public int getClassId() {
        return CLASS_ID;
    }


    protected double time;

    protected String type;

    protected long peer;

    protected String data;


    public double getTime() {
        return time;
    }

    public void setTime(double value) {
        this.time = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public long getPeer() {
        return peer;
    }

    public void setPeer(long value) {
        this.peer = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.time, stream);
        writeTLString(this.type, stream);
        writeLong(this.peer, stream);
        writeTLString(this.data, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.time = readDouble(stream);
        this.type = readTLString(stream);
        this.peer = readLong(stream);
        this.data = readTLString(stream);
    }

}
