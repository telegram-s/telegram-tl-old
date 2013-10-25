
package org.telegram.api.messages;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLAffectedHistory extends TLObject {

    public static final int CLASS_ID = 0xb7de36f2;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int pts;

    protected int seq;

    protected int offset;


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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
        writeInt(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.pts = readInt(stream);
        this.seq = readInt(stream);
        this.offset = readInt(stream);
    }

}
