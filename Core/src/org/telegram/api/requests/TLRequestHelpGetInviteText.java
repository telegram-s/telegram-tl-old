
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestHelpGetInviteText extends TLMethod {

    public static final int CLASS_ID = 0xa4a95186;

    public int getClassId() {
        return CLASS_ID;
    }




    protected String langCode;


    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.langCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.langCode = readTLString(stream);
    }

}
