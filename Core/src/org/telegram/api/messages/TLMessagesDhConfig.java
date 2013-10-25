
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessagesDhConfig extends TLAbsDhConfig {
    public static final int CLASS_ID = 0x2c221edd;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int g;

    protected byte[] p;

    protected int version;


    public int getG() {
        return g;
    }

    public void setG(int value) {
        this.g = value;
    }

    public byte[] getP() {
        return p;
    }

    public void setP(byte[] value) {
        this.p = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.g, stream);
        writeTLBytes(this.p, stream);
        writeInt(this.version, stream);
        writeTLBytes(this.random, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.g = readInt(stream);
        this.p = readTLBytes(stream);
        this.version = readInt(stream);
        this.random = readTLBytes(stream);
    }

}
