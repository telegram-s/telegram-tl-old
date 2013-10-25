
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestGeochatsEditChatPhoto extends TLMethod {

    public static final int CLASS_ID = 0x35d81a95;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLInputGeoChat peer;

    protected org.telegram.api.TLAbsInputChatPhoto photo;


    public org.telegram.api.TLInputGeoChat getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLInputGeoChat value) {
        this.peer = value;
    }

    public org.telegram.api.TLAbsInputChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsInputChatPhoto value) {
        this.photo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLObject(this.photo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLInputGeoChat)readTLObject(stream, context);
        this.photo = (org.telegram.api.TLAbsInputChatPhoto)readTLObject(stream, context);
    }

}
