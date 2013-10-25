
package org.telegram.api.help;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLInviteText extends TLObject {

    public static final int CLASS_ID = 0x18cb9f78;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.message, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = readTLString(stream);
    }

}
