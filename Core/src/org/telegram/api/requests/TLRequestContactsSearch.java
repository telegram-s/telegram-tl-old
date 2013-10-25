
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestContactsSearch extends TLMethod {

    public static final int CLASS_ID = 0x11f812d8;

    public int getClassId() {
        return CLASS_ID;
    }




    protected String q;

    protected int limit;


    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.q, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.q = readTLString(stream);
        this.limit = readInt(stream);
    }

}
