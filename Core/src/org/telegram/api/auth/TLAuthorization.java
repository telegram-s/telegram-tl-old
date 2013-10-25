
package org.telegram.api.auth;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLAuthorization extends TLObject {

    public static final int CLASS_ID = 0xf6b673a4;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int expires;

    protected org.telegram.api.TLAbsUser user;


    public int getExpires() {
        return expires;
    }

    public void setExpires(int value) {
        this.expires = value;
    }

    public org.telegram.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(org.telegram.api.TLAbsUser value) {
        this.user = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.expires, stream);
        writeTLObject(this.user, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.expires = readInt(stream);
        this.user = (org.telegram.api.TLAbsUser)readTLObject(stream, context);
    }

}
