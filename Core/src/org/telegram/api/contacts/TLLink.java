
package org.telegram.api.contacts;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLLink extends TLObject {

    public static final int CLASS_ID = 0xeccea3f5;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.contacts.TLAbsMyLink myLink;

    protected org.telegram.api.contacts.TLAbsForeignLink foreignLink;

    protected org.telegram.api.TLAbsUser user;


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

    public org.telegram.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(org.telegram.api.TLAbsUser value) {
        this.user = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.myLink, stream);
        writeTLObject(this.foreignLink, stream);
        writeTLObject(this.user, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.myLink = (org.telegram.api.contacts.TLAbsMyLink)readTLObject(stream, context);
        this.foreignLink = (org.telegram.api.contacts.TLAbsForeignLink)readTLObject(stream, context);
        this.user = (org.telegram.api.TLAbsUser)readTLObject(stream, context);
    }

}
