
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesRequestEncryption extends TLMethod {

    public static final int CLASS_ID = 0xf64daf43;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputUser userId;

    protected int randomId;

    protected byte[] gA;


    public org.telegram.api.TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(org.telegram.api.TLAbsInputUser value) {
        this.userId = value;
    }

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int value) {
        this.randomId = value;
    }

    public byte[] getGA() {
        return gA;
    }

    public void setGA(byte[] value) {
        this.gA = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.userId, stream);
        writeInt(this.randomId, stream);
        writeTLBytes(this.gA, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = (org.telegram.api.TLAbsInputUser)readTLObject(stream, context);
        this.randomId = readInt(stream);
        this.gA = readTLBytes(stream);
    }

}
