
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLUpdateChatParticipants extends TLAbsUpdate {
    public static final int CLASS_ID = 0x7761198;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsChatParticipants participants;


    public org.telegram.api.TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(org.telegram.api.TLAbsChatParticipants value) {
        this.participants = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.participants, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.participants = (org.telegram.api.TLAbsChatParticipants)readTLObject(stream, context);
    }

}
