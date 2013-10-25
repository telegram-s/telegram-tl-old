
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUserForeign extends TLAbsUser {
    public static final int CLASS_ID = 0x5214c89d;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String firstName;

    protected String lastName;

    protected long accessHash;

    protected org.telegram.api.TLAbsUserProfilePhoto photo;

    protected org.telegram.api.TLAbsUserStatus status;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public org.telegram.api.TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsUserProfilePhoto value) {
        this.photo = value;
    }

    public org.telegram.api.TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(org.telegram.api.TLAbsUserStatus value) {
        this.status = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
        writeLong(this.accessHash, stream);
        writeTLObject(this.photo, stream);
        writeTLObject(this.status, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
        this.accessHash = readLong(stream);
        this.photo = (org.telegram.api.TLAbsUserProfilePhoto)readTLObject(stream, context);
        this.status = (org.telegram.api.TLAbsUserStatus)readTLObject(stream, context);
    }

}
