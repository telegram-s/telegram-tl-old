
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLWallPaper extends TLAbsWallPaper {
    public static final int CLASS_ID = 0xccb03657;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.TLAbsPhotoSize> sizes;


    public org.telegram.tl.TLVector<org.telegram.api.TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(org.telegram.tl.TLVector<org.telegram.api.TLAbsPhotoSize> value) {
        this.sizes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLVector(this.sizes, stream);
        writeInt(this.color, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.sizes = readTLVector(stream, context);
        this.color = readInt(stream);
    }

}
