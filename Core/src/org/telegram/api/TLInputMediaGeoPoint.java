
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputMediaGeoPoint extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xf9c44144;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsInputGeoPoint geoPoint;


    public org.telegram.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(org.telegram.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.geoPoint, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.geoPoint = (org.telegram.api.TLAbsInputGeoPoint)readTLObject(stream, context);
    }

}
