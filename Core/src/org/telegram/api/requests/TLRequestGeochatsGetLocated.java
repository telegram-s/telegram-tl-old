
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsGetLocated extends TLMethod {

    public static final int CLASS_ID = 0x7f192d8f;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputGeoPoint geoPoint;

    protected int radius;

    protected int limit;


    public org.telegram.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(org.telegram.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int value) {
        this.radius = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.geoPoint, stream);
        writeInt(this.radius, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.geoPoint = (org.telegram.api.TLAbsInputGeoPoint)readTLObject(stream, context);
        this.radius = readInt(stream);
        this.limit = readInt(stream);
    }

}
