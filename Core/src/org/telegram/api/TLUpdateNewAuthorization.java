
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateNewAuthorization extends TLAbsUpdate {
    public static final int CLASS_ID = 0x8f06529a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long authKeyId;

    protected int date;

    protected String device;

    protected String location;


    public long getAuthKeyId() {
        return authKeyId;
    }

    public void setAuthKeyId(long value) {
        this.authKeyId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String value) {
        this.device = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String value) {
        this.location = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.authKeyId, stream);
        writeInt(this.date, stream);
        writeTLString(this.device, stream);
        writeTLString(this.location, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.authKeyId = readLong(stream);
        this.date = readInt(stream);
        this.device = readTLString(stream);
        this.location = readTLString(stream);
    }

}
