
package org.telegram.api.contacts;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLFound extends TLObject {

    public static final int CLASS_ID = 0x566000e;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLContactFound> results;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;


    public org.telegram.tl.TLVector<org.telegram.api.TLContactFound> getResults() {
        return results;
    }

    public void setResults(org.telegram.tl.TLVector<org.telegram.api.TLContactFound> value) {
        this.results = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.results, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.results = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }

}
