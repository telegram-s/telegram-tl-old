
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLConfig extends TLObject {

    public static final int CLASS_ID = 0x232d5905;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;

    protected boolean testMode;

    protected int thisDc;

    protected org.telegram.tl.TLVector<org.telegram.api.TLDcOption> dcOptions;

    protected int chatSizeMax;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(boolean value) {
        this.testMode = value;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int value) {
        this.thisDc = value;
    }

    public org.telegram.tl.TLVector<org.telegram.api.TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(org.telegram.tl.TLVector<org.telegram.api.TLDcOption> value) {
        this.dcOptions = value;
    }

    public int getChatSizeMax() {
        return chatSizeMax;
    }

    public void setChatSizeMax(int value) {
        this.chatSizeMax = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.date, stream);
        writeTLBool(this.testMode, stream);
        writeInt(this.thisDc, stream);
        writeTLVector(this.dcOptions, stream);
        writeInt(this.chatSizeMax, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.testMode = readTLBool(stream);
        this.thisDc = readInt(stream);
        this.dcOptions = readTLVector(stream, context);
        this.chatSizeMax = readInt(stream);
    }

}
