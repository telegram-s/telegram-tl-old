
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestContactsImportContacts extends TLMethod {

    public static final int CLASS_ID = 0xda30b32d;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.tl.TLVector<org.telegram.api.TLInputContact> contacts;

    protected boolean replace;


    public org.telegram.tl.TLVector<org.telegram.api.TLInputContact> getContacts() {
        return contacts;
    }

    public void setContacts(org.telegram.tl.TLVector<org.telegram.api.TLInputContact> value) {
        this.contacts = value;
    }

    public boolean getReplace() {
        return replace;
    }

    public void setReplace(boolean value) {
        this.replace = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.contacts, stream);
        writeTLBool(this.replace, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.contacts = readTLVector(stream, context);
        this.replace = readTLBool(stream);
    }

}
