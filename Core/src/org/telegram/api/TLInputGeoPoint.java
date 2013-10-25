
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLInputGeoPoint extends TLAbsInputGeoPoint {
    public static final int CLASS_ID = 0xf3b7acc9;

    public int getClassId() {
        return CLASS_ID;
    }


    protected double lat;

    protected double lon;


    public double getLat() {
        return lat;
    }

    public void setLat(double value) {
        this.lat = value;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double value) {
        this.lon = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.lat, stream);
        writeDouble(this.lon, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.lat = readDouble(stream);
        this.lon = readDouble(stream);
    }

}
