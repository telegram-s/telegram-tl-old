
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLNearestDc extends TLObject {

    public static final int CLASS_ID = 0x8e1a1775;

    public int getClassId() {
        return CLASS_ID;
    }


    protected String country;

    protected int thisDc;

    protected int nearestDc;


    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int value) {
        this.thisDc = value;
    }

    public int getNearestDc() {
        return nearestDc;
    }

    public void setNearestDc(int value) {
        this.nearestDc = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.country, stream);
        writeInt(this.thisDc, stream);
        writeInt(this.nearestDc, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.country = readTLString(stream);
        this.thisDc = readInt(stream);
        this.nearestDc = readInt(stream);
    }

}
