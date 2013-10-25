
package org.telegram.api.contacts;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLContactsForeignLinkRequested extends TLAbsForeignLink {
    public static final int CLASS_ID = 0xa7801f47;

    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean hasPhone;


    public boolean getHasPhone() {
        return hasPhone;
    }

    public void setHasPhone(boolean value) {
        this.hasPhone = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.hasPhone, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hasPhone = readTLBool(stream);
    }

}
