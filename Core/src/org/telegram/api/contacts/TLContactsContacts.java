
package org.telegram.api.contacts;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLContactsContacts extends TLAbsContacts {
    public static final int CLASS_ID = 0x6f8b8cb2;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLContact> contacts;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;


    public org.telegram.tl.TLVector<org.telegram.api.TLContact> getContacts() {
        return contacts;
    }

    public void setContacts(org.telegram.tl.TLVector<org.telegram.api.TLContact> value) {
        this.contacts = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.contacts, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.contacts = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }

}
