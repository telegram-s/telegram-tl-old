
package org.telegram.api.auth;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLCheckedPhone extends TLObject {

    public static final int CLASS_ID = 0xe300cc3b;

    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean phoneRegistered;

    protected boolean phoneInvited;


    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean value) {
        this.phoneRegistered = value;
    }

    public boolean getPhoneInvited() {
        return phoneInvited;
    }

    public void setPhoneInvited(boolean value) {
        this.phoneInvited = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.phoneRegistered, stream);
        writeTLBool(this.phoneInvited, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneRegistered = readTLBool(stream);
        this.phoneInvited = readTLBool(stream);
    }

}
