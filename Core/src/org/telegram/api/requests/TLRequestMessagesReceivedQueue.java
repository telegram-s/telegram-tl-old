
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesReceivedQueue extends TLMethod {

    public static final int CLASS_ID = 0x55a5bb66;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int maxQts;


    public int getMaxQts() {
        return maxQts;
    }

    public void setMaxQts(int value) {
        this.maxQts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.maxQts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.maxQts = readInt(stream);
    }

}
