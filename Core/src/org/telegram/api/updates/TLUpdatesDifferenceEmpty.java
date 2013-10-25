
package org.telegram.api.updates;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdatesDifferenceEmpty extends TLAbsDifference {
    public static final int CLASS_ID = 0x5d75a138;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;

    protected int seq;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.date, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.seq = readInt(stream);
    }

}
