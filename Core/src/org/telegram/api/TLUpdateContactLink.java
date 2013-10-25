
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateContactLink extends TLAbsUpdate {
    public static final int CLASS_ID = 0x51a48a9a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected org.telegram.api.contacts.TLAbsMyLink myLink;

    protected org.telegram.api.contacts.TLAbsForeignLink foreignLink;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public org.telegram.api.contacts.TLAbsMyLink getMyLink() {
        return myLink;
    }

    public void setMyLink(org.telegram.api.contacts.TLAbsMyLink value) {
        this.myLink = value;
    }

    public org.telegram.api.contacts.TLAbsForeignLink getForeignLink() {
        return foreignLink;
    }

    public void setForeignLink(org.telegram.api.contacts.TLAbsForeignLink value) {
        this.foreignLink = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLObject(this.myLink, stream);
        writeTLObject(this.foreignLink, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.myLink = (org.telegram.api.contacts.TLAbsMyLink)readTLObject(stream, context);
        this.foreignLink = (org.telegram.api.contacts.TLAbsForeignLink)readTLObject(stream, context);
    }

}
