
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestMessagesSearch extends TLMethod {

    public static final int CLASS_ID = 0x7e9f2ab;

    public int getClassId() {
        return CLASS_ID;
    }




    protected org.telegram.api.TLAbsInputPeer peer;

    protected String q;

    protected org.telegram.api.TLAbsMessagesFilter filter;

    protected int minDate;

    protected int maxDate;

    protected int offset;

    protected int maxId;

    protected int limit;


    public org.telegram.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(org.telegram.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }

    public org.telegram.api.TLAbsMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(org.telegram.api.TLAbsMessagesFilter value) {
        this.filter = value;
    }

    public int getMinDate() {
        return minDate;
    }

    public void setMinDate(int value) {
        this.minDate = value;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int value) {
        this.maxDate = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLString(this.q, stream);
        writeTLObject(this.filter, stream);
        writeInt(this.minDate, stream);
        writeInt(this.maxDate, stream);
        writeInt(this.offset, stream);
        writeInt(this.maxId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (org.telegram.api.TLAbsInputPeer)readTLObject(stream, context);
        this.q = readTLString(stream);
        this.filter = (org.telegram.api.TLAbsMessagesFilter)readTLObject(stream, context);
        this.minDate = readInt(stream);
        this.maxDate = readInt(stream);
        this.offset = readInt(stream);
        this.maxId = readInt(stream);
        this.limit = readInt(stream);
    }

}
