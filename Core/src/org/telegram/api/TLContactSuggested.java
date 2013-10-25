
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLContactSuggested extends TLObject {

    public static final int CLASS_ID = 0x3de191a1;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int mutualContacts;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getMutualContacts() {
        return mutualContacts;
    }

    public void setMutualContacts(int value) {
        this.mutualContacts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.mutualContacts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.mutualContacts = readInt(stream);
    }

}
