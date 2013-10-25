
package org.telegram.api.photos;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLPhoto extends TLObject {

    public static final int CLASS_ID = 0x20212ca8;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsPhoto photo;

    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> users;


    public org.telegram.api.TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsPhoto value) {
        this.photo = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(org.telegram.tl.TLVector<org.telegram.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.photo, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photo = (org.telegram.api.TLAbsPhoto)readTLObject(stream, context);
        this.users = readTLVector(stream, context);
    }

}
