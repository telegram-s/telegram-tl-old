
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestContactsGetSuggested extends TLMethod {

    public static final int CLASS_ID = 0xcd773428;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int limit;


    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.limit = readInt(stream);
    }

}
