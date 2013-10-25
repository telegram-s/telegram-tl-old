
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessagesSentMessageLink extends TLAbsSentMessage {
    public static final int CLASS_ID = 0xe9db4a3f;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.tl.TLVector<org.telegram.api.contacts.TLLink> links;


    public org.telegram.tl.TLVector<org.telegram.api.contacts.TLLink> getLinks() {
        return links;
    }

    public void setLinks(org.telegram.tl.TLVector<org.telegram.api.contacts.TLLink> value) {
        this.links = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeInt(this.date, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
        writeTLVector(this.links, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.date = readInt(stream);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
        this.links = readTLVector(stream, context);
    }

}
