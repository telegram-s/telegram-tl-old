
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesCreateChat extends TLMethod {

    public static final int CLASS_ID = 0x419d9aee;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> users;

    protected String title;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> value) {
        this.users = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.users, stream);
        writeTLString(this.title, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.users = readTLVector(stream, context);
        this.title = readTLString(stream);
    }

}
