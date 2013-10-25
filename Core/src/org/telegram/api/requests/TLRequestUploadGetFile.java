
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestUploadGetFile extends TLMethod {

    public static final int CLASS_ID = 0xe3a6cfb5;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputFileLocation location;

    protected int offset;

    protected int limit;


    public org.telegram.api.TLAbsInputFileLocation getLocation() {
        return location;
    }

    public void setLocation(org.telegram.api.TLAbsInputFileLocation value) {
        this.location = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.location, stream);
        writeInt(this.offset, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.location = (org.telegram.api.TLAbsInputFileLocation)readTLObject(stream, context);
        this.offset = readInt(stream);
        this.limit = readInt(stream);
    }

}
