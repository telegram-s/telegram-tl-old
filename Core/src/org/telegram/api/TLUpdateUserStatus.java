
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateUserStatus extends TLAbsUpdate {
    public static final int CLASS_ID = 0x1bfbd823;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected org.telegram.api.TLAbsUserStatus status;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public org.telegram.api.TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(org.telegram.api.TLAbsUserStatus value) {
        this.status = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLObject(this.status, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.status = (org.telegram.api.TLAbsUserStatus)readTLObject(stream, context);
    }

}
