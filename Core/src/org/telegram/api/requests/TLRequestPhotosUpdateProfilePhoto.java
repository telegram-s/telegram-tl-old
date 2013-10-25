
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestPhotosUpdateProfilePhoto extends TLMethod {

    public static final int CLASS_ID = 0xeef579a0;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputPhoto id;

    protected org.telegram.api.TLAbsInputPhotoCrop crop;


    public org.telegram.api.TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(org.telegram.api.TLAbsInputPhoto value) {
        this.id = value;
    }

    public org.telegram.api.TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(org.telegram.api.TLAbsInputPhotoCrop value) {
        this.crop = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
        writeTLObject(this.crop, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (org.telegram.api.TLAbsInputPhoto)readTLObject(stream, context);
        this.crop = (org.telegram.api.TLAbsInputPhotoCrop)readTLObject(stream, context);
    }

}
