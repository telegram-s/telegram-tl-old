
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageActionGeoChatCreate extends TLAbsMessageAction {
    public static final int CLASS_ID = 0x6f038ebc;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected String address;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
        writeTLString(this.address, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
        this.address = readTLString(stream);
    }

}
