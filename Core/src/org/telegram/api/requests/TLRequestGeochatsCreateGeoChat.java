
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsCreateGeoChat extends TLMethod {

    public static final int CLASS_ID = 0xe092e16;

    public int getClassId() {
        return CLASS_ID;
    }




    protected String title;

    protected org.telegram.api.TLAbsInputGeoPoint geoPoint;

    protected String address;

    protected String venue;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public org.telegram.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(org.telegram.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String value) {
        this.venue = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
        writeTLObject(this.geoPoint, stream);
        writeTLString(this.address, stream);
        writeTLString(this.venue, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
        this.geoPoint = (org.telegram.api.TLAbsInputGeoPoint)readTLObject(stream, context);
        this.address = readTLString(stream);
        this.venue = readTLString(stream);
    }

}
