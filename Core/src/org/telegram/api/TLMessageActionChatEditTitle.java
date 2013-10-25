
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageActionChatEditTitle extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xb5a1ce5a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
    }

}
