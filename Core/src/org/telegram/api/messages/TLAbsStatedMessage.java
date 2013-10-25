
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public abstract class TLAbsStatedMessage extends TLObject {

    protected org.telegram.api.TLAbsMessage message;

    protected int pts;

    protected int seq;


    public org.telegram.api.TLAbsMessage getMessage() {
        return message;
    }

    public void setMessage(org.telegram.api.TLAbsMessage value) {
        this.message = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
    }

}
