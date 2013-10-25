
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateUserPhoto extends TLAbsUpdate {
    public static final int CLASS_ID = 0x95313b0c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int date;

    protected org.telegram.api.TLAbsUserProfilePhoto photo;

    protected boolean previous;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public org.telegram.api.TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsUserProfilePhoto value) {
        this.photo = value;
    }

    public boolean getPrevious() {
        return previous;
    }

    public void setPrevious(boolean value) {
        this.previous = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeTLObject(this.photo, stream);
        writeTLBool(this.previous, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.photo = (org.telegram.api.TLAbsUserProfilePhoto)readTLObject(stream, context);
        this.previous = readTLBool(stream);
    }

}
