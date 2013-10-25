
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestAuthSendCode extends TLMethod {

    public static final int CLASS_ID = 0x768d5f4d;

    public int getClassId() {
        return CLASS_ID;
    }




    protected String phoneNumber;

    protected int smsType;

    protected int apiId;

    protected String apiHash;

    protected String langCode;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public int getSmsType() {
        return smsType;
    }

    public void setSmsType(int value) {
        this.smsType = value;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int value) {
        this.apiId = value;
    }

    public String getApiHash() {
        return apiHash;
    }

    public void setApiHash(String value) {
        this.apiHash = value;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeInt(this.smsType, stream);
        writeInt(this.apiId, stream);
        writeTLString(this.apiHash, stream);
        writeTLString(this.langCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.smsType = readInt(stream);
        this.apiId = readInt(stream);
        this.apiHash = readTLString(stream);
        this.langCode = readTLString(stream);
    }

}
