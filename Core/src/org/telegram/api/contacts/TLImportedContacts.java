
package org.telegram.api.contacts;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLImportedContacts extends TLObject {

    public static final int CLASS_ID = 0xd1cd0a4c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLImportedContact> imported;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;


    public org.telegram.tl.TLVector<org.telegram.api.TLImportedContact> getImported() {
        return imported;
    }

    public void setImported(org.telegram.tl.TLVector<org.telegram.api.TLImportedContact> value) {
        this.imported = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.imported, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.imported = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }

}
