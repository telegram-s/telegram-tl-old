
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestUsersGetUsers extends TLMethod {

    public static final int CLASS_ID = 0xd91a548;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> id;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> getId() {
        return id;
    }

    public void setId(org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readTLVector(stream, context);
    }

}
