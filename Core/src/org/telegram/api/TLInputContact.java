
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLInputContact extends TLObject {

    public static final int CLASS_ID = 0xf392b7f4;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long clientId;

    protected String phone;

    protected String firstName;

    protected String lastName;


    public long getClientId() {
        return clientId;
    }

    public void setClientId(long value) {
        this.clientId = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.clientId, stream);
        writeTLString(this.phone, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.clientId = readLong(stream);
        this.phone = readTLString(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
    }

}
