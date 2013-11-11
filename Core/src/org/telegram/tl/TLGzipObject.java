package org.telegram.tl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.telegram.tl.StreamingUtils.readTLBytes;
import static org.telegram.tl.StreamingUtils.writeTLBytes;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 02.11.13
 * Time: 6:53
 */
public class TLGzipObject extends TLObject {
    public static final int CLASS_ID = 0x3072CFA1;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLGzipObject(byte[] packedData) {
        this.packedData = packedData;
    }

    public TLGzipObject() {

    }

    private byte[] packedData;

    public byte[] getPackedData() {
        return packedData;
    }

    public void setPackedData(byte[] packedData) {
        this.packedData = packedData;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(packedData, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        packedData = readTLBytes(stream);
    }

    @Override
    public String toString() {
        return "gzip_packed#3072cfa1";
    }
}
