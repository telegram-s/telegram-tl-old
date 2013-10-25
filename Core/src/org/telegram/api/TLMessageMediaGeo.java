
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageMediaGeo extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x56e0d474;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsGeoPoint geo;


    public org.telegram.api.TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(org.telegram.api.TLAbsGeoPoint value) {
        this.geo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.geo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.geo = (org.telegram.api.TLAbsGeoPoint)readTLObject(stream, context);
    }

}
