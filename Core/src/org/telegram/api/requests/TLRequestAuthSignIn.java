
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestAuthSignIn extends TLMethod {

    public static final int CLASS_ID = 0xbcd51581;

    public int getClassId() {
        return CLASS_ID;
    }




    protected String phoneNumber;

    protected String phoneCodeHash;

    protected String phoneCode;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String value) {
        this.phoneCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeTLString(this.phoneCodeHash, stream);
        writeTLString(this.phoneCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.phoneCodeHash = readTLString(stream);
        this.phoneCode = readTLString(stream);
    }

}
