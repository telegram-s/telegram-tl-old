
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesDeleteMessages extends TLMethod {

    public static final int CLASS_ID = 0x14f2dd0a;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.tl.TLIntVector id;


    public org.telegram.tl.TLIntVector getId() {
        return id;
    }

    public void setId(org.telegram.tl.TLIntVector value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLIntVector(stream);
    }

}
