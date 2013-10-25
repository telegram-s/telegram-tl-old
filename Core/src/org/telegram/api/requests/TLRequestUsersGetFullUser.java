
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestUsersGetFullUser extends TLMethod {

    public static final int CLASS_ID = 0xca30a5b1;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputUser id;


    public org.telegram.api.TLAbsInputUser getId() {
        return id;
    }

    public void setId(org.telegram.api.TLAbsInputUser value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (org.telegram.api.TLAbsInputUser)readTLObject(stream, context);
    }

}
