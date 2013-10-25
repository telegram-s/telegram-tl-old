
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestPhotosUploadProfilePhoto extends TLMethod {

    public static final int CLASS_ID = 0xd50f9c88;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputFile file;

    protected String caption;

    protected org.telegram.api.TLAbsInputGeoPoint geoPoint;

    protected org.telegram.api.TLAbsInputPhotoCrop crop;


    public org.telegram.api.TLInputFile getFile() {
        return file;
    }

    public void setFile(org.telegram.api.TLInputFile value) {
        this.file = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }

    public org.telegram.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(org.telegram.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }

    public org.telegram.api.TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(org.telegram.api.TLAbsInputPhotoCrop value) {
        this.crop = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeTLString(this.caption, stream);
        writeTLObject(this.geoPoint, stream);
        writeTLObject(this.crop, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (org.telegram.api.TLInputFile)readTLObject(stream, context);
        this.caption = readTLString(stream);
        this.geoPoint = (org.telegram.api.TLAbsInputGeoPoint)readTLObject(stream, context);
        this.crop = (org.telegram.api.TLAbsInputPhotoCrop)readTLObject(stream, context);
    }

}
