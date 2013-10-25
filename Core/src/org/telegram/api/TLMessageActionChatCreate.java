
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageActionChatCreate extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xa6638b9a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected org.telegram.tl.TLIntVector users;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public org.telegram.tl.TLIntVector getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLIntVector value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
        this.users = readTLIntVector(stream);
    }

}
