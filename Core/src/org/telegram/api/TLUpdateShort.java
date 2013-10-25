
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateShort extends TLAbsUpdates {
    public static final int CLASS_ID = 0x78d4dec1;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsUpdate update;

    protected int date;


    public org.telegram.api.TLAbsUpdate getUpdate() {
        return update;
    }

    public void setUpdate(org.telegram.api.TLAbsUpdate value) {
        this.update = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.update, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.update = (org.telegram.api.TLAbsUpdate)readTLObject(stream, context);
        this.date = readInt(stream);
    }

}
