
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLGeoPoint extends TLAbsGeoPoint {
    public static final int CLASS_ID = 0x2049d70c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected double lon;

    protected double lat;


    public double getLon() {
        return lon;
    }

    public void setLon(double value) {
        this.lon = value;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double value) {
        this.lat = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.lon, stream);
        writeDouble(this.lat, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.lon = readDouble(stream);
        this.lat = readDouble(stream);
    }

}
