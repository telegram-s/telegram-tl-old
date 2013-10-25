
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLDecryptedMessageMediaGeoPoint extends TLAbsDecryptedMessageMedia {
    public static final int CLASS_ID = 0x35480a59;

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
