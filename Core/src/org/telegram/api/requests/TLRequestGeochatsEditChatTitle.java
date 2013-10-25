
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsEditChatTitle extends TLMethod {

    public static final int CLASS_ID = 0x4c8e2273;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputGeoChat peer;

    protected String title;

    protected String address;


    public org.telegram.api.TLInputGeoChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputGeoChat value) {
        this.peer = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLString(this.title, stream);
        writeTLString(this.address, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputGeoChat)readTLObject(stream, context);
        this.title = readTLString(stream);
        this.address = readTLString(stream);
    }

}
