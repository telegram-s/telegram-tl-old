
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestAuthExportAuthorization extends TLMethod {

    public static final int CLASS_ID = 0xe5bfffcd;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int dcId;


    public int getDcId() {
        return dcId;
    }

    public void setDcId(int value) {
        this.dcId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.dcId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.dcId = readInt(stream);
    }

}
