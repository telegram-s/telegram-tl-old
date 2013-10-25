
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesSendBroadcast extends TLMethod {

    public static final int CLASS_ID = 0x41bb0972;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> contacts;

    protected String message;

    protected org.telegram.api.TLAbsInputMedia media;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> getContacts() {
        return contacts;
    }

    public void setContacts(org.telegram.tl.TLVector<org.telegram.api.TLAbsInputUser> value) {
        this.contacts = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public org.telegram.api.TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(org.telegram.api.TLAbsInputMedia value) {
        this.media = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.contacts, stream);
        writeTLString(this.message, stream);
        writeTLObject(this.media, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.contacts = readTLVector(stream, context);
        this.message = readTLString(stream);
        this.media = (org.telegram.api.TLAbsInputMedia)readTLObject(stream, context);
    }

}
