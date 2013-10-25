
package org.telegram.api.contacts;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLContactsMyLinkRequested extends TLAbsMyLink {
    public static final int CLASS_ID = 0x6c69efee;

    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean contact;


    public boolean getContact() {
        return contact;
    }

    public void setContact(boolean value) {
        this.contact = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.contact, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.contact = readTLBool(stream);
    }

}
